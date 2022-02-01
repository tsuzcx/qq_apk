package com.tencent.mobileqq.leba;

import android.content.Context;
import com.tencent.mobileqq.leba.entity.LebaPluginInfo;
import com.tencent.mobileqq.leba.entity.LebaViewItem;
import com.tencent.mobileqq.leba.observer.ResourcePluginListener;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppSetting;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(process={"all"})
public abstract interface ILebaHelperService
  extends IRuntimeService
{
  public abstract void addLebaListener(ResourcePluginListener paramResourcePluginListener);
  
  public abstract void checkModleAndRefesh();
  
  public abstract void getAllPluginList(AppRuntime paramAppRuntime);
  
  public abstract int getKidModlePluginSize(AppRuntime paramAppRuntime);
  
  public abstract List<LebaPluginInfo> getLebaConfigList();
  
  public abstract Object getLebaHelper();
  
  public abstract List<LebaViewItem> getLebaMgrList();
  
  public abstract List<LebaViewItem> getLebaShowList();
  
  public abstract LebaViewItem getLebaViewItemById(long paramLong);
  
  public abstract void goToLebaMgrActivity(Context paramContext, AppRuntime paramAppRuntime);
  
  public abstract void initLebaHelper();
  
  public abstract boolean isNeedPreloadPlugin(String paramString);
  
  public abstract boolean isPluginOpen(long paramLong);
  
  public abstract boolean isTableModel(AppRuntime paramAppRuntime);
  
  public abstract boolean needShowRedDot(AppRuntime paramAppRuntime, long paramLong, boolean paramBoolean, Map<Long, LebaPluginInfo> paramMap);
  
  public abstract void netSetPluginState(String paramString, boolean paramBoolean, long paramLong);
  
  public abstract void notifyPluginListChanged();
  
  public abstract void notifyRefreshWebProcess();
  
  public abstract void notifySetPluginState(int paramInt, boolean paramBoolean, Object paramObject);
  
  public abstract List<LebaViewItem> reloadLebaItems(AppRuntime paramAppRuntime);
  
  public abstract void removeLebaListener(ResourcePluginListener paramResourcePluginListener);
  
  public abstract void reportPluginStatus(AppRuntime paramAppRuntime);
  
  public abstract void setFlagBackFromMgr();
  
  public abstract void setFlagUpdateFromH5();
  
  public abstract void setFlagUpdateOnPause();
  
  public abstract void updateAllLebaListFlag(List<BusinessInfoCheckUpdate.AppSetting> paramList);
  
  public abstract void updateAppSetting(AppRuntime paramAppRuntime, long paramLong1, boolean paramBoolean, long paramLong2, long paramLong3);
  
  public abstract void updateBuffer();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.ILebaHelperService
 * JD-Core Version:    0.7.0.1
 */