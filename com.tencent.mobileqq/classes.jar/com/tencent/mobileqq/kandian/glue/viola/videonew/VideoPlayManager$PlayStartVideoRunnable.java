package com.tencent.mobileqq.kandian.glue.viola.videonew;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.VideoPlayerWrapper;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager;
import com.tencent.mobileqq.kandian.biz.viola.video.VideoInfo;
import com.tencent.qphone.base.util.QLog;

class VideoPlayManager$PlayStartVideoRunnable
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private VideoPlayerWrapper jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper;
  private VideoPlayManager.VideoPlayParam jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam;
  
  public VideoPlayManager$PlayStartVideoRunnable(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam = paramVideoPlayParam;
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper = VideoPlayManager.VideoPlayParam.a(paramVideoPlayParam);
    this.jdField_a_of_type_Int = paramVideoPlayParam.jdField_a_of_type_Int;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Viola.VideoPlayManager", 2, "VideoFeedsPlayManager innerPlayVideo post thread");
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam != null) && (this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper != null))
    {
      if (VideoPlayManager.c(this.this$0)) {
        return;
      }
      VideoPlayManager.a(this.this$0, true);
      if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int == 0)
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString)) {
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a("", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int);
        return;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int != 1) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int != 3) && (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int != 7))
      {
        if ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int != 2) && ((this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int != 6) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString))))
        {
          if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int == 5)
          {
            if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString == null) {
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a("", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int, false);
            return;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_Int == 6)
          {
            if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString)) {
              return;
            }
            this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a("", this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_JavaLangString, 101, this.jdField_a_of_type_Int, 0L, this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_d_of_type_Int);
          }
        }
        else
        {
          if (this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString == null) {
            return;
          }
          ThirdVideoManager.a().a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, new VideoPlayManager.PlayStartVideoRunnable.1(this));
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideoPlayerWrapper.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaVideonewVideoPlayManager$VideoPlayParam.jdField_a_of_type_ComTencentMobileqqKandianBizViolaVideoVideoInfo.jdField_a_of_type_JavaLangString, 1, this.jdField_a_of_type_Int);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.videonew.VideoPlayManager.PlayStartVideoRunnable
 * JD-Core Version:    0.7.0.1
 */