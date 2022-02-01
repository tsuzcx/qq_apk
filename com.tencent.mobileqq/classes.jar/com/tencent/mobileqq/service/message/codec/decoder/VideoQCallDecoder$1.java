package com.tencent.mobileqq.service.message.codec.decoder;

import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.service.AVPbInfo;
import com.tencent.av.service.QavWrapper;
import com.tencent.av.service.QavWrapper.OnReadyListener;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.qphone.base.util.QLog;

class VideoQCallDecoder$1
  implements QavWrapper.OnReadyListener
{
  VideoQCallDecoder$1(VideoQCallDecoder paramVideoQCallDecoder, byte[] paramArrayOfByte, String paramString, long paramLong1, MessageHandler paramMessageHandler, long paramLong2, long paramLong3, int paramInt, boolean paramBoolean) {}
  
  public void a(QavWrapper paramQavWrapper)
  {
    AVPbInfo localAVPbInfo = paramQavWrapper.a(this.jdField_a_of_type_ArrayOfByte);
    if (localAVPbInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ret, bindId:" + localAVPbInfo.bindId + ", bindIdType:" + localAVPbInfo.bindIdType + ", phoneNum:" + localAVPbInfo.phoneNum);
      }
      if (!VcSystemInfo.isSupportSharpAudio()) {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Discard video message cause device not support");
        }
      }
    }
    for (;;)
    {
      paramQavWrapper.a();
      return;
      if (this.jdField_a_of_type_Long >= 60L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "Discard video message because of time out " + this.jdField_a_of_type_Long + " s");
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "===========handleSharpVideoMessageResp 1234========");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppMessageHandler.a(this.b, this.jdField_a_of_type_ArrayOfByte, this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ret, decode failed!");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.VideoQCallDecoder.1
 * JD-Core Version:    0.7.0.1
 */