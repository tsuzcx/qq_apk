package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.updatesystem.QQVasUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasApolloExtensionHandler;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.mobileqq.vas.updatesystem.impl.VasCmdManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.listener.IBusinessCallback;
import com.tencent.vas.update.callback.listener.ICmdListener;
import com.tencent.vas.update.entity.BusinessUpdateParams;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import mqq.app.AppRuntime;

public class VasEngineImpl
  implements IVasEngine
{
  private static final String TAG = "VasUpdate_VasUpdateEngineV2";
  private QQVasUpdateManager mNewEngine;
  private VasCmdManagerImpl mVasCmdManagerImpl;
  
  public void cancelDwonloadItem(long paramLong, String paramString)
  {
    QQVasUpdateManager localQQVasUpdateManager = this.mNewEngine;
    if ((localQQVasUpdateManager != null) && (localQQVasUpdateManager.getBusinessCallback(paramLong) != null)) {
      this.mNewEngine.getBusinessCallback(paramLong).cancelDownload(paramString);
    }
  }
  
  public void cancelQuery(QueryItemVersionCallback paramQueryItemVersionCallback) {}
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    paramString1 = this.mNewEngine;
    if ((paramString1 != null) && (paramString1.getBusinessCallback(paramLong) != null))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        paramString1 = new BusinessUpdateParams(paramLong, paramArrayOfString[i], paramString2);
        this.mNewEngine.getBusinessCallback(paramLong).startDownload(paramString1);
        i += 1;
      }
    }
  }
  
  public void downloadItem(long paramLong, String paramString1, String paramString2)
  {
    QQVasUpdateManager localQQVasUpdateManager = this.mNewEngine;
    if ((localQQVasUpdateManager != null) && (localQQVasUpdateManager.getBusinessCallback(paramLong) != null))
    {
      paramString1 = new BusinessUpdateParams(paramLong, paramString1, paramString2);
      this.mNewEngine.getBusinessCallback(paramLong).startDownload(paramString1);
    }
  }
  
  public BaseUpdateBusiness getBusinessCallback(long paramLong)
  {
    QQVasUpdateManager localQQVasUpdateManager = this.mNewEngine;
    if (localQQVasUpdateManager != null) {
      return localQQVasUpdateManager.getBusinessCallback(paramLong);
    }
    return null;
  }
  
  public <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass)
  {
    QQVasUpdateManager localQQVasUpdateManager = this.mNewEngine;
    if (localQQVasUpdateManager != null) {
      return localQQVasUpdateManager.getBusinessCallback(paramClass);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mNewEngine = new QQVasUpdateManager();
  }
  
  public void onDestroy()
  {
    QQVasUpdateManager localQQVasUpdateManager = this.mNewEngine;
    if (localQQVasUpdateManager != null)
    {
      localQQVasUpdateManager.onDestory();
      this.mNewEngine = null;
    }
  }
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2)
  {
    VasCmdManagerImpl localVasCmdManagerImpl = this.mVasCmdManagerImpl;
    if ((localVasCmdManagerImpl != null) && (localVasCmdManagerImpl.a() != null)) {
      this.mVasCmdManagerImpl.a().onPbResponse(paramInt, paramString1, paramString2);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    ThreadManagerV2.excute(new VasEngineImpl.1(this, paramQueryItemVersionCallback, paramInt, paramString), 32, null, true);
  }
  
  public void setRequestHandler(IVasApolloExtensionHandler paramIVasApolloExtensionHandler)
  {
    Object localObject = this.mNewEngine;
    if (localObject == null) {
      return;
    }
    if (((QQVasUpdateManager)localObject).a() == null) {
      return;
    }
    localObject = VasUpdateWrapper.getCmdManager();
    if ((localObject != null) && ((localObject instanceof VasCmdManagerImpl)))
    {
      this.mVasCmdManagerImpl = ((VasCmdManagerImpl)localObject);
      this.mVasCmdManagerImpl.a(paramIVasApolloExtensionHandler);
      return;
    }
    QLog.e("VasUpdate_VasUpdateEngineV2", 1, "setWeakHandler cmdManager == null or != VasCmdImpl");
  }
  
  public void startUpdateAllItem()
  {
    QQVasUpdateManager localQQVasUpdateManager = this.mNewEngine;
    if (localQQVasUpdateManager != null) {
      localQQVasUpdateManager.updateAllItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasEngineImpl
 * JD-Core Version:    0.7.0.1
 */