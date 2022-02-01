package com.tencent.mobileqq.kandian.biz.gifvideo.utils;

import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyVideoStrategy$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  ReadInJoyVideoStrategy$1(ReadInJoyVideoStrategy paramReadInJoyVideoStrategy, IStrategy.URLCallback paramURLCallback) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("convertVidToUrl: ");
    ((StringBuilder)localObject).append(paramVideoUrlInfo);
    QLog.d("ReadInJoyVideoStrategy", 1, ((StringBuilder)localObject).toString());
    if (paramVideoUrlInfo != null)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqKandianBizGifvideoUtilsIStrategy$URLCallback;
      if (localObject != null)
      {
        String str1 = paramVideoUrlInfo.b;
        String str2 = paramVideoUrlInfo.a;
        ((IStrategy.URLCallback)localObject).a(new String[] { str1 }, new String[] { str2 }, paramVideoUrlInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.gifvideo.utils.ReadInJoyVideoStrategy.1
 * JD-Core Version:    0.7.0.1
 */