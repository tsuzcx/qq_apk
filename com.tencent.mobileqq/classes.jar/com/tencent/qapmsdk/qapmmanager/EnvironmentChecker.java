package com.tencent.qapmsdk.qapmmanager;

import android.app.Application;
import android.content.Context;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.reporter.authorization.Authorization;
import com.tencent.qapmsdk.base.reporter.config.ConfigApply;
import com.tencent.qapmsdk.base.reporter.proxy.AuthorizationProxy;
import com.tencent.qapmsdk.base.reporter.proxy.ConfigProxy;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.common.util.AppInfo;
import com.tencent.qapmsdk.common.util.AppInfo.Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/qapmmanager/EnvironmentChecker;", "", "()V", "sysPermissionsNeeded", "", "", "[Ljava/lang/String;", "checkAuthorization", "", "checkConfigs", "", "userMode", "checkSysPermission", "Companion", "qapmmanager_release"}, k=1, mv={1, 1, 15})
public final class EnvironmentChecker
{
  public static final EnvironmentChecker.Companion Companion = new EnvironmentChecker.Companion(null);
  private static final String TAG = "QAPM_manager_EnvironmentChecker";
  private final String[] sysPermissionsNeeded = { "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE" };
  
  public final boolean checkAuthorization()
  {
    boolean bool1 = false;
    boolean bool2 = false;
    Object localObject = BaseInfo.app;
    if (localObject != null)
    {
      NetworkWatcher localNetworkWatcher = NetworkWatcher.INSTANCE;
      localObject = ((Application)localObject).getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "it.applicationContext");
      localNetworkWatcher.init((Context)localObject);
      if (AuthorizationProxy.INSTANCE.getAuthorization().getToken(BaseInfo.userMeta.appKey, false)) {
        break label81;
      }
      Logger.INSTANCE.i(new String[] { "QAPM_manager_EnvironmentChecker", "No available authorities." });
    }
    label81:
    for (bool1 = bool2;; bool1 = true) {
      return bool1;
    }
  }
  
  public final int checkConfigs(int paramInt)
  {
    ConfigProxy.INSTANCE.getConfig().loadConfigs(paramInt);
    return ConfigProxy.INSTANCE.getConfig().getServiceSwitch() & paramInt;
  }
  
  public final boolean checkSysPermission()
  {
    Application localApplication = BaseInfo.app;
    if (localApplication != null) {
      return AppInfo.Companion.hasPermissions((Context)localApplication, this.sysPermissionsNeeded);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.qapmmanager.EnvironmentChecker
 * JD-Core Version:    0.7.0.1
 */