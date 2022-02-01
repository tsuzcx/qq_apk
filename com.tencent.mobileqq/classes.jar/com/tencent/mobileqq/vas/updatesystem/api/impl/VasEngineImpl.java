package com.tencent.mobileqq.vas.updatesystem.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.vas.updatesystem.QQVasUpdateManager;
import com.tencent.mobileqq.vas.updatesystem.api.IVasApolloExtensionHandler;
import com.tencent.mobileqq.vas.updatesystem.api.IVasEngine;
import com.tencent.mobileqq.vas.updatesystem.callback.QueryItemVersionCallback;
import com.tencent.mobileqq.vas.updatesystem.impl.VasCmdManagerImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.business.BaseUpdateBusiness;
import com.tencent.vas.update.callback.ICmdManager;
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
    if ((this.mNewEngine != null) && (this.mNewEngine.getBusinessCallback(paramLong) != null)) {
      this.mNewEngine.getBusinessCallback(paramLong).cancelDownload(paramString);
    }
  }
  
  public void cancelQuery(QueryItemVersionCallback paramQueryItemVersionCallback) {}
  
  public void downloadGatherItem(long paramLong, String paramString1, String[] paramArrayOfString, String paramString2)
  {
    if ((this.mNewEngine != null) && (this.mNewEngine.getBusinessCallback(paramLong) != null))
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
    if ((this.mNewEngine != null) && (this.mNewEngine.getBusinessCallback(paramLong) != null))
    {
      paramString1 = new BusinessUpdateParams(paramLong, paramString1, paramString2);
      this.mNewEngine.getBusinessCallback(paramLong).startDownload(paramString1);
    }
  }
  
  public BaseUpdateBusiness getBusinessCallback(long paramLong)
  {
    if (this.mNewEngine != null) {
      return this.mNewEngine.getBusinessCallback(paramLong);
    }
    return null;
  }
  
  public <T extends IBusinessCallback> T getBusinessCallback(Class<T> paramClass)
  {
    if (this.mNewEngine != null) {
      return this.mNewEngine.getBusinessCallback(paramClass);
    }
    return null;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mNewEngine = new QQVasUpdateManager();
  }
  
  public void onDestroy()
  {
    if (this.mNewEngine != null)
    {
      this.mNewEngine.onDestory();
      this.mNewEngine = null;
    }
  }
  
  public void onPbMsgRecv(int paramInt, String paramString1, String paramString2)
  {
    if ((this.mVasCmdManagerImpl != null) && (this.mVasCmdManagerImpl.a() != null)) {
      this.mVasCmdManagerImpl.a().onPbResponse(paramInt, paramString1, paramString2);
    }
  }
  
  public void queryItemVersion(int paramInt, String paramString, boolean paramBoolean, QueryItemVersionCallback paramQueryItemVersionCallback)
  {
    ThreadManagerV2.excute(new VasEngineImpl.1(this, paramQueryItemVersionCallback, paramInt, paramString), 32, null, true);
  }
  
  public void setRequestHandler(IVasApolloExtensionHandler paramIVasApolloExtensionHandler)
  {
    if (this.mNewEngine == null) {}
    while (this.mNewEngine.a() == null) {
      return;
    }
    ICmdManager localICmdManager = VasUpdateWrapper.getCmdManager();
    if ((localICmdManager == null) || (!(localICmdManager instanceof VasCmdManagerImpl)))
    {
      QLog.e("VasUpdate_VasUpdateEngineV2", 1, "setWeakHandler cmdManager == null or != VasCmdImpl");
      return;
    }
    this.mVasCmdManagerImpl = ((VasCmdManagerImpl)localICmdManager);
    this.mVasCmdManagerImpl.a(paramIVasApolloExtensionHandler);
  }
  
  public void startUpdateAllItem()
  {
    if (this.mNewEngine != null) {
      this.mNewEngine.updateAllItem();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.impl.VasEngineImpl
 * JD-Core Version:    0.7.0.1
 */