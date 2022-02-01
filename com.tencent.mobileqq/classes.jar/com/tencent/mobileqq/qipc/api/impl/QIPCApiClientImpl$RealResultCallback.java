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
    Object localObject = this.mCallback;
    if ((localObject != null) && (((WeakReference)localObject).get() != null))
    {
      localObject = null;
      if (paramEIPCResult != null)
      {
        localObject = new QIPCApiResult();
        ((QIPCApiResult)localObject).code = paramEIPCResult.code;
        ((QIPCApiResult)localObject).data = paramEIPCResult.data;
      }
      ((QIPCApiCallback)this.mCallback.get()).onCallback((QIPCApiResult)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.impl.QIPCApiClientImpl.RealResultCallback
 * JD-Core Version:    0.7.0.1
 */