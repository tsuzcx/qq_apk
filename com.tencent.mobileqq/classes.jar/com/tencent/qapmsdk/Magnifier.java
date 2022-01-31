package com.tencent.qapmsdk;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qapmsdk.abfactor.AbProviderImpl;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.reporter.ReporterMachine;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.qapmmanager.QAPMLauncher;
import com.tencent.qapmsdk.qapmmanager.QAPMPluginManager;

public class Magnifier
{
  public static final String TAG = "QAPM_Magnifier";
  private static volatile boolean prepareEnvironment = false;
  
  protected static void init(int paramInt, boolean paramBoolean)
  {
    if ((BaseInfo.app != null) && (!TextUtils.isEmpty(BaseInfo.userMeta.appKey)) && (!TextUtils.isEmpty(BaseInfo.userMeta.version))) {
      try
      {
        if ((!prepareEnvironment) || (paramBoolean) || ((PluginController.startedPluginMode & paramInt) != paramInt))
        {
          if (!prepareEnvironment)
          {
            prepareEnvironment = true;
            ReporterMachine.INSTANCE.setAbManager(AbProviderImpl.getInstance());
            registerAllModule();
            QAPMLauncher.INSTANCE.preLaunch();
          }
          int i = paramInt;
          if (QAPMLauncher.isBreadCrumb) {
            i = paramInt | PluginCombination.userBreadCrumbPlugin.mode;
          }
          initMonitors(i);
        }
        return;
      }
      finally {}
    }
  }
  
  private static void initMonitors(int paramInt)
  {
    if ((BaseInfo.app == null) || (BaseInfo.userMeta.appId <= 0) || (TextUtils.isEmpty(BaseInfo.userMeta.version))) {
      return;
    }
    new Handler(ThreadManager.getMonitorThreadLooper()).post(new SdkRunnable(paramInt));
  }
  
  private static void registerAllModule()
  {
    QAPMLauncher.INSTANCE.getPluginManager().registerPlugins(QAPMPluginManager.ALL_PLUGIN);
  }
  
  public static void stop()
  {
    QAPMLauncher.INSTANCE.abolish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.Magnifier
 * JD-Core Version:    0.7.0.1
 */