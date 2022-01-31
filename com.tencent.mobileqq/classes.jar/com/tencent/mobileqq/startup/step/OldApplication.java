package com.tencent.mobileqq.startup.step;

import alzc;
import android.os.Build.VERSION;
import android.os.SystemClock;
import bdnh;
import bdns;
import biqy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.IPluginAdapterProxy;
import com.tencent.mobileqq.statistics.UEC;
import mqq.app.Foreground;
import mqq.app.lifecycle.MobileQQActivityLifeCycle;
import mqq.os.MqqHandler;

public class OldApplication
  extends Step
{
  protected boolean doStep()
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
      IPluginAdapterProxy.setProxy(new biqy());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new bdnh());
      bdns.a();
      BaseApplicationImpl.appnewmsgicon = 2130841132;
      BaseApplicationImpl.appnewavmsgicon = 2130841786;
      BaseApplicationImpl.qqlaunchicon = 2130840158;
      BaseApplicationImpl.qqWifiLayout = 2131561659;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131380233;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131380234;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131380225;
      BaseApplicationImpl.qqWifiSettingViewId = 2131380232;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131380235;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131380236;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131380226;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846488;
      BaseApplicationImpl.qqWifiNoSignal = 2130846489;
      BaseApplicationImpl.qqWifiUserful = 2130846494;
      BaseApplicationImpl.qqWifiSettings = 2130846493;
      BaseApplicationImpl.qqWifiOperation = 2130846487;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846492;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846491;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846490;
      BaseApplicationImpl.qqwifinotifydivide = 2131166253;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130843834;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (alzc.a()))
      {
        MobileQQActivityLifeCycle localMobileQQActivityLifeCycle = new MobileQQActivityLifeCycle(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
        UEC.a().a(localMobileQQActivityLifeCycle);
      }
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