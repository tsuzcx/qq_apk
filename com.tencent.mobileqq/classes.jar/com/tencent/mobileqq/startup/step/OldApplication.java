package com.tencent.mobileqq.startup.step;

import amxq;
import android.os.Build.VERSION;
import android.os.SystemClock;
import bfzc;
import bfzl;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
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
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new bfzc());
      bfzl.a();
      BaseApplicationImpl.appnewmsgicon = 2130841439;
      BaseApplicationImpl.appnewavmsgicon = 2130842146;
      BaseApplicationImpl.qqlaunchicon = 2130840385;
      BaseApplicationImpl.qqWifiLayout = 2131561814;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131381109;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131381110;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131381101;
      BaseApplicationImpl.qqWifiSettingViewId = 2131381108;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131381111;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131381112;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131381102;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846851;
      BaseApplicationImpl.qqWifiNoSignal = 2130846852;
      BaseApplicationImpl.qqWifiUserful = 2130846857;
      BaseApplicationImpl.qqWifiSettings = 2130846856;
      BaseApplicationImpl.qqWifiOperation = 2130846850;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846855;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846854;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846853;
      BaseApplicationImpl.qqwifinotifydivide = 2131166347;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130844119;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (amxq.a()))
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