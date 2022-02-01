package com.tencent.mobileqq.qwallet.preload.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class PreloadServiceProxyImpl$2
  implements EIPCResultCallback
{
  PreloadServiceProxyImpl$2(PreloadServiceProxyImpl paramPreloadServiceProxyImpl, ResultReceiver paramResultReceiver) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()))
    {
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, paramEIPCResult.data);
      return;
    }
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */