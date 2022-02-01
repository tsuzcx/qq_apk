package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import aodp;
import bhsl;
import bhsw;
import bmgv;
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
      IPluginAdapterProxy.setProxy(new bmgv());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new bhsl());
      bhsw.a();
      BaseApplicationImpl.appnewmsgicon = 2130841403;
      BaseApplicationImpl.appnewavmsgicon = 2130842104;
      BaseApplicationImpl.qqlaunchicon = 2130840347;
      BaseApplicationImpl.qqWifiLayout = 2131561937;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131381391;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131381392;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131381383;
      BaseApplicationImpl.qqWifiSettingViewId = 2131381390;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131381393;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131381394;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131381384;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846943;
      BaseApplicationImpl.qqWifiNoSignal = 2130846944;
      BaseApplicationImpl.qqWifiUserful = 2130846949;
      BaseApplicationImpl.qqWifiSettings = 2130846948;
      BaseApplicationImpl.qqWifiOperation = 2130846942;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846947;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846946;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846945;
      BaseApplicationImpl.qqwifinotifydivide = 2131166328;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130844234;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (aodp.a()))
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
            if (BaseApplicationImpl.sProcessId != 9) {
              LogcatHook.a();
            }
            if (BaseApplicationImpl.sProcessId != 1) {
              break label325;
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
    label325:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */