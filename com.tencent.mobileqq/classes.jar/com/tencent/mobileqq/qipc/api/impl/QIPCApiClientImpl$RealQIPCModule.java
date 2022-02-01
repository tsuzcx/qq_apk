package com.tencent.mobileqq.qipc.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.api.QIPCApiModule;
import com.tencent.mobileqq.qipc.api.QIPCApiResult;
import eipc.EIPCResult;
import mqq.util.WeakReference;

class QIPCApiClientImpl$RealQIPCModule
  extends QIPCModule
{
  WeakReference<QIPCApiModule> mSource;
  
  public QIPCApiClientImpl$RealQIPCModule(QIPCApiModule paramQIPCApiModule)
  {
    super(paramQIPCApiModule.name);
    this.mSource = new WeakReference(paramQIPCApiModule);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    WeakReference localWeakReference = this.mSource;
    if ((localWeakReference != null) && (localWeakReference.get() != null))
    {
      paramString = ((QIPCApiModule)this.mSource.get()).onCall(paramString, paramBundle, paramInt);
      if (paramString != null)
      {
        paramBundle = new EIPCResult();
        paramBundle.code = paramString.code;
        paramBundle.data = paramString.data;
        return paramBundle;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.impl.QIPCApiClientImpl.RealQIPCModule
 * JD-Core Version:    0.7.0.1
 */