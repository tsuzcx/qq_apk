package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import aoae;
import bhhu;
import bhid;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.logcathook.LogcatHook;
import com.tencent.mobileqq.statistics.UEC;
import java.util.concurrent.atomic.AtomicBoolean;
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
      SoLoadUtilNew.setReport(new bhhu());
      bhid.a();
      BaseApplicationImpl.appnewmsgicon = 2130841445;
      BaseApplicationImpl.appnewavmsgicon = 2130842160;
      BaseApplicationImpl.qqlaunchicon = 2130840422;
      BaseApplicationImpl.qqWifiLayout = 2131561882;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131381468;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131381469;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131381460;
      BaseApplicationImpl.qqWifiSettingViewId = 2131381467;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131381470;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131381471;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131381461;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130846948;
      BaseApplicationImpl.qqWifiNoSignal = 2130846949;
      BaseApplicationImpl.qqWifiUserful = 2130846954;
      BaseApplicationImpl.qqWifiSettings = 2130846953;
      BaseApplicationImpl.qqWifiOperation = 2130846947;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130846952;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130846951;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130846950;
      BaseApplicationImpl.qqwifinotifydivide = 2131166356;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130844186;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (aoae.a()))
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
            if ((BaseApplicationImpl.sProcessId != 9) && (!LogcatHook.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) && (LogcatHook.jdField_a_of_type_Boolean)) {
              LogcatHook.a();
            }
            if (BaseApplicationImpl.sProcessId != 1) {
              break label330;
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
    label330:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */