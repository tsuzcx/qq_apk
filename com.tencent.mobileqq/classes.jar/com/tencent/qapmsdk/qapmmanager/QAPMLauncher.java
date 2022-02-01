package com.tencent.qapmsdk.qapmmanager;

import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.dbpersist.DBHandler;
import com.tencent.qapmsdk.base.dbpersist.DBHelper;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.BaseInfo.Info;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.common.activty.LifecycleCallback;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.network.NetworkWatcher;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AndroidVersion.Companion;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/qapmmanager/QAPMLauncher;", "", "()V", "TAG", "", "environmentChecker", "Lcom/tencent/qapmsdk/qapmmanager/EnvironmentChecker;", "isMonitorInitiated", "", "pluginManager", "Lcom/tencent/qapmsdk/qapmmanager/QAPMPluginManager;", "getPluginManager", "()Lcom/tencent/qapmsdk/qapmmanager/QAPMPluginManager;", "abolish", "", "afterLaunch", "launch", "userMode", "", "preLaunch", "reporterMachineInit", "qapmmanager_release"}, k=1, mv={1, 1, 15})
public final class QAPMLauncher
{
  public static final QAPMLauncher INSTANCE = new QAPMLauncher();
  private static final String TAG = "QAPM_manager_QAPMLauncher";
  private static final EnvironmentChecker environmentChecker = new EnvironmentChecker();
  private static boolean isMonitorInitiated;
  @NotNull
  private static final QAPMPluginManager pluginManager = new QAPMPluginManager();
  
  private final void reporterMachineInit()
  {
    if (!isMonitorInitiated) {
      ReporterMachine.INSTANCE.start();
    }
  }
  
  public final void abolish()
  {
    PluginController.INSTANCE.flushReportNum();
    Object localObject = BaseInfo.dbHelper;
    if (localObject != null)
    {
      localObject = ((DBHelper)localObject).getDbHandler();
      if (localObject != null) {
        ((DBHandler)localObject).close();
      }
    }
    pluginManager.stop();
    NetworkWatcher.INSTANCE.unInit();
  }
  
  public final void afterLaunch()
  {
    try
    {
      if ((pluginManager.productPlugin(PluginCombination.userBreadCrumbPlugin.pluginName) != null) && ((PluginController.startedPluginMode & PluginCombination.userBreadCrumbPlugin.mode) > 0))
      {
        Class localClass = Class.forName("com.tencent.qapmsdk.athena.BreadCrumb");
        Method localMethod = localClass.getDeclaredMethod("getInstance", new Class[0]);
        localClass.getDeclaredMethod("setFlag", new Class[] { Integer.TYPE }).invoke(localMethod.invoke(null, new Object[0]), new Object[] { Integer.valueOf(PluginController.startedPluginMode) });
      }
      return;
    }
    catch (Exception localException)
    {
      Logger.INSTANCE.w(new String[] { "QAPM_manager_QAPMLauncher", localException + ": Not found BreadCrumb Model" });
    }
  }
  
  @NotNull
  public final QAPMPluginManager getPluginManager()
  {
    return pluginManager;
  }
  
  public final void launch(int paramInt)
  {
    Object localObject = BaseInfo.app;
    if (localObject != null)
    {
      if (!SDKConfig.PURE_QAPM)
      {
        NetworkWatcher localNetworkWatcher = NetworkWatcher.INSTANCE;
        localObject = ((Application)localObject).getApplicationContext();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "it.applicationContext");
        localNetworkWatcher.init((Context)localObject);
      }
      if (((!isMonitorInitiated) && (!environmentChecker.checkSysPermission())) || ((SDKConfig.PURE_QAPM) && (!environmentChecker.checkAuthorization())))
      {
        Logger.INSTANCE.e(new String[] { "QAPM_manager_QAPMLauncher", "launch QAPM error, please check environment!" });
        return;
      }
      int i = paramInt;
      if (SDKConfig.PURE_QAPM) {
        i = environmentChecker.checkConfigs(paramInt);
      }
      if (i != 0)
      {
        INSTANCE.reporterMachineInit();
        pluginManager.start(i);
        isMonitorInitiated = true;
        return;
      }
      Logger.INSTANCE.w(new String[] { "QAPM_manager_QAPMLauncher", "no monitor turned on!" });
      return;
    }
    Logger.INSTANCE.w(new String[] { "QAPM_manager_QAPMLauncher", "app is null, so no monitor turned on!" });
  }
  
  public final void preLaunch()
  {
    if (AndroidVersion.Companion.isIceScreamSandwich())
    {
      Application localApplication = BaseInfo.app;
      if (localApplication != null) {
        localApplication.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)LifecycleCallback.INSTANCE);
      }
    }
    BaseInfo.Info.initUrl();
    BaseInfo.Info.initInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qapmsdk.qapmmanager.QAPMLauncher
 * JD-Core Version:    0.7.0.1
 */