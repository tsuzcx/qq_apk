package com.tencent.mobileqq.qipc.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qipc.api.IQIPCApiClient;
import com.tencent.mobileqq.qipc.api.QIPCApiCallback;
import com.tencent.mobileqq.qipc.api.QIPCApiModule;
import com.tencent.mobileqq.qipc.api.QIPCApiResult;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.concurrent.ConcurrentHashMap;

public class QIPCApiClientImpl
  implements IQIPCApiClient
{
  private ConcurrentHashMap<QIPCApiModule, QIPCApiClientImpl.RealQIPCModule> mModuleMaps = new ConcurrentHashMap();
  
  public QIPCApiResult callServer(String paramString1, String paramString2, Bundle paramBundle)
  {
    QIPCApiResult localQIPCApiResult = new QIPCApiResult();
    paramString1 = QIPCClientHelper.getInstance().callServer(paramString1, paramString2, paramBundle);
    if (paramString1 != null)
    {
      localQIPCApiResult.data = paramString1.data;
      localQIPCApiResult.code = paramString1.code;
    }
    return localQIPCApiResult;
  }
  
  public void callServer(String paramString1, String paramString2, Bundle paramBundle, QIPCApiCallback paramQIPCApiCallback)
  {
    QIPCClientHelper.getInstance().callServer(paramString1, paramString2, paramBundle, new QIPCApiClientImpl.RealResultCallback(paramQIPCApiCallback));
  }
  
  public void register(QIPCApiModule paramQIPCApiModule)
  {
    QIPCApiClientImpl.RealQIPCModule localRealQIPCModule = new QIPCApiClientImpl.RealQIPCModule(paramQIPCApiModule);
    QIPCClientHelper.getInstance().register(localRealQIPCModule);
    this.mModuleMaps.put(paramQIPCApiModule, localRealQIPCModule);
  }
  
  public void unRegisterModule(QIPCApiModule paramQIPCApiModule)
  {
    QIPCApiClientImpl.RealQIPCModule localRealQIPCModule = (QIPCApiClientImpl.RealQIPCModule)this.mModuleMaps.get(paramQIPCApiModule);
    if (localRealQIPCModule != null)
    {
      QIPCClientHelper.getInstance().getClient().unRegisterModule(localRealQIPCModule);
      this.mModuleMaps.remove(paramQIPCApiModule);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.api.impl.QIPCApiClientImpl
 * JD-Core Version:    0.7.0.1
 */