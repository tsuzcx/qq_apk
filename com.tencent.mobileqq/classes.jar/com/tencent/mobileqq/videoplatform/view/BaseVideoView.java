package com.tencent.mobileqq.videoplatform.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.videoplatform.VideoPlayerInnerCallback;
import com.tencent.mobileqq.videoplatform.VideoPlayerProxy;
import com.tencent.mobileqq.videoplatform.api.IBaseVideoView;
import com.tencent.mobileqq.videoplatform.api.PlayerState;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;
import com.tencent.mobileqq.videoplatform.util.UIUtil;

public class BaseVideoView
  extends FrameLayout
  implements VideoPlayerInnerCallback, IBaseVideoView
{
  private static final boolean DEBUG = false;
  Context mContext;
  private Drawable mCoverDrawable;
  private ImageView mCoverImage;
  private TextView mDebugTextView;
  private long mID;
  public boolean mIsPlayVideo;
  private VideoPlayParam mParams;
  boolean mScaleFullScreen;
  VideoPlayerProxy mVPProxy;
  
  public BaseVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView, VideoPlayerInnerCallback paramVideoPlayerInnerCallback)
  {
    this(paramContext, paramLong, paramVideoPlayParam, paramImageView, paramVideoPlayerInnerCallback, false);
  }
  
  public BaseVideoView(Context paramContext, long paramLong, VideoPlayParam paramVideoPlayParam, ImageView paramImageView, VideoPlayerInnerCallback paramVideoPlayerInnerCallback, boolean paramBoolean)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.mID = paramLong;
    this.mScaleFullScreen = paramBoolean;
    this.mParams = paramVideoPlayParam;
    this.mCoverImage = paramImageView;
    init(paramVideoPlayerInnerCallback);
  }
  
  public BaseVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    init(null);
  }
  
  private void addCoverImageView()
  {
    try
    {
      if (this.mCoverImage == null) {
        this.mCoverImage = new ImageView(this.mContext);
      }
      if (this.mCoverDrawable != null) {
        this.mCoverImage.setImageDrawable(this.mCoverDrawable);
      }
      if (this.mScaleFullScreen) {
        this.mCoverImage.setScaleType(ImageView.ScaleType.CENTER_CROP);
      } else {
        this.mCoverImage.setScaleType(ImageView.ScaleType.FIT_CENTER);
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.mCoverImage.setLayoutParams(localLayoutParams);
      this.mCoverImage.setVisibility(0);
      addView(this.mCoverImage, 1);
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(getLogTag(), 1, "addCoverImageView error。", localThrowable);
    }
  }
  
  private void addDebugView()
  {
    try
    {
      if (findViewById(2131449780) != null)
      {
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "addDebugView, debugTextView is exist");
        }
        removeView(findViewById(2131449780));
      }
      this.mDebugTextView = new TextView(this.mContext);
      this.mDebugTextView.setId(2131449780);
      this.mDebugTextView.setText(String.valueOf(this.mID));
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -1);
      localLayoutParams.leftMargin = UIUtil.dp2px(6.0F, this.mContext.getResources());
      localLayoutParams.rightMargin = UIUtil.dp2px(6.0F, this.mContext.getResources());
      this.mDebugTextView.setGravity(17);
      this.mDebugTextView.setShadowLayer(3.0F, 1.0F, 1.0F, -16777216);
      this.mDebugTextView.setLayoutParams(localLayoutParams);
      updateDebugView();
      addView(this.mDebugTextView, 2);
      return;
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(getLogTag(), 1, "addDebugView error。", localThrowable);
    }
  }
  
  private void addVideoView()
  {
    try
    {
      if (findViewById(2131449781) != null)
      {
        if (LogUtil.isColorLevel()) {
          LogUtil.d(getLogTag(), 2, "addVideoView, videoView is exist");
        }
        removeView(findViewById(2131449781));
      }
      View localView = this.mVPProxy.getVideoView();
      if (localView == null)
      {
        LogUtil.e(getLogTag(), 1, "addVideoView, videoView == null");
        return;
      }
      localView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      localView.setId(2131449781);
      addView(localView, 0);
      if (LogUtil.isColorLevel())
      {
        LogUtil.d(getLogTag(), 2, "addVideoView. ");
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      LogUtil.e(getLogTag(), 1, "addVideoView error。", localThrowable);
    }
  }
  
  private String getLogTag()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[VideoPlatForm]BaseVideoView[");
    localStringBuilder.append(getLogId());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  private void updateDebugView() {}
  
  public void captureCurFrame(long paramLong, int paramInt1, int paramInt2)
  {
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      localVideoPlayerProxy.captureCurFrame(paramLong, paramInt1, paramInt2);
    }
  }
  
  public Drawable getCoverDrawable()
  {
    return this.mCoverDrawable;
  }
  
  public ImageView getCoverImage()
  {
    return this.mCoverImage;
  }
  
  public long getCurPlayingPos()
  {
    long l;
    try
    {
      l = this.mVPProxy.getCurPostionMs();
    }
    catch (Throwable localThrowable)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.e(getLogTag(), 2, "getCurPlayingPos() error ", localThrowable);
      }
      l = -1L;
    }
    if (LogUtil.isColorLevel())
    {
      String str = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getCurPlayingPos() curPosi = ");
      localStringBuilder.append(l);
      LogUtil.d(str, 2, localStringBuilder.toString());
    }
    return l;
  }
  
  protected long getLogId()
  {
    return this.mID;
  }
  
  public long getVideoDurationMs()
  {
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      return localVideoPlayerProxy.getVideoDurationMs();
    }
    return 0L;
  }
  
  public void init(VideoPlayerInnerCallback paramVideoPlayerInnerCallback)
  {
    if (paramVideoPlayerInnerCallback == null) {
      this.mVPProxy = new VideoPlayerProxy(this.mContext, this.mID, this.mParams, this, this.mScaleFullScreen);
    } else {
      this.mVPProxy = new VideoPlayerProxy(this.mContext, this.mID, this.mParams, paramVideoPlayerInnerCallback, this.mScaleFullScreen);
    }
    addVideoView();
    addCoverImageView();
  }
  
  public boolean isLocalPlay()
  {
    if (this.mVPProxy.getVideoParam() != null) {
      return this.mVPProxy.getVideoParam().mIsLocal;
    }
    return true;
  }
  
  public boolean isMute()
  {
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      return localVideoPlayerProxy.isMute();
    }
    return false;
  }
  
  public boolean isPlaying()
  {
    return this.mVPProxy.isPlaying();
  }
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    VideoPlayParam localVideoPlayParam = this.mParams;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.mCallback != null)) {
      this.mParams.mCallback.onCapFrame(paramLong, paramBoolean, paramInt1, paramInt2, paramBitmap);
    }
  }
  
  public void onDownloadComplete(long paramLong)
  {
    VideoPlayParam localVideoPlayParam = this.mParams;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.mCallback != null)) {
      this.mParams.mCallback.onDownloadComplete(paramLong);
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2)
  {
    VideoPlayParam localVideoPlayParam = this.mParams;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.mCallback != null)) {
      this.mParams.mCallback.onDownloadProgress(paramLong1, paramLong2);
    }
  }
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (LogUtil.isColorLevel())
    {
      localObject = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFirstFrameRendered , id = ");
      localStringBuilder.append(paramLong);
      LogUtil.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.mParams;
    if ((localObject != null) && (((VideoPlayParam)localObject).mCallback != null)) {
      this.mParams.mCallback.onFirstFrameRendered(paramLong);
    }
    ThreadUtil.postOnUIThread(new BaseVideoView.1(this));
  }
  
  public void onLoopBack(long paramLong1, long paramLong2)
  {
    VideoPlayParam localVideoPlayParam = this.mParams;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.mCallback != null)) {
      this.mParams.mCallback.onLoopBack(paramLong1, paramLong2);
    }
  }
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    VideoPlayParam localVideoPlayParam = this.mParams;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.mCallback != null)) {
      this.mParams.mCallback.onPlayError(paramLong, paramInt1, paramInt2, paramInt3, paramString);
    }
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    VideoPlayParam localVideoPlayParam = this.mParams;
    if ((localVideoPlayParam != null) && (localVideoPlayParam.mCallback != null)) {
      this.mParams.mCallback.onPlayProgress(paramLong1, paramLong2);
    }
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (LogUtil.isColorLevel())
    {
      localObject = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStateChange , state = ");
      localStringBuilder.append(PlayerState.getStateStr(paramInt));
      LogUtil.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.mParams;
    if ((localObject != null) && (((VideoPlayParam)localObject).mCallback != null)) {
      this.mParams.mCallback.onStateChange(paramLong, paramInt);
    }
    if (paramInt != 1) {
      if (paramInt != 2)
      {
        if (paramInt == 3) {}
      }
      else
      {
        if (!this.mIsPlayVideo) {
          return;
        }
        play();
        return;
      }
    }
    setCoverVisible();
  }
  
  public void onSurfaceDestroy(long paramLong)
  {
    if (LogUtil.isColorLevel())
    {
      String str = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSurfaceDestroy , id = ");
      localStringBuilder.append(paramLong);
      LogUtil.d(str, 2, localStringBuilder.toString());
    }
    ThreadUtil.postOnUIThread(new BaseVideoView.2(this));
  }
  
  public void pause()
  {
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      localVideoPlayerProxy.pause();
    }
  }
  
  public void pauseDownload()
  {
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      localVideoPlayerProxy.pauseDownload();
    }
  }
  
  public void play()
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "play");
    }
    this.mIsPlayVideo = true;
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      localVideoPlayerProxy.play();
    }
  }
  
  public void releasePlayer(boolean paramBoolean)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.e(getLogTag(), 2, "releasePlayer, print stack : （ not a crash !!! ）", new RuntimeException());
    }
    this.mIsPlayVideo = false;
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      localVideoPlayerProxy.release(paramBoolean, false);
    }
  }
  
  public void resume()
  {
    if (!this.mIsPlayVideo)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "resume , mIsPlayVideo is false , do nothing.");
      }
      return;
    }
    play();
  }
  
  public void resumeDownload()
  {
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      localVideoPlayerProxy.resumeDownload();
    }
  }
  
  public void seekTo(int paramInt)
  {
    if (LogUtil.isColorLevel())
    {
      localObject = getLogTag();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("seekTo, positionMs = ");
      localStringBuilder.append(paramInt);
      LogUtil.d((String)localObject, 2, localStringBuilder.toString());
    }
    Object localObject = this.mVPProxy;
    if (localObject != null) {
      ((VideoPlayerProxy)localObject).seekTo(paramInt);
    }
  }
  
  public void setCoverDrawable(Drawable paramDrawable)
  {
    this.mCoverDrawable = paramDrawable;
    ImageView localImageView = this.mCoverImage;
    if (localImageView != null) {
      localImageView.setImageDrawable(paramDrawable);
    }
  }
  
  public void setCoverInVisible()
  {
    if (this.mCoverImage != null)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "setCoverInVisible");
      }
      this.mCoverImage.setVisibility(4);
    }
  }
  
  public void setCoverVisible()
  {
    if (this.mCoverImage != null)
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "setCoverVisible");
      }
      this.mCoverImage.setVisibility(0);
    }
  }
  
  public void setID(long paramLong)
  {
    this.mID = paramLong;
    this.mVPProxy.setID(this.mID);
    updateDebugView();
  }
  
  public void setMute(boolean paramBoolean)
  {
    VideoPlayerProxy localVideoPlayerProxy = this.mVPProxy;
    if (localVideoPlayerProxy != null) {
      localVideoPlayerProxy.setMute(paramBoolean);
    }
  }
  
  public void setVideoParam(VideoPlayParam paramVideoPlayParam)
  {
    this.mParams = paramVideoPlayParam;
    VideoPlayParam localVideoPlayParam = this.mVPProxy.getVideoParam();
    if (localVideoPlayParam == null)
    {
      this.mVPProxy.setVideoParam(paramVideoPlayParam);
      return;
    }
    if (paramVideoPlayParam.isSameVideo(localVideoPlayParam))
    {
      if (LogUtil.isColorLevel()) {
        LogUtil.d(getLogTag(), 2, "setVideoParam, same video, do noting.");
      }
      paramVideoPlayParam.mLastPlayPosMs = localVideoPlayParam.mLastPlayPosMs;
      return;
    }
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "setVideoParam, different video, addVideoView.");
    }
    this.mVPProxy.release(false, false);
    this.mVPProxy = new VideoPlayerProxy(this.mContext, this.mID, paramVideoPlayParam, this, this.mScaleFullScreen);
    addVideoView();
  }
  
  public void showCover(Drawable paramDrawable)
  {
    if (LogUtil.isColorLevel()) {
      LogUtil.d(getLogTag(), 2, "showCover");
    }
    this.mIsPlayVideo = false;
    this.mCoverDrawable = paramDrawable;
    ImageView localImageView = this.mCoverImage;
    if (localImageView != null)
    {
      localImageView.setImageDrawable(paramDrawable);
      this.mCoverImage.setVisibility(0);
    }
    releasePlayer(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.videoplatform.view.BaseVideoView
 * JD-Core Version:    0.7.0.1
 */