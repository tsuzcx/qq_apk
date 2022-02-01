package com.tencent.mobileqq.kandian.glue.video;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoWebPreDownload.CallbackListener;
import java.util.HashMap;

class VideoWebPreDownload$3
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoWebPreDownload$3(VideoWebPreDownload paramVideoWebPreDownload, String paramString, int paramInt, long paramLong) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if ((!TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramVideoUrlInfo.b)) && (paramVideoUrlInfo.b.equals(this.jdField_a_of_type_JavaLangString)))
    {
      ThreadManager.post(new VideoWebPreDownload.3.1(this, paramVideoUrlInfo), 5, null, true);
      return;
    }
    if ((TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) && (VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload) != null))
    {
      String str = (String)VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload).get(paramVideoUrlInfo.b);
      if (!TextUtils.isEmpty(str)) {
        VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoVideoWebPreDownload).a(paramVideoUrlInfo.b, -1, str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.VideoWebPreDownload.3
 * JD-Core Version:    0.7.0.1
 */