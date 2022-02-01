package com.tencent.mobileqq.leba.impl;

import android.util.Log;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.core.CommPluginHandlerApi;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.core.LebaWebPreloadHelper;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import mqq.app.AppRuntime;

public class LebaHelperServiceImpl
  implements ILebaHelperService
{
  public static final String TAG = "LebaHelperServiceImpl";
  private AppRuntime mApp;
  private LebaHelper mLebaHelper;
  private final LebaWebPreloadHelper mLebaWebPreloadHelper = new LebaWebPreloadHelper();
  
  public void addLebaListener(ResourcePluginListener paramResourcePluginListener)
  {
    initLebaHelper();
    LebaHelper localLebaHelper = this.mLebaHelper;
    if (localLebaHelper == null)
    {
      QLog.i("LebaHelperServiceImpl", 1, "addLebaListener mLebaHelper == null");
      return;
    }
    localLebaHelper.a(paramResourcePluginListener);
  }
  
  public void checkModleAndRefesh()
  {
    initLebaHelper();
    LebaHelper localLebaHelper = this.mLebaHelper;
    if (localLebaHelper == null)
    {
      QLog.i("LebaHelperServiceImpl", 1, "checkModleAndRefesh mLebaHelper == null");
      return;
    }
    localLebaHelper.e();
  }
  
  public void getAllPluginList(AppRuntime paramAppRuntime)
  {
    CommPluginHandlerApi.a(paramAppRuntime);
  }
  
  public List<LebaPluginInfo> getLebaConfigList()
  {
    initLebaHelper();
    LebaHelper localLebaHelper = this.mLebaHelper;
    if (localLebaHelper == null)
    {
      QLog.i("LebaHelperServiceImpl", 1, "addLebaListener mLebaHelper == null");
      return null;
    }
    return localLebaHelper.f();
  }
  
  public Object getLebaHelper()
  {
    initLebaHelper();
    return this.mLebaHelper;
  }
  
  public List<LebaViewItem> getLebaMgrList()
  {
    return LebaShowListManager.a().d();
  }
  
  public List<LebaViewItem> getLebaShowList()
  {
    return LebaShowListManager.a().e();
  }
  
  public LebaViewItem getLebaViewItemById(long paramLong)
  {
    return LebaShowListManager.a().a(paramLong);
  }
  
  public void initLebaHelper()
  {
    AppRuntime localAppRuntime = this.mApp;
    if (localAppRuntime == null)
    {
      QLog.i("LebaHelperServiceImpl", 1, "initLebaHelper mApp == null");
      return;
    }
    if (this.mLebaHelper == null)
    {
      this.mLebaHelper = new LebaHelper(localAppRuntime);
      this.mLebaHelper.b();
      this.mLebaHelper.a();
    }
  }
  
  public boolean isNeedPreloadPlugin(String paramString)
  {
    return this.mLebaWebPreloadHelper.a(this.mApp, paramString);
  }
  
  public boolean isPluginOpen(long paramLong)
  {
    return LebaShowListManager.a().b(paramLong);
  }
  
  public boolean isTableModel(AppRuntime paramAppRuntime)
  {
    return LebaUtil.f(paramAppRuntime);
  }
  
  public boolean needShowRedDot(AppRuntime paramAppRuntime, long paramLong, Set<Long> paramSet)
  {
    return LebaUtil.a(paramAppRuntime, paramLong, paramSet);
  }
  
  public void netSetPluginState(String paramString, boolean paramBoolean, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("netSetPluginState path=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(",status=");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(",time=");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(",trace=");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    QLog.i("LebaHelperServiceImpl", 1, localStringBuilder.toString());
  }
  
  public void notifyPluginListChanged()
  {
    initLebaHelper();
    LebaHelper localLebaHelper = this.mLebaHelper;
    if (localLebaHelper == null)
    {
      QLog.i("LebaHelperServiceImpl", 1, "notifyPluginListChanged mLebaHelper == null");
      return;
    }
    localLebaHelper.j();
  }
  
  public void notifyRefreshWebProcess()
  {
    this.mLebaWebPreloadHelper.b(this.mApp);
  }
  
  public void notifySetPluginState(int paramInt, boolean paramBoolean, Object paramObject)
  {
    paramObject = new StringBuilder();
    paramObject.append("notifySetPluginState type=");
    paramObject.append(paramInt);
    paramObject.append(",isSuccess=");
    paramObject.append(paramBoolean);
    paramObject.append(",trace=");
    paramObject.append(Log.getStackTraceString(new Throwable()));
    QLog.i("LebaHelperServiceImpl", 1, paramObject.toString());
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    QLog.i("LebaHelperServiceImpl", 1, "onCreate");
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy()
  {
    QLog.i("LebaHelperServiceImpl", 1, "onDestroy");
    LebaHelper localLebaHelper = this.mLebaHelper;
    if (localLebaHelper != null) {
      localLebaHelper.g();
    }
  }
  
  public List<LebaViewItem> reloadLebaItems(AppRuntime paramAppRuntime)
  {
    return LebaShowListManager.a().b(paramAppRuntime);
  }
  
  public void removeLebaListener(ResourcePluginListener paramResourcePluginListener)
  {
    initLebaHelper();
    LebaHelper localLebaHelper = this.mLebaHelper;
    if (localLebaHelper == null)
    {
      QLog.i("LebaHelperServiceImpl", 1, "addLebaListener mLebaHelper == null");
      return;
    }
    localLebaHelper.b(paramResourcePluginListener);
  }
  
  public void reportPluginStatus(AppRuntime paramAppRuntime)
  {
    LebaShowListManager.a().c(paramAppRuntime);
  }
  
  public void setFlagBackFromMgr()
  {
    LebaShowListManager.a |= 0x1;
  }
  
  public void setFlagUpdateFromH5()
  {
    LebaShowListManager.a |= 0x4;
  }
  
  public void setFlagUpdateOnPause()
  {
    LebaShowListManager.a |= 0x2;
  }
  
  public void updateAllLebaListFlag(List<BusinessInfoCheckUpdate.AppSetting> paramList) {}
  
  public void updateAppSetting(AppRuntime paramAppRuntime, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    paramAppRuntime = new StringBuilder();
    paramAppRuntime.append("updateAppSetting appId=");
    paramAppRuntime.append(paramLong1);
    paramAppRuntime.append(",status=");
    paramAppRuntime.append(paramBoolean);
    paramAppRuntime.append(",time=");
    paramAppRuntime.append(paramLong2);
    paramAppRuntime.append(",trace=");
    paramAppRuntime.append(Log.getStackTraceString(new Throwable()));
    QLog.i("LebaHelperServiceImpl", 1, paramAppRuntime.toString());
  }
  
  public void updateBuffer()
  {
    this.mLebaWebPreloadHelper.a(this.mApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.impl.LebaHelperServiceImpl
 * JD-Core Version:    0.7.0.1
 */