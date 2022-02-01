package com.tencent.mobileqq.util;

import com.tencent.mobileqq.tinyid.impl.TinyIDHandler;
import com.tencent.mobileqq.tinyid.impl.TinyIDHandler.Listener;
import com.tencent.qphone.base.util.QLog;

class TuringSdkManager$1
  implements TinyIDHandler.Listener
{
  TuringSdkManager$1(TuringSdkManager paramTuringSdkManager, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceive], TinyIDHandler req callback,request seq:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append("get TinyID: ");
    localStringBuilder.append(paramString2.substring(0, 3));
    localStringBuilder.append("****");
    QLog.d("TuringSdkInitHelper", 1, localStringBuilder.toString());
    TuringSdkManager.a(this.c, paramString2);
    TuringSdkManager.a(this.c).a(paramString1, this);
    paramString1 = this.c;
    if (!paramString1.b(TuringSdkManager.b(paramString1)))
    {
      QLog.d("TuringSdkInitHelper", 1, "[initTuringSDKAndRiskDetect], tinyID from oidb is invalid");
      return;
    }
    paramString1 = this.c;
    paramString1.a(TuringSdkManager.b(paramString1));
    this.c.b(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.TuringSdkManager.1
 * JD-Core Version:    0.7.0.1
 */