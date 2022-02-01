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
    Object localObject1 = paramQavWrapper.c(this.a);
    if (localObject1 != null)
    {
      Object localObject2;
      if (QLog.isColorLevel())
      {
        localObject2 = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ret, bindId:");
        localStringBuilder.append(((AVPbInfo)localObject1).bindId);
        localStringBuilder.append(", bindIdType:");
        localStringBuilder.append(((AVPbInfo)localObject1).bindIdType);
        localStringBuilder.append(", phoneNum:");
        localStringBuilder.append(((AVPbInfo)localObject1).phoneNum);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if (!VcSystemInfo.isSupportSharpAudio())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "Discard video message cause device not support");
        }
      }
      else if (this.c >= 60L)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = this.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Discard video message because of time out ");
          ((StringBuilder)localObject2).append(this.c);
          ((StringBuilder)localObject2).append(" s");
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.b, 2, "===========handleSharpVideoMessageResp 1234========");
        }
        this.d.a(this.e, this.a, this.f, this.g, this.h);
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d(this.b, 2, "ret, decode failed!");
    }
    paramQavWrapper.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.codec.decoder.VideoQCallDecoder.1
 * JD-Core Version:    0.7.0.1
 */