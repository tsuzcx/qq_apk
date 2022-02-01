package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.logcathook.LogcatHook;
import com.tencent.mobileqq.utils.SoLoadReportImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Foreground;
import mqq.app.lifecycle.UECActivityLifeCycle;
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
      SoLoadUtilNew.setReport(new SoLoadReportImpl());
      TimeFormatterUtils.a();
      BaseApplicationImpl.appnewmsgicon = 2130841588;
      BaseApplicationImpl.appnewavmsgicon = 2130842303;
      BaseApplicationImpl.qqlaunchicon = 2130840535;
      BaseApplicationImpl.qqWifiLayout = 2131562015;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131381929;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131381930;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131381921;
      BaseApplicationImpl.qqWifiSettingViewId = 2131381928;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131381931;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131381932;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131381922;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130847302;
      BaseApplicationImpl.qqWifiNoSignal = 2130847303;
      BaseApplicationImpl.qqWifiUserful = 2130847308;
      BaseApplicationImpl.qqWifiSettings = 2130847307;
      BaseApplicationImpl.qqWifiOperation = 2130847301;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130847306;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130847305;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130847304;
      BaseApplicationImpl.qqwifinotifydivide = 2131166359;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130844376;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (PrivacyPolicyHelper.a())) {
        Foreground.addActivityLifeCallback(new UECActivityLifeCycle(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName));
      }
      if (!PrivacyPolicyHelper.a())
      {
        com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC = false;
        com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI = false;
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
            if ((!LogcatHook.sLogcatHooked.get()) && (LogcatHook.ENABEL_SYSLOG_IN_APPLICATION)) {
              LogcatHook.startHookLogcat();
            }
            if (BaseApplicationImpl.sProcessId != 1) {
              break label331;
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
    label331:
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */