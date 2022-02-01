package com.tencent.mobileqq.nearby.now.view;

import android.os.Handler;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.protocol.NowShortVideoProtoManager;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.QualityReporter;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView;
import com.tencent.mobileqq.nearby.now.view.player.IVideoView.OnPreparedListener;
import com.tencent.mobileqq.nearby.profilecard.moment.NearbyMomentManager;
import com.tencent.qphone.base.util.QLog;

class VideoPlayerView$7
  implements IVideoView.OnPreparedListener
{
  VideoPlayerView$7(VideoPlayerView paramVideoPlayerView, VideoData paramVideoData, boolean paramBoolean) {}
  
  public void a(IVideoView paramIVideoView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView$VideoInfoListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView$VideoInfoListener.c();
    }
    NowVideoReporter localNowVideoReporter;
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)) && (((BaseActivity)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_AndroidContentContext).isResume()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "player truly start! app=" + this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqNearbyNowProtocolNowShortVideoProtoManager.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, null);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayResultListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayResultListener.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 100, 0, "");
      }
      ((NearbyMomentManager)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_MOMENT_MANAGER)).f(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString);
      localNowVideoReporter = new NowVideoReporter().i("video_view").h("video");
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Boolean) {
        break label367;
      }
    }
    label367:
    for (paramIVideoView = "0";; paramIVideoView = "1")
    {
      localNowVideoReporter.g(paramIVideoView).b().f(NowVideoReporter.a + "").a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPlayerIVideoView.b();
      if (!this.jdField_a_of_type_Boolean)
      {
        long l = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.b();
        double d = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.c() / l;
        QualityReporter.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_JavaLangString, 1, String.valueOf(d), String.valueOf(l), String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.c()), String.valueOf(QualityReporter.a()), true);
      }
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_AndroidOsHandler.removeMessages(2025);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2025, 100L);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerView.jdField_a_of_type_AndroidOsHandler.sendEmptyMessageDelayed(2026, 300L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.VideoPlayerView.7
 * JD-Core Version:    0.7.0.1
 */