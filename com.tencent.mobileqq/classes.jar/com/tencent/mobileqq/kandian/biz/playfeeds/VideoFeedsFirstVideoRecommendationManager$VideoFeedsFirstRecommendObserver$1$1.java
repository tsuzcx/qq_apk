package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.video.VideoPreDownloadMgr;
import com.tencent.qphone.base.util.QLog;

class VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1$1(VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1 param1, VideoPreDownloadMgr paramVideoPreDownloadMgr) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (QLog.isColorLevel())
    {
      String str = VideoFeedsFirstVideoRecommendationManager.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UUIDToUrlCallback Callback vid=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
      localStringBuilder.append(", url=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", isH265=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_a_of_type_Boolean);
      localStringBuilder.append(", isHWCodec=");
      localStringBuilder.append(paramVideoUrlInfo.jdField_b_of_type_Boolean);
      localStringBuilder.append(", fileBitRate=");
      localStringBuilder.append(paramVideoUrlInfo.c);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if ((!TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(paramVideoUrlInfo.jdField_a_of_type_JavaLangString, paramVideoUrlInfo.jdField_b_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoPreDownloadMgr.a(paramVideoUrlInfo.jdField_a_of_type_JavaLangString, paramVideoUrlInfo.jdField_b_of_type_JavaLangString, 0, this.jdField_a_of_type_ComTencentMobileqqKandianBizPlayfeedsVideoFeedsFirstVideoRecommendationManager$VideoFeedsFirstRecommendObserver$1.a.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsFirstVideoRecommendationManager.VideoFeedsFirstRecommendObserver.1.1
 * JD-Core Version:    0.7.0.1
 */