package com.tencent.rmonitor.manager;

import android.app.Application;
import android.content.Context;
import com.tencent.rmonitor.base.authorization.Authorization;
import com.tencent.rmonitor.base.authorization.AuthorizationProxy;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AppInfo;
import com.tencent.rmonitor.common.util.AppInfo.Companion;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/manager/EnvironmentChecker;", "", "()V", "sysPermissionsNeeded", "", "", "[Ljava/lang/String;", "checkAuthorization", "", "checkConfigs", "", "userMode", "checkSysPermission", "Companion", "rmonitor-core_release"}, k=1, mv={1, 1, 15})
public class EnvironmentChecker
{
  public static final EnvironmentChecker.Companion a = new EnvironmentChecker.Companion(null);
  private final String[] b = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" };
  
  public int a(int paramInt)
  {
    return ConfigProxy.INSTANCE.getConfig().a(paramInt);
  }
  
  public boolean a()
  {
    Application localApplication = BaseInfo.app;
    if (localApplication != null) {
      return AppInfo.a.a((Context)localApplication, this.b);
    }
    return false;
  }
  
  public boolean b()
  {
    Application localApplication = BaseInfo.app;
    boolean bool = false;
    if (localApplication != null)
    {
      if (!AuthorizationProxy.a.a().a(BaseInfo.userMeta.appKey, false))
      {
        Logger.b.i(new String[] { "RMonitor_manager_EnvironmentChecker", "No available authorities." });
        return false;
      }
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.manager.EnvironmentChecker
 * JD-Core Version:    0.7.0.1
 */