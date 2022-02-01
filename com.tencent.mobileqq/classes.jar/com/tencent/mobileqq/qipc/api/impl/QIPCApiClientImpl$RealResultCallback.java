package com.tencent.mobileqq.qipc.api.impl;

import com.tencent.mobileqq.qipc.api.QIPCApiCallback;
import com.tencent.mobileqq.qipc.api.QIPCApiResult;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.util.WeakReference;

class QIPCApiClientImpl$RealResultCallback
  implements EIPCResultCallback
{
  WeakReference<QIPCApiCallback> mCallback;
  
  public QIPCApiClientImpl$RealResultCallback(QIPCApiCallback paramQIPCApiCallback)
  {
    this.mCallback = new WeakReference(paramQIPCApiCallback);
  }
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    QIPCApiResult localQIPCApiResult;
    if ((this.mCallback != null) && (this.mCallback.get() != null))
    {
      if (paramEIPCResult == null) {
        break label64;
      }
      localQIPCApiResult = new QIPCApiResult();
      localQIPCApiResult.code = paramEIPCResult.code;
      localQIPCApiResult.data = paramEIPCResult.data;
    }
    label64:
    for (paramEIPCResult = localQIPCApiResult;; paramEIPCResult = null)
    {
      ((QIPCApiCallback)this.mCallback.get()).onCallback(paramEIPCResult);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.impl.QIPCApiClientImpl.RealResultCallback
 * JD-Core Version:    0.7.0.1
 */