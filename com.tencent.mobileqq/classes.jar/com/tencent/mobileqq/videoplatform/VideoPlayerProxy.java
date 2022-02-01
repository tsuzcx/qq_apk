package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.videoplatform.api.PlayerState;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.superplayer.view.ISPlayerVideoView.IVideoViewCallBack;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoPlayerProxy
  implements SDKInitListener, ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, ISPlayerVideoView.IVideoViewCallBack
{
  private long bufferEndtime;
  private long bufferStartTime;
  private VideoPlayerInnerCallback mCallback;
  private Context mContext;
  public long mID;
  private PlayProgressChecker mPlayPgsChecker;
  private ISuperPlayer mPlayer;
  private QAReport mReporter;
  boolean mScaleFullScreen;
  public AtomicInteger mState = new AtomicInteger(0);
  private VideoPlayParam mVideoParam;
  private ISPlayerVideoView mVideoView;
  
  public VideoPlayerProxy(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, VideoPlayerInnerCallback paramVideoPlayerInnerCallback, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mID = paramLong;
    this.mVideoParam = paramVideoPlayParam;
    this.mCallback = paramVideoPlayerInnerCallback;
    this.mScaleFullScreen = paramBoolean;
    this.mVideoView = createVideoView();
    init();
  }
  
  private void createMediaPlayer()
  {
    try
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "createMediaPlayer");
      }
      if (this.mVideoParam == null)
      {
        LogUtil.e(getLogTag(), 1, "createMediaPlayer, mVideoParam is null.");
        return;
      }
      changeState(3);
      this.mPlayer = SuperPlayerFactory.createMediaPlayer(this.mContext.getApplicationContext(), this.mVideoParam.mSceneId, this.mVideoView);
      if (this.mScaleFullScreen) {
        this.mPlayer.setXYaxis(2);
      } else {
        this.mPlayer.setXYaxis(0);
      }
      this.mPlayer.setOnVideoPreparedListener(this);
      this.mPlayer.setOnCompletionListener(this);
      this.mPlayer.setOnSeekCompleteListener(this);
      this.mPlayer.setOnInfoListener(this);
      this.mPlayer.setOnErrorListener(this);
      this.mPlayer.setOnCaptureImageListener(this);
      if (this.mVideoView != null) {
        this.mVideoView.addViewCallBack(this);
      }
      return;
    }
    finally {}
  }
  
  private ISPlayerVideoView createVideoView()
  {
    return SuperPlayerFactory.createPlayerVideoView(this.mContext.getApplicationContext());
  }
  
  private void doOnAllDownloadFinish()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "doOnAllDownloadFinish.");
    }
    VideoPlayerInnerCallback localVideoPlayerInnerCallback = this.mCallback;
    if (localVideoPlayerInnerCallback != null) {
      localVideoPlayerInnerCallback.onDownloadComplete(this.mID);
    }
  }
  
  private void doOnBufferEnd()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "doOnBufferEnd.");
    }
    this.bufferEndtime = System.currentTimeMillis();
    if ((this.bufferStartTime > 0L) && (this.bufferEndtime > 0L))
    {
      QAReport localQAReport = this.mReporter;
      if (localQAReport != null) {
        localQAReport.totalBufferingDuration += this.bufferEndtime - this.bufferStartTime;
      }
    }
    this.bufferStartTime = 0L;
    this.bufferEndtime = 0L;
    try
    {
      if (this.mState.get() == 6) {
        return;
      }
      changeState(4);
      return;
    }
    finally {}
  }
  
  private void doOnBufferStart()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "doOnBufferStart.");
    }
    QAReport localQAReport = this.mReporter;
    if (localQAReport != null) {
      localQAReport.bufferCount += 1L;
    }
    this.bufferStartTime = System.currentTimeMillis();
    try
    {
      if (this.mState.get() == 6) {
        return;
      }
      changeState(5);
      return;
    }
    finally {}
  }
  
  private void doOnCurLoopEnd()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "doOnCurLoopEnd.");
    }
    VideoPlayerInnerCallback localVideoPlayerInnerCallback = this.mCallback;
    if (localVideoPlayerInnerCallback != null)
    {
      ISuperPlayer localISuperPlayer = this.mPlayer;
      if (localISuperPlayer != null) {
        localVideoPlayerInnerCallback.onLoopBack(this.mID, localISuperPlayer.getCurrentPositionMs());
      }
    }
  }
  
  private void doOnDownProgressUpdate(Object paramObject)
  {
    if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
    {
      long l = ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).currentDownloadSize;
      if (LogUtil.isColorLevel())
      {
        paramObject = getLogTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("doOnDownProgressUpdate, curDownSize =  ");
        localStringBuilder.append(l);
        LogUtil.d(paramObject, 2, localStringBuilder.toString());
      }
      paramObject = this.mCallback;
      if (paramObject != null) {
        paramObject.onDownloadProgress(this.mID, l);
      }
    }
  }
  
  private void doOnFirstFrameRendered()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "doOnFirstFrameRendered.");
    }
    Object localObject = this.mReporter;
    if ((localObject != null) && (((QAReport)localObject).firstRenderTime == 0L)) {
      this.mReporter.firstRenderTime = System.currentTimeMillis();
    }
    localObject = this.mCallback;
    if (localObject != null) {
      ((VideoPlayerInnerCallback)localObject).onFirstFrameRendered(this.mID);
    }
  }
  
  private void doOnVideoDecoderType(long paramLong)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "doOnVideoDecoderType.");
    }
    if (paramLong == 102L)
    {
      QAReport localQAReport = this.mReporter;
      if (localQAReport != null)
      {
        localQAReport.lastTryDecoderMode = 102;
        localQAReport.isMediaCodec = 1;
      }
    }
  }
  
  private void doPlay()
  {
    if (this.mPlayer != null)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "play, mPlayer != null ");
      }
      if (this.mState.get() == 6)
      {
        if (LogUtil.isColorLevel())
        {
          String str = getLogTag();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("play, mPlayer.isPausing() =  ");
          localStringBuilder.append(this.mPlayer.isPausing());
          LogUtil.d(str, 2, localStringBuilder.toString());
        }
        startPlayer();
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "play, startPlayer() ");
        }
      }
      else
      {
        openPlayer();
      }
    }
    else
    {
      createMediaPlayer();
      openPlayer();
    }
  }
  
  private void init()
  {
    try
    {
      if (!VideoPlaySDKManager.getInstance().isSDKReady())
      {
        changeState(1);
        VideoPlaySDKManager.getInstance().initSDKAsync(this.mContext, this);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void logPlayDoNothing()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "play, do nothing.");
    }
    if ((this.mPlayer != null) && (LogUtil.isColorLevel()))
    {
      String str = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play, mPlayer.isPlaying() = ");
      localStringBuilder.append(this.mPlayer.isPlaying());
      LogUtil.d(str, 2, localStringBuilder.toString());
    }
  }
  
  private void openPlayer()
  {
    try
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "openPlayer ");
      }
      this.mReporter = new QAReport();
      this.mReporter.videoPlayParam = this.mVideoParam;
      this.mReporter.openPlayerTime = System.currentTimeMillis();
      if ((this.mPlayer != null) && (this.mVideoParam != null))
      {
        changeState(3);
        if (this.mVideoParam.mMaxPlayTimeMs > 0L) {
          this.mPlayer.setLoopback(this.mVideoParam.mIsLoop, 0L, this.mVideoParam.mMaxPlayTimeMs);
        } else {
          this.mPlayer.setLoopback(this.mVideoParam.mIsLoop);
        }
        this.mPlayer.setOutputMute(this.mVideoParam.mIsMute);
        Object localObject1;
        Object localObject3;
        if (this.mVideoParam.mIsLocal)
        {
          if (this.mVideoParam.mVideoPath != null)
          {
            localObject1 = SuperPlayerFactory.createVideoInfoForUrl(this.mVideoParam.mVideoPath, this.mVideoParam.mVideoFormat, this.mVideoParam.mFileID);
            this.mPlayer.openMediaPlayer(this.mContext, (SuperPlayerVideoInfo)localObject1, this.mVideoParam.mStartPlayPosMs);
            this.mVideoParam.mLastPlayPosMs = 0L;
            localObject1 = getLogTag();
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("openPlayer, videoPath = ");
            ((StringBuilder)localObject3).append(this.mVideoParam.mVideoPath);
            LogUtil.d((String)localObject1, 2, ((StringBuilder)localObject3).toString());
          }
        }
        else if (this.mVideoParam.mUrls != null)
        {
          localObject1 = SuperPlayerFactory.createVideoInfoForUrl(this.mVideoParam.mUrls, this.mVideoParam.mVideoFormat, this.mVideoParam.mFileID, this.mVideoParam.mSavePath);
          ((SuperPlayerVideoInfo)localObject1).setCookies(this.mVideoParam.mCookies);
          this.mPlayer.openMediaPlayer(this.mContext, (SuperPlayerVideoInfo)localObject1, this.mVideoParam.mStartPlayPosMs);
          this.mVideoParam.mLastPlayPosMs = 0L;
          if (LogUtil.isColorLevel())
          {
            localObject1 = new StringBuilder();
            localObject3 = this.mVideoParam.mUrls;
            int j = localObject3.length;
            int i = 0;
            while (i < j)
            {
              ((StringBuilder)localObject1).append(localObject3[i]);
              ((StringBuilder)localObject1).append(" ; ");
              i += 1;
            }
            localObject3 = getLogTag();
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("openPlayer, mVideoParam.mSavePath = ");
            localStringBuilder.append(this.mVideoParam.mSavePath);
            localStringBuilder.append(" urls = ");
            localStringBuilder.append(((StringBuilder)localObject1).toString());
            LogUtil.d((String)localObject3, 2, localStringBuilder.toString());
          }
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  private void startCheckPlayProgress()
  {
    Object localObject = this.mVideoParam;
    if ((localObject != null) && (((VideoPlayParam)localObject).mNeedPlayProgress))
    {
      localObject = this.mPlayPgsChecker;
      if (localObject == null) {
        this.mPlayPgsChecker = new PlayProgressChecker(this.mID, this.mPlayer, this.mCallback);
      } else {
        ((PlayProgressChecker)localObject).mPlayer = this.mPlayer;
      }
      this.mPlayPgsChecker.start();
    }
  }
  
  private void startPlayer()
  {
    try
    {
      ThreadUtil.postOnSubThread(new VideoPlayerProxy.3(this));
      if (this.mPlayer != null)
      {
        this.mPlayer.start();
        changeState(4);
        startCheckPlayProgress();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void stopCheckPlayProgress()
  {
    PlayProgressChecker localPlayProgressChecker = this.mPlayPgsChecker;
    if (localPlayProgressChecker != null) {
      localPlayProgressChecker.stop();
    }
  }
  
  public void captureCurFrame(long paramLong, int paramInt1, int paramInt2)
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      try
      {
        localISuperPlayer.captureImageInTime(paramLong, paramInt1, paramInt2);
        return;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        LogUtil.e(getLogTag(), 2, "captuerCurFrame", localIllegalAccessException);
      }
    }
  }
  
  protected void changeState(int paramInt)
  {
    if (paramInt != this.mState.get())
    {
      if (LogUtil.isColorLevel())
      {
        String str = getLogTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("changeState() , newState = ");
        localStringBuilder.append(PlayerState.getStateStr(paramInt));
        LogUtil.d(str, 2, localStringBuilder.toString());
      }
      this.mState.set(paramInt);
      ThreadUtil.postOnUIThread(new VideoPlayerProxy.5(this, paramInt));
    }
  }
  
  public long getCurPostionMs()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.mPlayer != null)
      {
        l1 = l2;
        if (this.mPlayer.isPlaying()) {
          l1 = this.mPlayer.getCurrentPositionMs();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(getLogTag(), 1, "getCurPlayingPos() error .", localThrowable);
      l1 = l2;
    }
    if (LogUtil.isColorLevel())
    {
      String str = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurPlayingPos() curPosi = ");
      localStringBuilder.append(l1);
      LogUtil.d(str, 2, localStringBuilder.toString());
    }
    return l1;
  }
  
  protected long getLogId()
  {
    return this.mID;
  }
  
  protected String getLogTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlatForm]VideoPlayerProxy[");
    localStringBuilder.append(getLogId());
    localStringBuilder.append("][state:");
    localStringBuilder.append(PlayerState.getStateStr(this.mState.get()));
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public long getVideoDurationMs()
  {
    Object localObject = this.mPlayer;
    long l1;
    if (localObject != null) {
      l1 = ((ISuperPlayer)localObject).getDurationMs();
    } else {
      l1 = 0L;
    }
    long l2 = l1;
    if (l1 <= 0L)
    {
      localObject = this.mVideoParam;
      l2 = l1;
      if (localObject != null) {
        l2 = ((VideoPlayParam)localObject).mVideoFileTimeMs;
      }
    }
    return l2;
  }
  
  public VideoPlayParam getVideoParam()
  {
    return this.mVideoParam;
  }
  
  public View getVideoView()
  {
    return (View)this.mVideoView;
  }
  
  public boolean isMute()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isOutputMute();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      return localISuperPlayer.isPlaying();
    }
    return false;
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    if (LogUtil.isColorLevel())
    {
      paramISuperPlayer = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCaptureImageSucceed() , id = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , errCode = ");
      localStringBuilder.append(paramInt2);
      LogUtil.e(paramISuperPlayer, 2, localStringBuilder.toString());
    }
    paramISuperPlayer = this.mCallback;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.onCapFrame(paramInt1, false, 0, 0, null);
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (LogUtil.isColorLevel())
    {
      paramISuperPlayer = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCaptureImageSucceed(), id = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" , width = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(" , height = ");
      localStringBuilder.append(paramInt3);
      LogUtil.d(paramISuperPlayer, 2, localStringBuilder.toString());
    }
    paramISuperPlayer = this.mCallback;
    if (paramISuperPlayer != null) {
      paramISuperPlayer.onCapFrame(paramInt1, true, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    try
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "onCompletion.");
      }
      changeState(8);
      if (this.mReporter != null) {
        this.mReporter.doReport(true);
      }
      release(false, false);
      return;
    }
    finally {}
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    try
    {
      paramISuperPlayer = new StringBuilder();
      paramISuperPlayer.append("errorModule=");
      paramISuperPlayer.append(paramInt1);
      paramISuperPlayer.append("errorType = ");
      paramISuperPlayer.append(paramInt2);
      paramISuperPlayer.append(" , errorCode = ");
      paramISuperPlayer.append(paramInt3);
      paramISuperPlayer.append(" ,extraInfo = ");
      paramISuperPlayer.append(paramString);
      paramISuperPlayer = paramISuperPlayer.toString();
      String str = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onError, ");
      localStringBuilder.append(paramISuperPlayer);
      LogUtil.d(str, 1, localStringBuilder.toString());
      changeState(7);
      if (this.mCallback != null) {
        this.mCallback.onPlayError(this.mID, paramInt1, paramInt2, paramInt3, paramString);
      }
      if (this.mReporter != null)
      {
        this.mReporter.errCode = paramInt3;
        this.mReporter.errType = paramInt2;
        this.mReporter.errModule = paramInt1;
        this.mReporter.errDetailInfo = paramString;
      }
      release(false, true);
      return false;
    }
    finally {}
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    if (LogUtil.isColorLevel())
    {
      paramISuperPlayer = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onInfo, msg = ");
      localStringBuilder.append(paramInt);
      LogUtil.d(paramISuperPlayer, 2, localStringBuilder.toString());
    }
    if (paramInt != 105)
    {
      if (paramInt != 108)
      {
        if (paramInt != 115)
        {
          if (paramInt != 201)
          {
            if (paramInt != 207)
            {
              if (paramInt != 112)
              {
                if (paramInt == 113) {
                  doOnBufferEnd();
                }
              }
              else {
                doOnBufferStart();
              }
            }
            else {
              doOnDownProgressUpdate(paramObject);
            }
          }
          else {
            doOnAllDownloadFinish();
          }
        }
        else {
          doOnVideoDecoderType(paramLong1);
        }
      }
      else {
        doOnCurLoopEnd();
      }
    }
    else {
      doOnFirstFrameRendered();
    }
    return false;
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    try
    {
      if (LogUtil.isColorLevel())
      {
        String str = getLogTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSDKInited, isSucceed =  ");
        localStringBuilder.append(paramBoolean);
        LogUtil.d(str, 2, localStringBuilder.toString());
      }
      ThreadUtil.postOnUIThread(new VideoPlayerProxy.4(this));
      return;
    }
    finally {}
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "onSeekComplete");
    }
  }
  
  public void onSurfaceChanged(Object paramObject) {}
  
  public void onSurfaceCreated(Object paramObject) {}
  
  public void onSurfaceDestroy(Object paramObject)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.e(getLogTag(), 2, "onSurfaceDestroy() ");
    }
    paramObject = this.mCallback;
    if (paramObject != null) {
      paramObject.onSurfaceDestroy(this.mID);
    }
    release(false, false);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (LogUtil.isColorLevel())
    {
      paramISuperPlayer = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onVideoPrepared, mPlayer == null ? ");
      boolean bool;
      if (this.mPlayer == null) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      LogUtil.d(paramISuperPlayer, 2, localStringBuilder.toString());
    }
    try
    {
      if ((this.mState.get() == 5) || (this.mState.get() == 3))
      {
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "onVideoPrepared, startPlayer.");
        }
        startPlayer();
      }
      return;
    }
    finally {}
  }
  
  public void pause()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "pause");
    }
    try
    {
      if ((this.mState.get() == 4) || (this.mState.get() == 5) || (this.mState.get() == 3)) {
        changeState(6);
      }
      ThreadUtil.postOnSubThread(new VideoPlayerProxy.2(this));
      return;
    }
    finally {}
  }
  
  public void pauseDownload()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.pauseDownload();
    }
  }
  
  public void play()
  {
    try
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "play");
      }
      if (!VideoPlaySDKManager.getInstance().isSDKReady())
      {
        VideoPlaySDKManager.getInstance().addSDKInstalledListener(this);
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "play, sdk not ready, return.");
        }
        return;
      }
      if ((this.mState.get() != 4) && (this.mState.get() != 5) && (this.mState.get() != 3)) {
        doPlay();
      } else {
        logPlayDoNothing();
      }
      return;
    }
    finally {}
  }
  
  public void release(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "releasePlayer");
    }
    try
    {
      if (this.mState.get() == 9)
      {
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "has released, do nothing.");
        }
        return;
      }
      changeState(9);
      stopCheckPlayProgress();
      Object localObject1 = this.mReporter;
      if (localObject1 != null) {
        ((QAReport)localObject1).doReport(paramBoolean2 ^ true);
      }
      localObject1 = this.mVideoView;
      if (localObject1 != null) {
        ((ISPlayerVideoView)localObject1).removeViewCallBack(this);
      }
      ThreadUtil.postOnSubThread(new VideoPlayerProxy.1(this, paramBoolean1));
      VideoPlaySDKManager.getInstance().removeSDKInstalledListener(this);
      return;
    }
    finally {}
  }
  
  public void resumeDownload()
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.resumeDownload();
    }
  }
  
  public void seekTo(int paramInt)
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.seekTo(paramInt);
    }
  }
  
  public void setID(long paramLong)
  {
    this.mID = paramLong;
    PlayProgressChecker localPlayProgressChecker = this.mPlayPgsChecker;
    if (localPlayProgressChecker != null) {
      localPlayProgressChecker.setId(paramLong);
    }
  }
  
  public void setMute(boolean paramBoolean)
  {
    ISuperPlayer localISuperPlayer = this.mPlayer;
    if (localISuperPlayer != null) {
      localISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public void setVideoParam(VideoPlayParam paramVideoPlayParam)
  {
    this.mVideoParam = paramVideoPlayParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy
 * JD-Core Version:    0.7.0.1
 */