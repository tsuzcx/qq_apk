package com.tencent.mobileqq.videoplatform;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.videoplatform.api.PlayerState;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
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
  private VideoPlayerCallback mCallback;
  private Context mContext;
  public long mID;
  private PlayProgressChecker mPlayPgsChecker;
  private ISuperPlayer mPlayer;
  private QAReport mReporter;
  boolean mScaleFullScreen;
  public AtomicInteger mState = new AtomicInteger(0);
  private VideoPlayParam mVideoParam;
  private View mVideoView;
  
  public VideoPlayerProxy(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, VideoPlayerCallback paramVideoPlayerCallback, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mID = paramLong;
    this.mVideoParam = paramVideoPlayParam;
    this.mCallback = paramVideoPlayerCallback;
    this.mScaleFullScreen = paramBoolean;
    init();
  }
  
  private void createMediaPlayer()
  {
    for (;;)
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
        this.mPlayer = SuperPlayerFactory.createMediaPlayer(this.mContext.getApplicationContext(), this.mVideoParam.mSceneId, (ISPlayerVideoView)this.mVideoView);
        if (this.mScaleFullScreen)
        {
          this.mPlayer.setXYaxis(2);
          this.mPlayer.setOnVideoPreparedListener(this);
          this.mPlayer.setOnCompletionListener(this);
          this.mPlayer.setOnSeekCompleteListener(this);
          this.mPlayer.setOnInfoListener(this);
          this.mPlayer.setOnErrorListener(this);
          this.mPlayer.setOnCaptureImageListener(this);
        }
        else
        {
          this.mPlayer.setXYaxis(0);
        }
      }
      finally {}
    }
  }
  
  private View createVideoView()
  {
    ISPlayerVideoView localISPlayerVideoView = SuperPlayerFactory.createPlayerVideoView(this.mContext.getApplicationContext());
    localISPlayerVideoView.addViewCallBack(this);
    return (View)localISPlayerVideoView;
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 186	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:getInstance	()Lcom/tencent/mobileqq/videoplatform/VideoPlaySDKManager;
    //   5: invokevirtual 189	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:isSDKReady	()Z
    //   8: ifeq +14 -> 22
    //   11: aload_0
    //   12: aload_0
    //   13: invokespecial 96	com/tencent/mobileqq/videoplatform/VideoPlayerProxy:createVideoView	()Landroid/view/View;
    //   16: putfield 89	com/tencent/mobileqq/videoplatform/VideoPlayerProxy:mVideoView	Landroid/view/View;
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: iconst_1
    //   24: invokevirtual 122	com/tencent/mobileqq/videoplatform/VideoPlayerProxy:changeState	(I)V
    //   27: invokestatic 186	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:getInstance	()Lcom/tencent/mobileqq/videoplatform/VideoPlaySDKManager;
    //   30: aload_0
    //   31: getfield 56	com/tencent/mobileqq/videoplatform/VideoPlayerProxy:mContext	Landroid/content/Context;
    //   34: aload_0
    //   35: invokevirtual 193	com/tencent/mobileqq/videoplatform/VideoPlaySDKManager:initSDKAsync	(Landroid/content/Context;Lcom/tencent/mobileqq/videoplatform/SDKInitListener;)V
    //   38: goto -19 -> 19
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	46	0	this	VideoPlayerProxy
    //   41	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	41	finally
    //   22	38	41	finally
  }
  
  private void openPlayer()
  {
    for (;;)
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
          if (this.mVideoParam.mMaxPlayTimeMs <= 0L) {
            continue;
          }
          this.mPlayer.setLoopback(this.mVideoParam.mIsLoop, 0L, this.mVideoParam.mMaxPlayTimeMs);
          this.mPlayer.setOutputMute(this.mVideoParam.mIsMute);
          if (!this.mVideoParam.mIsLocal) {
            break label244;
          }
          if (this.mVideoParam.mVideoPath != null)
          {
            SuperPlayerVideoInfo localSuperPlayerVideoInfo = SuperPlayerFactory.createVideoInfoForUrl(this.mVideoParam.mVideoPath, 101, this.mVideoParam.mFileID);
            this.mPlayer.openMediaPlayer(this.mContext, localSuperPlayerVideoInfo, 0L);
            this.mVideoParam.mLastPlayPosMs = 0L;
            LogUtil.d(getLogTag(), 2, "openPlayer, videoPath = " + this.mVideoParam.mVideoPath);
          }
        }
        return;
        this.mPlayer.setLoopback(this.mVideoParam.mIsLoop);
        continue;
        if (this.mVideoParam.mUrls == null) {
          continue;
        }
      }
      finally {}
      label244:
      Object localObject2 = SuperPlayerFactory.createVideoInfoForUrl(this.mVideoParam.mUrls, 101, this.mVideoParam.mFileID, this.mVideoParam.mSavePath);
      this.mPlayer.openMediaPlayer(this.mContext, (SuperPlayerVideoInfo)localObject2, 0L);
      this.mVideoParam.mLastPlayPosMs = 0L;
      if (LogUtil.isColorLevel())
      {
        localObject2 = new StringBuilder();
        String[] arrayOfString = this.mVideoParam.mUrls;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          ((StringBuilder)localObject2).append(arrayOfString[i]).append(" ; ");
          i += 1;
        }
        LogUtil.d(getLogTag(), 2, "openPlayer, mVideoParam.mSavePath = " + this.mVideoParam.mSavePath + " urls = " + ((StringBuilder)localObject2).toString());
      }
    }
  }
  
  private void startCheckPlayProgress()
  {
    if ((this.mVideoParam != null) && (this.mVideoParam.mNeedPlayProgress))
    {
      if (this.mPlayPgsChecker != null) {
        break label55;
      }
      this.mPlayPgsChecker = new PlayProgressChecker(this.mID, this.mPlayer, this.mCallback);
    }
    for (;;)
    {
      this.mPlayPgsChecker.start();
      return;
      label55:
      this.mPlayPgsChecker.mPlayer = this.mPlayer;
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
    if (this.mPlayPgsChecker != null) {
      this.mPlayPgsChecker.stop();
    }
  }
  
  public void captureCurFrame(long paramLong, int paramInt1, int paramInt2)
  {
    if (this.mPlayer != null) {}
    try
    {
      this.mPlayer.captureImageInTime(paramLong, paramInt1, paramInt2);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      LogUtil.e(getLogTag(), 2, "captuerCurFrame", localIllegalAccessException);
    }
  }
  
  protected void changeState(int paramInt)
  {
    VideoPlayerProxy.5 local5;
    if (paramInt != this.mState.get())
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "changeState() , newState = " + PlayerState.getStateStr(paramInt));
      }
      this.mState.set(paramInt);
      local5 = new VideoPlayerProxy.5(this, paramInt);
      if (paramInt == 4) {
        ThreadUtil.postOnUIThreadDelayed(local5, 300L);
      }
    }
    else
    {
      return;
    }
    ThreadUtil.postOnUIThread(local5);
  }
  
  public long getCurPostionMs()
  {
    l2 = -1L;
    l1 = l2;
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
      for (;;)
      {
        l1 = l2;
      }
    }
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "getCurPlayingPos() curPosi = " + l1);
    }
    return l1;
  }
  
  protected long getLogId()
  {
    return this.mID;
  }
  
  protected String getLogTag()
  {
    return "[VideoPlatForm]VideoPlayerProxy[" + getLogId() + "][state:" + PlayerState.getStateStr(this.mState.get()) + "]";
  }
  
  public long getVideoDurationMs()
  {
    if (this.mPlayer != null) {}
    for (long l1 = this.mPlayer.getDurationMs();; l1 = 0L)
    {
      long l2 = l1;
      if (l1 <= 0L)
      {
        l2 = l1;
        if (this.mVideoParam != null) {
          l2 = this.mVideoParam.mVideoFileTimeMs;
        }
      }
      return l2;
    }
  }
  
  public VideoPlayParam getVideoParam()
  {
    return this.mVideoParam;
  }
  
  public View getVideoView()
  {
    return this.mVideoView;
  }
  
  public boolean isPlaying()
  {
    if (this.mPlayer != null) {
      return this.mPlayer.isPlaying();
    }
    return false;
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.e(getLogTag(), 2, "onCaptureImageSucceed() , id = " + paramInt1 + " , errCode = " + paramInt2);
    }
    if (this.mCallback != null) {
      this.mCallback.onCapFrame(paramInt1, false, 0, 0, null);
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "onCaptureImageSucceed(), id = " + paramInt1 + " , width = " + paramInt2 + " , height = " + paramInt3);
    }
    if (this.mCallback != null) {
      this.mCallback.onCapFrame(paramInt1, true, paramInt2, paramInt3, paramBitmap);
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
      paramISuperPlayer = "errorModule=" + paramInt1 + "errorType = " + paramInt2 + " , errorCode = " + paramInt3 + " ,extraInfo = " + paramString;
      LogUtil.d(getLogTag(), 1, "onError, " + paramISuperPlayer);
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
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "onInfo, msg = " + paramInt);
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      return false;
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_FIRST_VIDEO_FRAME_RENDERED ");
      }
      if ((this.mReporter != null) && (this.mReporter.firstRenderTime == 0L))
      {
        this.mReporter.firstRenderTime = System.currentTimeMillis();
        continue;
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_VIDEO_DECODER_TYPE ");
        }
        if ((paramLong1 == 102L) && (this.mReporter != null))
        {
          this.mReporter.lastTryDecoderMode = 102;
          this.mReporter.isMediaCodec = 1;
          continue;
          if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_BUFFERING_START ");
          }
          if (this.mReporter != null)
          {
            paramISuperPlayer = this.mReporter;
            paramISuperPlayer.bufferCount += 1L;
          }
          this.bufferStartTime = System.currentTimeMillis();
          try
          {
            if (this.mState.get() == 6) {
              continue;
            }
          }
          finally {}
          changeState(5);
          continue;
          if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_BUFFERING_END ");
          }
          this.bufferEndtime = System.currentTimeMillis();
          if ((this.bufferStartTime > 0L) && (this.bufferEndtime > 0L) && (this.mReporter != null))
          {
            paramISuperPlayer = this.mReporter;
            paramISuperPlayer.totalBufferingDuration += this.bufferEndtime - this.bufferStartTime;
          }
          this.bufferStartTime = 0L;
          this.bufferEndtime = 0L;
          try
          {
            if (this.mState.get() == 6) {
              continue;
            }
          }
          finally {}
          changeState(4);
          continue;
          if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_ALL_DOWNLOAD_FINISH ");
          }
          if (this.mCallback != null)
          {
            this.mCallback.onDownloadComplete(this.mID);
            continue;
            if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
            {
              paramLong1 = ((TPPlayerMsg.TPDownLoadProgressInfo)paramObject).currentDownloadSize;
              if (LogUtil.isColorLevel()) {
                LogUtil.d(getLogTag(), 2, "onInfo, SuperPlayerMsg.TP_PLAYER_INFO_OBJECT_DOWNLOAD_PROGRESS_UPDATE, currentDownloadSize =  " + paramLong1);
              }
              if (this.mCallback != null)
              {
                this.mCallback.onDownloadProgress(this.mID, paramLong1);
                continue;
                if (LogUtil.isColorLevel()) {
                  LogUtil.d(getLogTag(), 2, "onInfo, SuperPlayerMsg.PLAYER_INFO_CURRENT_LOOP_END ");
                }
                if ((this.mCallback != null) && (this.mPlayer != null)) {
                  this.mCallback.onLoopBack(this.mID, this.mPlayer.getCurrentPositionMs());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    try
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "onSDKInited, isSucceed =  " + paramBoolean);
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
    release(false, false);
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    StringBuilder localStringBuilder;
    if (LogUtil.isColorLevel())
    {
      paramISuperPlayer = getLogTag();
      localStringBuilder = new StringBuilder().append("onVideoPrepared, mPlayer == null ? ");
      if (this.mPlayer != null) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      LogUtil.d(paramISuperPlayer, 2, bool);
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
    if (this.mPlayer != null) {
      this.mPlayer.pauseDownload();
    }
  }
  
  public void play()
  {
    for (;;)
    {
      try
      {
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "play");
        }
        if (!VideoPlaySDKManager.getInstance().isSDKReady())
        {
          if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "play, sdk not ready, return.");
          }
          return;
        }
        if ((this.mState.get() == 4) || (this.mState.get() == 5) || (this.mState.get() == 3))
        {
          if (LogUtil.isColorLevel()) {
            LogUtil.d(getLogTag(), 2, "play, do nothing.");
          }
          if ((this.mPlayer == null) || (!LogUtil.isColorLevel())) {
            continue;
          }
          LogUtil.d(getLogTag(), 2, "play, mPlayer.isPlaying() = " + this.mPlayer.isPlaying());
          continue;
        }
        if (this.mPlayer == null) {
          break label264;
        }
      }
      finally {}
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "play, mPlayer != null ");
      }
      if (this.mState.get() == 6)
      {
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "play, mPlayer.isPauseing() =  " + this.mPlayer.isPausing());
        }
        startPlayer();
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "play, startPlayer() ");
        }
      }
      else
      {
        openPlayer();
        continue;
        label264:
        createMediaPlayer();
        openPlayer();
      }
    }
  }
  
  public void release(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "releasePlayer");
    }
    for (;;)
    {
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
        if (this.mReporter != null)
        {
          QAReport localQAReport = this.mReporter;
          if (!paramBoolean2)
          {
            paramBoolean2 = true;
            localQAReport.doReport(paramBoolean2);
          }
        }
        else
        {
          if ((this.mVideoView != null) && ((this.mVideoView instanceof ISPlayerVideoView))) {
            ((ISPlayerVideoView)this.mVideoView).removeViewCallBack(this);
          }
          ThreadUtil.postOnSubThread(new VideoPlayerProxy.1(this, paramBoolean1));
          return;
        }
      }
      finally {}
      paramBoolean2 = false;
    }
  }
  
  public void resumeDownload()
  {
    if (this.mPlayer != null) {
      this.mPlayer.resumeDownload();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (this.mPlayer != null) {
      this.mPlayer.seekTo(paramInt);
    }
  }
  
  public void setVideoParam(VideoPlayParam paramVideoPlayParam)
  {
    this.mVideoParam = paramVideoPlayParam;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.VideoPlayerProxy
 * JD-Core Version:    0.7.0.1
 */