package com.tencent.mobileqq.nearby.business;

import com.tencent.mobileqq.nearby.now.protocol.CsTask.OnCsError;
import com.tencent.qphone.base.util.QLog;

class NearbyCardHandler$3
  implements CsTask.OnCsError
{
  NearbyCardHandler$3(NearbyCardHandler paramNearbyCardHandler) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte)
  {
    QLog.e("NearbyCardHandler", 1, "sendPoBingMsg. errorCode=" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.business.NearbyCardHandler.3
 * JD-Core Version:    0.7.0.1
 */