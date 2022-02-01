package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import cooperation.qzone.util.JarReflectUtil;
import mqq.app.AppRuntime;

public class VasQuickUpdateServiceImpl
  implements IVasQuickUpdateService
{
  private static final String TAG = "VasQuickUpdateServiceIm";
  private VasQuickUpdateManager mVasQuickUpdateManager;
  
  private <T extends IBusinessCallback> BaseUpdateBusiness createTempBusiness(Class<T> paramClass)
  {
    return (BaseUpdateBusiness)JarReflectUtil.creatSpecifiedObject(paramClass.getName(), null, null);
  }
  
  public void addCallBacker(CallBacker paramCallBacker)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.addCallBacker(paramCallBacker);
    }
  }
  
  public void addWeakCallback(CallBacker paramCallBacker)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.addWeakCallback(paramCallBacker);
    }
  }
  
  public void callBackToAll(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.callBackToAll(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.cancelDwonloadItem(paramLong, paramString);
    }
  }
  
  public void cleanCache()
  {
    if (this.mVasQuickUpdateManager != null)
    {
      VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
      VasQuickUpdateManager.cleanCache();
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.downloadItem(paramLong, paramString1, paramString2);
    }
  }
  
  public BaseUpdateBusiness getBusinessCallback(long paramLong)
  {
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (this.mVasQuickUpdateManager != null)
    {
      localObject1 = localObject3;
      if (this.mVasQuickUpdateManager.getVasEngine() == null) {}
    }
    try
    {
      localObject1 = this.mVasQuickUpdateManager.getVasEngine().getBusinessCallback(paramLong);
      if (localObject1 == null) {}
      return localObject1;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;)
      {
        localNullPointerException.printStackTrace();
        Object localObject2 = localObject3;
      }
    }
  }
  
  public <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass)
  {
    Object localObject2;
    if (paramClass == null)
    {
      localObject2 = null;
      return localObject2;
    }
    if (this.mVasQuickUpdateManager != null) {}
    for (;;)
    {
      try
      {
        BaseUpdateBusiness localBaseUpdateBusiness = (BaseUpdateBusiness)this.mVasQuickUpdateManager.getVasEngine().getBusinessCallback(paramClass);
        localObject2 = localBaseUpdateBusiness;
        if (localBaseUpdateBusiness != null) {
          break;
        }
        Object localObject1 = null;
      }
      catch (NullPointerException localNullPointerException)
      {
        try
        {
          QLog.e("VasQuickUpdateServiceIm", 1, "getBusinessCallback createTempBusiness , class = " + paramClass.getName());
          paramClass = createTempBusiness(paramClass);
          return paramClass;
        }
        catch (Exception paramClass)
        {
          paramClass.printStackTrace();
        }
        localNullPointerException = localNullPointerException;
        localNullPointerException.printStackTrace();
      }
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {}
    for (paramAppRuntime = (VasQuickUpdateManager)paramAppRuntime.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);; paramAppRuntime = null)
    {
      this.mVasQuickUpdateManager = paramAppRuntime;
      return;
    }
  }
  
  public void onDestroy()
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.onDestroy();
    }
  }
  
  public void onProgressToAll(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.onProgressToAll(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, QueryItemCallback paramQueryItemCallback)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.queryItemVersion(paramInt, paramString, paramBoolean1, paramBoolean2, paramLong, paramQueryItemCallback);
    }
  }
  
  public void removeCallBacker(CallBacker paramCallBacker)
  {
    if (this.mVasQuickUpdateManager != null) {
      this.mVasQuickUpdateManager.removeCallBacker(paramCallBacker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasQuickUpdateServiceImpl
 * JD-Core Version:    0.7.0.1
 */