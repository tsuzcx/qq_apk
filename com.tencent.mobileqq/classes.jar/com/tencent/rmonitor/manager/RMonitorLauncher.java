package com.tencent.rmonitor.manager;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.db.DBHandler;
import com.tencent.rmonitor.base.db.DBHelper;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.BaseInfo.Info;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.base.reporter.ReporterMachine;
import com.tencent.rmonitor.common.lifecycle.LifecycleCallback;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.network.NetworkWatcher;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.AndroidVersion.Companion;
import com.tencent.rmonitor.sla.SLAHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/manager/RMonitorLauncher;", "", "()V", "TAG", "", "environmentChecker", "Lcom/tencent/rmonitor/manager/EnvironmentChecker;", "hasPreLaunched", "", "isMonitorInitiated", "pluginManager", "Lcom/tencent/rmonitor/manager/RMonitorPluginManager;", "abolish", "", "getDebugMsg", "getPluginByPluginId", "Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "pluginId", "", "getPluginByPluginMode", "pluginMode", "launch", "userMode", "preLaunch", "reporterMachineInit", "setEnvironmentChecker", "checker", "setQAPMPluginManager", "manager", "stop", "rmonitor-core_release"}, k=1, mv={1, 1, 15})
public final class RMonitorLauncher
{
  public static final RMonitorLauncher a = new RMonitorLauncher();
  private static EnvironmentChecker b = new EnvironmentChecker();
  private static RMonitorPluginManager c = new RMonitorPluginManager();
  private static boolean d;
  private static volatile boolean e;
  
  private final void c()
  {
    if (!d) {
      ReporterMachine.a.b();
    }
  }
  
  public final void a()
  {
    try
    {
      Object localObject1 = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLaunch, hasPreLaunched: ");
      localStringBuilder.append(e);
      ((Logger)localObject1).i(new String[] { "RMonitor_manager_RMonitorLauncher", localStringBuilder.toString() });
      boolean bool = e;
      if (bool) {
        return;
      }
      SLAHelper.a().c();
      e = true;
      if (AndroidVersion.a.a())
      {
        localObject1 = BaseInfo.app;
        if (localObject1 != null) {
          ((Application)localObject1).registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)LifecycleCallback.a);
        }
      }
      BaseInfo.Info.initUrl();
      BaseInfo.Info.initInfo();
      SLAHelper.a().d();
      return;
    }
    finally {}
  }
  
  public final void a(int paramInt)
  {
    Object localObject1 = Logger.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("launch, userMode: ");
    ((StringBuilder)localObject2).append(paramInt);
    ((Logger)localObject1).i(new String[] { "RMonitor_manager_RMonitorLauncher", ((StringBuilder)localObject2).toString() });
    localObject2 = BaseInfo.app;
    if (localObject2 != null)
    {
      if (paramInt == 0)
      {
        Logger.b.e(new String[] { "RMonitor_manager_RMonitorLauncher", "launch, userMode is none." });
        return;
      }
      if ((!d) && (!b.a()))
      {
        Logger.b.e(new String[] { "RMonitor_manager_RMonitorLauncher", "launch RMonitor error, please check environment!" });
        return;
      }
      localObject1 = NetworkWatcher.a;
      localObject2 = ((Application)localObject2).getApplicationContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "it.applicationContext");
      ((NetworkWatcher)localObject1).a((Context)localObject2);
      if ((ConfigProxy.INSTANCE.getConfig().b("NEED_AUTHORIZATION")) && (!b.b()))
      {
        Logger.b.e(new String[] { "RMonitor_manager_RMonitorLauncher", "launch RMonitor error, please check authorization!" });
        return;
      }
      int i = paramInt;
      if (ConfigProxy.INSTANCE.getConfig().b("NEED_AUTHORIZATION")) {
        i = b.a(paramInt);
      }
      if (i != 0)
      {
        c.a(i);
        c.c(i);
        a.c();
        d = true;
        return;
      }
      Logger.b.w(new String[] { "RMonitor_manager_RMonitorLauncher", "no monitor turned on!" });
      return;
    }
    Logger.b.w(new String[] { "RMonitor_manager_RMonitorLauncher", "launch, app is null, so no monitor turned on!" });
  }
  
  public final void b()
  {
    Logger.b.i(new String[] { "RMonitor_manager_RMonitorLauncher", "abolish" });
    PluginController.b.d();
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).a();
      if (localObject != null) {
        ((DBHandler)localObject).b();
      }
    }
    c.a();
    NetworkWatcher.a.c();
  }
  
  public final void b(int paramInt)
  {
    Logger localLogger = Logger.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop, userMode: ");
    localStringBuilder.append(paramInt);
    localLogger.i(new String[] { "RMonitor_manager_RMonitorLauncher", localStringBuilder.toString() });
    if (BaseInfo.app != null)
    {
      if (paramInt == 0)
      {
        Logger.b.e(new String[] { "RMonitor_manager_RMonitorLauncher", "stop, userMode is none." });
        return;
      }
      if (!d)
      {
        Logger.b.e(new String[] { "RMonitor_manager_RMonitorLauncher", "stop, monitor not init yet." });
        return;
      }
      c.d(paramInt);
      return;
    }
    Logger.b.w(new String[] { "RMonitor_manager_RMonitorLauncher", "stop, app is null, so no monitor turned on!" });
  }
  
  @Nullable
  public final QAPMMonitorPlugin c(int paramInt)
  {
    return c.b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.manager.RMonitorLauncher
 * JD-Core Version:    0.7.0.1
 */