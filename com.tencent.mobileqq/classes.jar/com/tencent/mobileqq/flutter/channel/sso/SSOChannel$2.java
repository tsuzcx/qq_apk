package com.tencent.mobileqq.flutter.channel.sso;

import com.tencent.mobileqq.flutter.channel.model.ResponsePacket;
import com.tencent.qphone.base.util.QLog;
import io.flutter.plugin.common.MethodChannel.Result;

class SSOChannel$2
  implements Runnable
{
  SSOChannel$2(SSOChannel paramSSOChannel, ResponsePacket paramResponsePacket, String paramString, MethodChannel.Result paramResult) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a;
      boolean bool;
      if (localObject != null) {
        bool = ((ResponsePacket)localObject).isSuc.booleanValue();
      } else {
        bool = false;
      }
      QLog.d("QFlutter.SSOChannel", 2, String.format("notifyResult, cmd: %s, isSuc: %s", new Object[] { this.b, Boolean.valueOf(bool) }));
    }
    if (this.c != null)
    {
      localObject = ResponsePacket.toMap(this.a);
      this.c.success(localObject);
      return;
    }
    QLog.d("QFlutter.SSOChannel", 1, String.format("notifyResult, cmd: %s result method is null", new Object[] { this.b }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.sso.SSOChannel.2
 * JD-Core Version:    0.7.0.1
 */