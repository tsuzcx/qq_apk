package com.tencent.mobileqq.leba.impl;

import android.content.Context;
import com.tencent.mobileqq.leba.ILebaHelperService;
import com.tencent.mobileqq.leba.core.CommPluginHandlerApi;
import com.tencent.mobileqq.leba.core.LebaHelper;
import com.tencent.mobileqq.leba.core.LebaSettingHandlerApi;
import com.tencent.mobileqq.leba.core.LebaShowListManager;
import com.tencent.mobileqq.leba.core.LebaUtil;
import com.tencent.mobileqq.leba.core.LebaWebPreloadHelper;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Map;
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
    localLebaHelper.d();
  }
  
  public void getAllPluginList(AppRuntime paramAppRuntime)
  {
    CommPluginHandlerApi.c(paramAppRuntime);
  }
  
  public int getKidModlePluginSize(AppRuntime paramAppRuntime)
  {
    return LebaUtil.a(paramAppRuntime);
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
    return localLebaHelper.a();
  }
  
  public Object getLebaHelper()
  {
    initLebaHelper();
    return this.mLebaHelper;
  }
  
  public List<LebaViewItem> getLebaMgrList()
  {
    return LebaShowListManager.a().a();
  }
  
  public List<LebaViewItem> getLebaShowList()
  {
    return LebaShowListManager.a().b();
  }
  
  public LebaViewItem getLebaViewItemById(long paramLong)
  {
    return LebaShowListManager.a().a(paramLong);
  }
  
  public void goToLebaMgrActivity(Context paramContext, AppRuntime paramAppRuntime)
  {
    LebaUtil.a(paramContext, paramAppRuntime);
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
    return LebaShowListManager.a().a(paramLong);
  }
  
  public boolean isTableModel(AppRuntime paramAppRuntime)
  {
    return LebaUtil.c(paramAppRuntime);
  }
  
  public boolean needShowRedDot(AppRuntime paramAppRuntime, long paramLong, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap)
  {
    return LebaUtil.a(paramAppRuntime, paramLong, paramBoolean, paramMap);
  }
  
  public void netSetPluginState(String paramString, boolean paramBoolean, long paramLong)
  {
    LebaSettingHandlerApi.a(this.mApp, paramString, paramBoolean, paramLong);
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
    localLebaHelper.i();
  }
  
  public void notifyRefreshWebProcess()
  {
    this.mLebaWebPreloadHelper.b(this.mApp);
  }
  
  public void notifySetPluginState(int paramInt, boolean paramBoolean, Object paramObject)
  {
    LebaSettingHandlerApi.a(this.mApp, paramInt, paramBoolean, paramObject);
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
      localLebaHelper.e();
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
    LebaShowListManager.a().a(paramAppRuntime);
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
  
  public void updateAllLebaListFlag(List<BusinessInfoCheckUpdate.AppSetting> paramList)
  {
    LebaShowListManager.a().a(paramList);
  }
  
  public void updateAppSetting(AppRuntime paramAppRuntime, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3)
  {
    LebaShowListManager.a().a(paramAppRuntime, paramLong1, paramBoolean, paramLong2, paramLong3);
  }
  
  public void updateBuffer()
  {
    this.mLebaWebPreloadHelper.a(this.mApp);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.impl.LebaHelperServiceImpl
 * JD-Core Version:    0.7.0.1
 */