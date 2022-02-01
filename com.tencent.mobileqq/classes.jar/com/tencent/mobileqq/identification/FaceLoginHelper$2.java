package com.tencent.mobileqq.identification;

import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class FaceLoginHelper$2
  implements EIPCResultCallback
{
  FaceLoginHelper$2(FaceLoginHelper.IConfInterface paramIConfInterface) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    FaceLoginHelper.a(paramEIPCResult, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.identification.FaceLoginHelper.2
 * JD-Core Version:    0.7.0.1
 */