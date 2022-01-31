package com.tencent.mobileqq.startup.step;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.utils.SoLoadReportImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import cooperation.plugin.PluginAdapterImpl;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

public class OldApplication
  extends Step
{
  protected boolean a()
  {
    mqq.app.MainService.isDebugVersion = false;
    mqq.app.MainService.isGrayVersion = false;
    long l;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      l = SystemClock.uptimeMillis();
      BaseApplicationImpl.sLaunchTime = l;
      BaseApplicationImpl.sShowTime = l;
      BaseApplicationImpl.appStartTime = BaseApplicationImpl.sLaunchTime;
      BaseApplicationImpl.sUiHandler = new MqqHandler();
      IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
    }
    for (;;)
    {
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new SoLoadReportImpl());
      TimeFormatterUtils.a();
      BaseApplicationImpl.appnewmsgicon = 2130839533;
      BaseApplicationImpl.appnewavmsgicon = 2130840216;
      BaseApplicationImpl.qqlaunchicon = 2130839189;
      BaseApplicationImpl.qqWifiLayout = 2130970863;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131372005;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131372008;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131372009;
      BaseApplicationImpl.qqWifiSettingViewId = 2131364231;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131372010;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131372007;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131372006;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130843711;
      BaseApplicationImpl.qqWifiNoSignal = 2130843712;
      BaseApplicationImpl.qqWifiUserful = 2130843717;
      BaseApplicationImpl.qqWifiSettings = 2130843716;
      BaseApplicationImpl.qqWifiOperation = 2130843710;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130843715;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130843714;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130843713;
      BaseApplicationImpl.qqwifinotifydivide = 2131493123;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130841551;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      try
      {
        Class.forName("android.os.AsyncTask");
        if (BaseApplicationImpl.sProcessId == 1)
        {
          return true;
          if (BaseApplicationImpl.sProcessId == 4) {
            continue;
          }
          if (BaseApplicationImpl.sProcessId == 2)
          {
            l = System.currentTimeMillis();
            BaseApplicationImpl.sLaunchTime = l;
            BaseApplicationImpl.sShowTime = l;
            BaseApplicationImpl.appStartTime = BaseApplicationImpl.sLaunchTime;
          }
          IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          localClassNotFoundException.printStackTrace();
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */