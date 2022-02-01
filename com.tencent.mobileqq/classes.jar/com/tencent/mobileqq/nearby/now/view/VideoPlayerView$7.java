package com.tencent.mobileqq.nearby.now.view;

import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.INowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.utils.INowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnPreparedListener;
import com.tencent.mobileqq.nearby.profilecard.INearbyMomentManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class VideoPlayerView$7
  implements IVideoView.OnPreparedListener
{
  VideoPlayerView$7(VideoPlayerView paramVideoPlayerView, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (this.c.mVideoInfoListener != null) {
      ((IVideoPlayerView.VideoInfoListener)this.c.mVideoInfoListener).onStartPlaying();
    }
    if (((this.c.mContext instanceof BaseActivity)) && (((BaseActivity)this.c.mContext).isResume()))
    {
      if (QLog.isColorLevel())
      {
        paramIVideoView = new StringBuilder();
        paramIVideoView.append("player truly start! app=");
        paramIVideoView.append(this.c.mApp);
        QLog.i("VideoPlayerView", 2, paramIVideoView.toString());
      }
      this.c.nowShortVideoProtoManager.reportPlay(this.a.c, null);
      if (this.c.mReultListener != null) {
        this.c.mReultListener.a(this.a.c, 100, 0, "");
      }
      ((INearbyMomentManager)this.c.mApp.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(this.a.c);
      Object localObject = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opName("video_view").opType("video");
      if (this.a.n) {
        paramIVideoView = "0";
      } else {
        paramIVideoView = "1";
      }
      paramIVideoView = ((INowVideoReporter)localObject).d4(paramIVideoView).genderInd1();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getRePlayCount());
      ((StringBuilder)localObject).append("");
      paramIVideoView.d2(((StringBuilder)localObject).toString()).reportByVideo(this.c.mApp);
      this.c.mPlayer.c();
      if (!this.b)
      {
        long l = this.c.getFileSize();
        double d1 = this.c.getDownloadOffset();
        double d2 = l;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        QualityReporter.a(this.a.c, 1, String.valueOf(d1), String.valueOf(l), String.valueOf(this.c.getDownloadOffset()), String.valueOf(QualityReporter.g()), true);
      }
    }
    this.c.mHandler.removeMessages(2025);
    this.c.mHandler.sendEmptyMessageDelayed(2025, 100L);
    this.c.mHandler.sendEmptyMessageDelayed(2026, 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.7
 * JD-Core Version:    0.7.0.1
 */