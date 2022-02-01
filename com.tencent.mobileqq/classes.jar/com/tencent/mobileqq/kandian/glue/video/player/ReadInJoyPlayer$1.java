package com.tencent.mobileqq.kandian.glue.video.player;

import com.tencent.mobileqq.kandian.base.utils.ThreadUtil;
import com.tencent.mobileqq.kandian.base.video.player.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.mobileqq.kandian.base.video.player.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyPlayer$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  ReadInJoyPlayer$1(ReadInJoyPlayer paramReadInJoyPlayer, String paramString, long paramLong, int paramInt) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (paramVideoUrlInfo == null)
    {
      QLog.d(ReadInJoyPlayer.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadInJoyPlayer), 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
      return;
    }
    if (QLog.isColorLevel())
    {
      String str = ReadInJoyPlayer.a(this.jdField_a_of_type_ComTencentMobileqqKandianGlueVideoPlayerReadInJoyPlayer);
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
      localStringBuilder.append(", hwBackupUrl=");
      localStringBuilder.append(paramVideoUrlInfo.e);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    ThreadUtil.a(new ReadInJoyPlayer.1.1(this, paramVideoUrlInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.video.player.ReadInJoyPlayer.1
 * JD-Core Version:    0.7.0.1
 */