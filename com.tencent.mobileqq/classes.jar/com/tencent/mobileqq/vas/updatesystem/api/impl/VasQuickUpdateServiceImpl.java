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
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.addCallBacker(paramCallBacker);
    }
  }
  
  public void addWeakCallback(CallBacker paramCallBacker)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.addWeakCallback(paramCallBacker);
    }
  }
  
  public void callBackToAll(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.callBackToAll(paramLong, paramString1, paramString2, paramString3, paramInt1, paramInt2);
    }
  }
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.cancelDwonloadItem(paramLong, paramString);
    }
  }
  
  public void cleanCache()
  {
    if (this.mVasQuickUpdateManager != null) {
      VasQuickUpdateManager.cleanCache();
    }
  }
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.downloadGatherItem(paramLong, paramString1, paramArrayOfString, paramString2);
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.downloadItem(paramLong, paramString1, paramString2);
    }
  }
  
  public BaseUpdateBusiness getBusinessCallback(long paramLong)
  {
    Object localObject = this.mVasQuickUpdateManager;
    if ((localObject != null) && (((VasQuickUpdateManager)localObject).getVasEngine() != null)) {
      try
      {
        localObject = this.mVasQuickUpdateManager.getVasEngine().getBusinessCallback(paramLong);
        return localObject;
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
    }
    return null;
  }
  
  public <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass)
  {
    if (paramClass == null) {
      return null;
    }
    Object localObject = this.mVasQuickUpdateManager;
    StringBuilder localStringBuilder;
    if ((localObject != null) && (((VasQuickUpdateManager)localObject).getVasEngine() != null)) {
      try
      {
        localObject = (BaseUpdateBusiness)this.mVasQuickUpdateManager.getVasEngine().getBusinessCallback(paramClass);
      }
      catch (NullPointerException localNullPointerException)
      {
        localNullPointerException.printStackTrace();
      }
    } else {
      localStringBuilder = null;
    }
    if (localStringBuilder == null) {
      try
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("getBusinessCallback createTempBusiness , class = ");
        localStringBuilder.append(paramClass.getName());
        QLog.e("VasQuickUpdateServiceIm", 1, localStringBuilder.toString());
        paramClass = createTempBusiness(paramClass);
        return paramClass;
      }
      catch (Exception paramClass)
      {
        paramClass.printStackTrace();
        return null;
      }
    }
    return localStringBuilder;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime != null) {
      paramAppRuntime = (VasQuickUpdateManager)paramAppRuntime.getManager(QQManagerFactory.VAS_QUICKUPDATE_MANAGER);
    } else {
      paramAppRuntime = null;
    }
    this.mVasQuickUpdateManager = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.onDestroy();
    }
  }
  
  public void onProgressToAll(long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.onProgressToAll(paramLong1, paramString1, paramString2, paramLong2, paramLong3);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong, QueryItemCallback paramQueryItemCallback)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.queryItemVersion(paramInt, paramString, paramBoolean1, paramBoolean2, paramLong, paramQueryItemCallback);
    }
  }
  
  public void removeCallBacker(CallBacker paramCallBacker)
  {
    VasQuickUpdateManager localVasQuickUpdateManager = this.mVasQuickUpdateManager;
    if (localVasQuickUpdateManager != null) {
      localVasQuickUpdateManager.removeCallBacker(paramCallBacker);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasQuickUpdateServiceImpl
 * JD-Core Version:    0.7.0.1
 */