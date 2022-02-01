package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SoLoadReportImpl;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qqperf.monitor.logcathook.LogcatHook;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.Foreground;
import mqq.app.lifecycle.UECActivityLifeCycle;
import mqq.os.MqqHandler;

public class OldApplication
  extends Step
{
  protected boolean doStep()
  {
    boolean bool = false;
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
    else if ((BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId == 2))
    {
      l = System.currentTimeMillis();
      BaseApplicationImpl.sLaunchTime = l;
      BaseApplicationImpl.sShowTime = l;
      BaseApplicationImpl.appStartTime = BaseApplicationImpl.sLaunchTime;
    }
    BaseApplicationImpl.sApplication.superOnCreate();
    SoLoadUtilNew.setReport(new SoLoadReportImpl());
    TimeFormatterUtils.a();
    BaseApplicationImpl.appnewmsgicon = 2130842313;
    BaseApplicationImpl.appnewavmsgicon = 2130843136;
    BaseApplicationImpl.qqlaunchicon = 2130841158;
    BaseApplicationImpl.qqWifiLayout = 2131628227;
    BaseApplicationImpl.qqWifiStateIconViewId = 2131450151;
    BaseApplicationImpl.qqWifiStateTextViewId = 2131450152;
    BaseApplicationImpl.qqWifiOperationTextViewId = 2131450143;
    BaseApplicationImpl.qqWifiSettingViewId = 2131450150;
    BaseApplicationImpl.qqWifiStateTextSingleLine = 2131450153;
    BaseApplicationImpl.qqWifiTextDoubleLine = 2131450154;
    BaseApplicationImpl.qqWifiRedTouchViewId = 2131450144;
    BaseApplicationImpl.qqWifiConnecticon3 = 2130848724;
    BaseApplicationImpl.qqWifiNoSignal = 2130848725;
    BaseApplicationImpl.qqWifiUserful = 2130848730;
    BaseApplicationImpl.qqWifiSettings = 2130848729;
    BaseApplicationImpl.qqWifiOperation = 2130848723;
    BaseApplicationImpl.qqwifinotifyusefulicon = 2130848728;
    BaseApplicationImpl.qqwifinotifynoneicon = 2130848727;
    BaseApplicationImpl.qqwifinotifyconnectedicon = 2130848726;
    BaseApplicationImpl.qqwifinotifydivide = 2131167205;
    BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
    BaseApplicationImpl.devlockQuickloginIcon = 2130845599;
    Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
    if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (PrivacyPolicyHelper.d())) {
      Foreground.addActivityLifeCallback(new UECActivityLifeCycle(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName));
    }
    if (!PrivacyPolicyHelper.d())
    {
      BeaconReport.getInstance().setCollectMac(false);
      BeaconReport.getInstance().setCollectImei(false);
      BeaconReport.getInstance().setCollectAndroidID(false);
    }
    try
    {
      Class.forName("android.os.AsyncTask");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    try
    {
      if ((!LogcatHook.sLogcatHooked.get()) && (LogcatHook.ENABEL_SYSLOG_IN_APPLICATION)) {
        LogcatHook.startHookLogcat();
      }
    }
    catch (Throwable localThrowable)
    {
      Log.e("LogcatHook", "LogcatHook start failed !!", localThrowable);
    }
    if (BaseApplicationImpl.sProcessId == 1) {
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.OldApplication
 * JD-Core Version:    0.7.0.1
 */