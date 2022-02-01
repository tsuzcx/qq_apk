package com.tencent.mobileqq.kandian.glue.video;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload.CallbackListener;
import java.util.HashMap;

class VideoWebPreDownload$3$1
  implements Runnable
{
  VideoWebPreDownload$3$1(VideoWebPreDownload.3 param3, VideoUrlInfo paramVideoUrlInfo) {}
  
  public void run()
  {
    if (!VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_Int))
    {
      VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.a, this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_Int);
      return;
    }
    if (VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload) != null)
    {
      String str = (String)VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload).get(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b);
      if (!TextUtils.isEmpty(str)) {
        VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload$3.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload).a(this.jdField_a_of_type_ComTencentMobileqqKandianBaseVideoPlayerVideourlVideoUrlInfo.b, 1, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoWebPreDownload.3.1
 * JD-Core Version:    0.7.0.1
 */