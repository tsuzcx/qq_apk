package com.tencent.mobileqq.startup.step;

import aike;
import aikf;
import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.cache.MemoryClearManagerNew;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.dalvik.DalvikReplacer;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NewRuntime
  extends Step
{
  public static int a;
  public static int b;
  
  protected boolean a()
  {
    if (Build.VERSION.SDK_INT <= 20) {
      b();
    }
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      try
      {
        if (new File(BaseApplicationImpl.getContext().getFilesDir(), "disableSmallLock").exists()) {
          continue;
        }
        bool = true;
        AppSetting.a = bool;
      }
      catch (Exception localException)
      {
        boolean bool;
        AppRuntime localAppRuntime;
        AppSetting.a = false;
        continue;
      }
      QLog.i("QQAppInterface", 1, "enableManagerSmallLock " + AppSetting.a);
      BaseApplicationImpl.sApplication.doInit(false);
      if ((GuardManager.a == null) && ("com.tencent.mobileqq".equals(BaseApplicationImpl.processName))) {
        GuardManager.a = new GuardManager(BaseApplicationImpl.sApplication, 0);
      }
      if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 9) || (BaseApplicationImpl.sProcessId == 10))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MemoryClearManagerNew_NewRuntime", 2, "setAppStateChangeListener");
        }
        localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (localAppRuntime != null) {
          localAppRuntime.setAppStateChangeListener(MemoryClearManagerNew.a());
        }
      }
      if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId != -1)) {
        ThreadManager.getSubThreadHandler().postDelayed(new aike(this), 5000L);
      }
      return true;
      bool = false;
    }
  }
  
  @SuppressLint({"InlinedApi"})
  public boolean b()
  {
    boolean bool = false;
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("sp_hack_dvm", 4);
    int j = localSharedPreferences.getInt("key_continuous_crash_count", 0);
    int i = j;
    if (j < 4)
    {
      i = j;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        i = j;
        if (localSharedPreferences.getLong("key_last_hack_verify_time", 0L) > 0L)
        {
          i = j + 1;
          localSharedPreferences.edit().putInt("key_continuous_crash_count", i).commit();
        }
      }
    }
    if (i < 4) {
      bool = true;
    }
    if ((bool) && (BaseApplicationImpl.sProcessId == 1)) {
      localSharedPreferences.edit().putLong("key_last_hack_verify_time", System.currentTimeMillis()).commit();
    }
    DalvikReplacer.a(BaseApplicationImpl.sApplication, 20971520, bool);
    QLog.e("QQAppInterface", 1, "laResult: " + DalvikReplacer.a + ", verifyResult: " + DalvikReplacer.b);
    a = DalvikReplacer.a;
    if (bool) {
      b = DalvikReplacer.b;
    }
    if ((bool) && (BaseApplicationImpl.sProcessId == 1)) {
      ThreadManager.getSubThreadHandler().postDelayed(new aikf(this), 5000L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NewRuntime
 * JD-Core Version:    0.7.0.1
 */