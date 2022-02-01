package com.tencent.qapmsdk;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.common.thread.ThreadManager;
import com.tencent.qapmsdk.qapmmanager.QAPMLauncher;
import com.tencent.qapmsdk.qapmmanager.QAPMPluginManager;

public class a
{
  private static volatile boolean a = false;
  
  private static void a()
  {
    QAPMLauncher.INSTANCE.getPluginManager().registerPlugins(QAPMPluginManager.ALL_PLUGIN);
  }
  
  private static void a(int paramInt)
  {
    if ((BaseInfo.app != null) && (BaseInfo.userMeta.appId > 0))
    {
      if (TextUtils.isEmpty(BaseInfo.userMeta.version)) {
        return;
      }
      new Handler(ThreadManager.getMonitorThreadLooper()).post(new b(paramInt));
    }
  }
  
  protected static void a(int paramInt, boolean paramBoolean)
  {
    if ((BaseInfo.app != null) && (!TextUtils.isEmpty(BaseInfo.userMeta.appKey)) && (!TextUtils.isEmpty(BaseInfo.userMeta.version))) {
      try
      {
        if ((!a) || (paramBoolean) || ((PluginController.startedPluginMode & paramInt) != paramInt))
        {
          if (!a)
          {
            a = true;
            a();
            QAPMLauncher.INSTANCE.preLaunch();
          }
          int i = paramInt;
          if (SDKConfig.PURE_QAPM) {
            i = paramInt | PluginCombination.userBreadCrumbPlugin.mode;
          }
          a(i);
        }
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.a
 * JD-Core Version:    0.7.0.1
 */