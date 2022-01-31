package com.tencent.mobileqq.startup.step;

import akcy;
import android.os.Build.VERSION;
import android.os.SystemClock;
import bbke;
import bbkp;
import bgls;
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
      IPluginAdapterProxy.setProxy(new bgls());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new bbke());
      bbkp.a();
      BaseApplicationImpl.appnewmsgicon = 2130841013;
      BaseApplicationImpl.appnewavmsgicon = 2130841622;
      BaseApplicationImpl.qqlaunchicon = 2130840055;
      BaseApplicationImpl.qqWifiLayout = 2131561451;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131379457;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131379458;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131379449;
      BaseApplicationImpl.qqWifiSettingViewId = 2131379456;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131379459;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131379460;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131379450;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846036;
      BaseApplicationImpl.qqWifiNoSignal = 2130846037;
      BaseApplicationImpl.qqWifiUserful = 2130846042;
      BaseApplicationImpl.qqWifiSettings = 2130846041;
      BaseApplicationImpl.qqWifiOperation = 2130846035;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846040;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846039;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846038;
      BaseApplicationImpl.qqwifinotifydivide = 2131166204;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130843409;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (akcy.a()))
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