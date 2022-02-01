package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import anrj;
import bgsj;
import bgsu;
import blfs;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.logcathook.LogcatHook;
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
      IPluginAdapterProxy.setProxy(new blfs());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new bgsj());
      bgsu.a();
      BaseApplicationImpl.appnewmsgicon = 2130841393;
      BaseApplicationImpl.appnewavmsgicon = 2130842092;
      BaseApplicationImpl.qqlaunchicon = 2130840337;
      BaseApplicationImpl.qqWifiLayout = 2131561896;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131381218;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131381219;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131381210;
      BaseApplicationImpl.qqWifiSettingViewId = 2131381217;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131381220;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131381221;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131381211;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846926;
      BaseApplicationImpl.qqWifiNoSignal = 2130846927;
      BaseApplicationImpl.qqWifiUserful = 2130846932;
      BaseApplicationImpl.qqWifiSettings = 2130846931;
      BaseApplicationImpl.qqWifiOperation = 2130846925;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846930;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846929;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846928;
      BaseApplicationImpl.qqwifinotifydivide = 2131166324;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130844220;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (anrj.a()))
      {
        MobileQQActivityLifeCycle localMobileQQActivityLifeCycle = new MobileQQActivityLifeCycle(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
        UEC.a().a(localMobileQQActivityLifeCycle);
      }
      try
      {
        Class.forName("android.os.AsyncTask");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        try
        {
          for (;;)
          {
            LogcatHook.a();
            if (BaseApplicationImpl.sProcessId != 1) {
              break label317;
            }
            return true;
            if ((BaseApplicationImpl.sProcessId == 4) || (BaseApplicationImpl.sProcessId != 2)) {
              break;
            }
            l = System.currentTimeMillis();
            BaseApplicationImpl.sLaunchTime = l;
            BaseApplicationImpl.sShowTime = l;
            BaseApplicationImpl.appStartTime = BaseApplicationImpl.sLaunchTime;
            break;
            localClassNotFoundException = localClassNotFoundException;
            localClassNotFoundException.printStackTrace();
          }
        }
        catch (Throwable localThrowable)
        {
          for (;;)
          {
            Log.e("LogcatHook", "LogcatHook start failed !!", localThrowable);
          }
        }
      }
    }
    label317:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */