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
    }
    for (;;)
    {
      IPluginAdapterProxy.setProxy(new PluginAdapterImpl());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new SoLoadReportImpl());
      TimeFormatterUtils.a();
      BaseApplicationImpl.appnewmsgicon = 2130839553;
      BaseApplicationImpl.appnewavmsgicon = 2130840237;
      BaseApplicationImpl.qqlaunchicon = 2130839210;
      BaseApplicationImpl.qqWifiLayout = 2130970929;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131372188;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131372191;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131372192;
      BaseApplicationImpl.qqWifiSettingViewId = 2131364280;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131372193;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131372190;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131372189;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130843901;
      BaseApplicationImpl.qqWifiNoSignal = 2130843902;
      BaseApplicationImpl.qqWifiUserful = 2130843907;
      BaseApplicationImpl.qqWifiSettings = 2130843906;
      BaseApplicationImpl.qqWifiOperation = 2130843900;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130843905;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130843904;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130843903;
      BaseApplicationImpl.qqwifinotifydivide = 2131493124;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130841615;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      try
      {
        Class.forName("android.os.AsyncTask");
        if (BaseApplicationImpl.sProcessId == 1)
        {
          return true;
          if ((BaseApplicationImpl.sProcessId == 4) || (BaseApplicationImpl.sProcessId != 2)) {
            continue;
          }
          l = System.currentTimeMillis();
          BaseApplicationImpl.sLaunchTime = l;
          BaseApplicationImpl.sShowTime = l;
          BaseApplicationImpl.appStartTime = BaseApplicationImpl.sLaunchTime;
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