package com.tencent.mobileqq.qqconnectface.impl;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.identification.IResourceObserver;
import com.tencent.mobileqq.qqconnectface.IResourceObserverApi;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import mqq.app.AppRuntime;

public class ResourceObserverApiImpl
  implements IResourceObserverApi
{
  private static final String TAG = "ResourceObserverApiImpl";
  
  private void getConfigFailed(IResourceObserver paramIResourceObserver, int paramInt)
  {
    QLog.d("ResourceObserverApiImpl", 1, "getConfigFailed");
    if (paramIResourceObserver != null) {
      paramIResourceObserver.a(paramInt);
    }
  }
  
  private void getConfigSuccess(IResourceObserver paramIResourceObserver, int paramInt)
  {
    QLog.d("ResourceObserverApiImpl", 1, "getConfigSuccess");
    if (paramIResourceObserver != null) {
      paramIResourceObserver.b(paramInt);
    }
  }
  
  private boolean isGetConfigSuccess(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      return false;
    }
    boolean bool = true;
    if (paramInt1 != 1)
    {
      if (paramInt1 == 0) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public void requestFaceManage(AppRuntime paramAppRuntime, IResourceObserver paramIResourceObserver)
  {
    if (!(paramAppRuntime instanceof QQAppInterface))
    {
      QLog.e("ResourceObserverApiImpl", 1, "requestFaceManage only run in main process");
      return;
    }
    AEOldShortVideoResManager.c((QQAppInterface)paramAppRuntime, new ResourceObserverApiImpl.1(this, paramIResourceObserver));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.impl.ResourceObserverApiImpl
 * JD-Core Version:    0.7.0.1
 */