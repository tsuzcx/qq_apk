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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mVideoInfoListener != null) {
      ((IVideoPlayerView.VideoInfoListener)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mVideoInfoListener).onStartPlaying();
    }
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mContext).isResume()))
    {
      if (QLog.isColorLevel())
      {
        paramIVideoView = new StringBuilder();
        paramIVideoView.append("player truly start! app=");
        paramIVideoView.append(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mApp);
        QLog.i("VideoPlayerView", 2, paramIVideoView.toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.nowShortVideoProtoManager.reportPlay(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mReultListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mReultListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((INearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mApp.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      Object localObject = ((INowVideoReporter)QRoute.api(INowVideoReporter.class)).opName("video_view").opType("video");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        paramIVideoView = "0";
      } else {
        paramIVideoView = "1";
      }
      paramIVideoView = ((INowVideoReporter)localObject).d4(paramIVideoView).genderInd1();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(((INowVideoReporter)QRoute.api(INowVideoReporter.class)).getRePlayCount());
      ((StringBuilder)localObject).append("");
      paramIVideoView.d2(((StringBuilder)localObject).toString()).reportByVideo(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mApp);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mPlayer.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.getFileSize();
        double d1 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.getDownloadOffset();
        double d2 = l;
        Double.isNaN(d1);
        Double.isNaN(d2);
        d1 /= d2;
        QualityReporter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d1), String.valueOf(l), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.getDownloadOffset()), String.valueOf(QualityReporter.a()), true);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mHandler.removeMessages(2025);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mHandler.sendEmptyMessageDelayed(2025, 100L);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.mHandler.sendEmptyMessageDelayed(2026, 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.7
 * JD-Core Version:    0.7.0.1
 */