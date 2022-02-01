package com.tencent.mobileqq.kandian.biz.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class VideoExtractFrameManager$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoExtractFrameManager$1(VideoExtractFrameManager.VideoInfo paramVideoInfo, HashMap paramHashMap) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("换链回包 mHasDestory = ");
      ((StringBuilder)localObject).append(VideoExtractFrameManager.a().get());
      ((StringBuilder)localObject).append(", vid = ");
      ((StringBuilder)localObject).append(paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
      QLog.d("VideoExtractFrame", 2, ((StringBuilder)localObject).toString());
    }
    if (!VideoExtractFrameManager.a().get())
    {
      if (!this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameManager$VideoInfo.jdField_a_of_type_JavaLangString.equals(paramVideoUrlInfo.jdField_b_of_type_JavaLangString)) {
        return;
      }
      int j = 0;
      paramVideoUrlInfo = paramVideoUrlInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      do
      {
        i = j;
        if (!paramVideoUrlInfo.hasNext()) {
          break;
        }
        localObject = (VideoUrlInfo)paramVideoUrlInfo.next();
      } while ((!((VideoUrlInfo)localObject).jdField_a_of_type_Boolean) || (TextUtils.isEmpty(((VideoUrlInfo)localObject).c)) || (!((VideoUrlInfo)localObject).c.equals(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameManager$VideoInfo.jdField_a_of_type_Long))));
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameManager$VideoInfo.jdField_b_of_type_Int = ((VideoUrlInfo)localObject).jdField_a_of_type_Int;
      this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameManager$VideoInfo.c = ((VideoUrlInfo)localObject).jdField_b_of_type_Int;
      VideoExtractFrameManager.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameManager$VideoInfo, ((VideoUrlInfo)localObject).jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameManager$VideoInfo.jdField_b_of_type_Long);
      int i = 1;
      if ((i == 0) && (QLog.isColorLevel()))
      {
        paramVideoUrlInfo = new StringBuilder();
        paramVideoUrlInfo.append("no found videoInfo.tag = ");
        paramVideoUrlInfo.append(this.jdField_a_of_type_ComTencentMobileqqKandianBizVideoVideoExtractFrameManager$VideoInfo.jdField_b_of_type_JavaLangString);
        QLog.d("VideoExtractFrame", 2, paramVideoUrlInfo.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.VideoExtractFrameManager.1
 * JD-Core Version:    0.7.0.1
 */