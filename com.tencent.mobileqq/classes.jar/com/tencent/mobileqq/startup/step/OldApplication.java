package com.tencent.mobileqq.startup.step;

import akcz;
import android.os.Build.VERSION;
import android.os.SystemClock;
import bbjq;
import bbkb;
import bglb;
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
      IPluginAdapterProxy.setProxy(new bglb());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new bbjq());
      bbkb.a();
      BaseApplicationImpl.appnewmsgicon = 2130841016;
      BaseApplicationImpl.appnewavmsgicon = 2130841622;
      BaseApplicationImpl.qqlaunchicon = 2130840058;
      BaseApplicationImpl.qqWifiLayout = 2131561452;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131379452;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131379453;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131379444;
      BaseApplicationImpl.qqWifiSettingViewId = 2131379451;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131379454;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131379455;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131379445;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846030;
      BaseApplicationImpl.qqWifiNoSignal = 2130846031;
      BaseApplicationImpl.qqWifiUserful = 2130846036;
      BaseApplicationImpl.qqWifiSettings = 2130846035;
      BaseApplicationImpl.qqWifiOperation = 2130846029;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846034;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846033;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846032;
      BaseApplicationImpl.qqwifinotifydivide = 2131166204;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130843408;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (akcz.a()))
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