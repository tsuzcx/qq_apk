package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.ActCallBack;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.IImageLoader;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class MagazinePlayerView
  extends VideoPlayerView
  implements IMagazinePlayerView
{
  private String TAG = "MagazinePlayerView";
  public ActCallBack callBack;
  private long mPlayTime;
  long mProgressInterval;
  public VideoData mVideoData;
  
  public MagazinePlayerView(Context paramContext, ActCallBack paramActCallBack, QQAppInterface paramQQAppInterface)
  {
    super(paramContext, paramQQAppInterface);
    this.callBack = paramActCallBack;
  }
  
  public ActCallBack getCallBack()
  {
    return this.callBack;
  }
  
  public VideoData getVideoData()
  {
    return this.mVideoData;
  }
  
  public void pause()
  {
    if (this.mVideoData == null)
    {
      QLog.w(this.TAG, 2, "pasue mShortVideoInfo is null!!");
      return;
    }
    super.pause();
  }
  
  public void play(RelativeLayout paramRelativeLayout, VideoData paramVideoData, PlayResultListener paramPlayResultListener)
  {
    if (QLog.isColorLevel())
    {
      String str = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("play() called with: rootView = [");
      localStringBuilder.append(paramRelativeLayout);
      localStringBuilder.append("], videoData = [");
      localStringBuilder.append(paramVideoData);
      localStringBuilder.append("]");
      QLog.i(str, 2, localStringBuilder.toString());
    }
    this.mVideoData = paramVideoData;
    this.mReultListener = paramPlayResultListener;
    if (paramVideoData.b == 1)
    {
      initWidgetView(paramRelativeLayout);
      this.mPlayTime = 0L;
      this.ivCover.setVisibility(0);
      hideDownloadProgress();
      ((IImageLoader)QRoute.api(IImageLoader.class)).displayImage(this.ivCover, paramVideoData.c, new ColorDrawable(0), new ColorDrawable(0), null);
      this.mHandler.post(new MagazinePlayerView.1(this));
      return;
    }
    super.play(paramRelativeLayout, paramVideoData, paramPlayResultListener);
  }
  
  public void resume()
  {
    Object localObject = this.mVideoData;
    if (localObject == null) {
      return;
    }
    if (((VideoData)localObject).b == 1) {
      return;
    }
    localObject = this.callBack;
    if (localObject != null) {
      ((ActCallBack)localObject).a();
    }
    super.resume();
  }
  
  public void setCallBack(ActCallBack paramActCallBack)
  {
    this.callBack = paramActCallBack;
  }
  
  public void setProgressCallbackInterval(long paramLong)
  {
    if (this.mVideoData.b == 1)
    {
      this.mProgressInterval = paramLong;
      return;
    }
    super.setProgressCallbackInterval(paramLong);
  }
  
  public void setVideoData(VideoData paramVideoData)
  {
    this.mVideoData = paramVideoData;
  }
  
  public void start()
  {
    if (this.mPlayer != null) {
      this.mPlayer.b();
    }
  }
  
  public void stopPlayback(boolean paramBoolean)
  {
    super.stopPlayback(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.MagazinePlayerView
 * JD-Core Version:    0.7.0.1
 */