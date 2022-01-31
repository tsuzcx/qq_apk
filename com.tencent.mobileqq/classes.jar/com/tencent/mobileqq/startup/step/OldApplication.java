package com.tencent.mobileqq.startup.step;

import alun;
import android.os.Build.VERSION;
import android.os.SystemClock;
import bdiy;
import bdjj;
import bimr;
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
      IPluginAdapterProxy.setProxy(new bimr());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new bdiy());
      bdjj.a();
      BaseApplicationImpl.appnewmsgicon = 2130841131;
      BaseApplicationImpl.appnewavmsgicon = 2130841773;
      BaseApplicationImpl.qqlaunchicon = 2130840157;
      BaseApplicationImpl.qqWifiLayout = 2131561641;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131380175;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131380176;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131380167;
      BaseApplicationImpl.qqWifiSettingViewId = 2131380174;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131380177;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131380178;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131380168;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846415;
      BaseApplicationImpl.qqWifiNoSignal = 2130846416;
      BaseApplicationImpl.qqWifiUserful = 2130846421;
      BaseApplicationImpl.qqWifiSettings = 2130846420;
      BaseApplicationImpl.qqWifiOperation = 2130846414;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846419;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846418;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846417;
      BaseApplicationImpl.qqwifinotifydivide = 2131166251;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130843762;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (alun.a()))
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