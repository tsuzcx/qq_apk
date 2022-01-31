package com.tencent.mobileqq.startup.step;

import ajop;
import android.os.Build.VERSION;
import android.os.SystemClock;
import baij;
import baiu;
import bfdk;
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
      IPluginAdapterProxy.setProxy(new bfdk());
      BaseApplicationImpl.sApplication.superOnCreate();
      SoLoadUtilNew.setReport(new baij());
      baiu.a();
      BaseApplicationImpl.appnewmsgicon = 2130840949;
      BaseApplicationImpl.appnewavmsgicon = 2130841532;
      BaseApplicationImpl.qqlaunchicon = 2130839762;
      BaseApplicationImpl.qqWifiLayout = 2131495861;
      BaseApplicationImpl.qqWifiStateIconViewId = 2131313618;
      BaseApplicationImpl.qqWifiStateTextViewId = 2131313619;
      BaseApplicationImpl.qqWifiOperationTextViewId = 2131313610;
      BaseApplicationImpl.qqWifiSettingViewId = 2131313617;
      BaseApplicationImpl.qqWifiStateTextSingleLine = 2131313620;
      BaseApplicationImpl.qqWifiTextDoubleLine = 2131313621;
      BaseApplicationImpl.qqWifiRedTouchViewId = 2131313611;
      BaseApplicationImpl.qqWifiConnecticon3 = 2130845849;
      BaseApplicationImpl.qqWifiNoSignal = 2130845850;
      BaseApplicationImpl.qqWifiUserful = 2130845855;
      BaseApplicationImpl.qqWifiSettings = 2130845854;
      BaseApplicationImpl.qqWifiOperation = 2130845848;
      BaseApplicationImpl.qqwifinotifyusefulicon = 2130845853;
      BaseApplicationImpl.qqwifinotifynoneicon = 2130845852;
      BaseApplicationImpl.qqwifinotifyconnectedicon = 2130845851;
      BaseApplicationImpl.qqwifinotifydivide = 2131100614;
      BaseApplicationImpl.defaultNotifSoundResourceId = 2131230721;
      BaseApplicationImpl.devlockQuickloginIcon = 2130843326;
      Foreground.init(BaseApplicationImpl.sApplication, ThreadManager.getSubThreadLooper(), BaseApplicationImpl.processName);
      if ((Build.VERSION.SDK_INT >= 15) && ("Success".equals(BaseApplicationImpl.sInjectResult)) && (ajop.a()))
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