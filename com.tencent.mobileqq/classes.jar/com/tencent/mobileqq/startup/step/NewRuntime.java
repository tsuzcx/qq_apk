package com.tencent.mobileqq.startup.step;

import aawh;
import android.os.Looper;
import aozj;
import azpf;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import zhx;
import zie;

public class NewRuntime
  extends Step
{
  protected boolean doStep()
  {
    int i;
    if (BaseApplicationImpl.sProcessId == 1)
    {
      i = 41;
      azpf.b(i, this.mDirector, null).step();
      if (BaseApplicationImpl.sProcessId != 1) {}
    }
    for (;;)
    {
      try
      {
        if (new File(BaseApplicationImpl.getContext().getFilesDir(), "disableSmallLock").exists()) {
          continue;
        }
        bool = true;
        AppSetting.b = bool;
      }
      catch (Exception localException)
      {
        boolean bool;
        Object localObject;
        String str;
        AppSetting.b = false;
        continue;
        BaseApplicationImpl.sApplication.doInit(false);
        continue;
      }
      QLog.i("QQAppInterface", 1, "enableManagerSmallLock " + AppSetting.b);
      if ((BaseApplicationImpl.sProcessId != 1) || (!zhx.a(BaseApplicationImpl.sApplication))) {
        continue;
      }
      BaseApplicationImpl.sApplication.doInit(true);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        zhx.a();
        zhx.a("QQ处于安全模式");
        localObject = (QQAppInterface)localObject;
        str = ((QQAppInterface)localObject).getCurrentAccountUin();
        aozj.a((QQAppInterface)localObject, 283, str);
        aawh.a((QQAppInterface)localObject, str, -1, "SafeMode");
        QLog.d("SafeModeUtil", 1, "request Patch and CmdConfig for SafeMode");
        if ((Looper.getMainLooper().getThread() != Thread.currentThread()) && (((QQAppInterface)localObject).isLogin()))
        {
          QLog.d("SafeModeUtil", 1, "waiting config for max 10s in SafeMode");
          BaseApplicationImpl.sLaunchTime = 0L;
          BaseApplicationImpl.sShowTime = 0L;
          zhx.b();
        }
      }
      if ((GuardManager.a == null) && ("com.tencent.mobileqq".equals(BaseApplicationImpl.processName))) {
        GuardManager.a = new GuardManager(BaseApplicationImpl.sApplication, 0);
      }
      if ((BaseApplicationImpl.sProcessId == 2) || (BaseApplicationImpl.sProcessId == 5) || (BaseApplicationImpl.sProcessId == 7) || (BaseApplicationImpl.sProcessId == 9) || (BaseApplicationImpl.sProcessId == 11) || (BaseApplicationImpl.sProcessId == 10))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MemoryClearManagerNew_NewRuntime", 2, "setAppStateChangeListener");
        }
        localObject = BaseApplicationImpl.getApplication().getRuntime();
        if (localObject != null) {
          ((AppRuntime)localObject).setAppStateChangeListener(zie.a());
        }
      }
      if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId != -1)) {
        ThreadManager.getSubThreadHandler().postDelayed(new NewRuntime.1(this), 5000L);
      }
      return true;
      i = 43;
      break;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NewRuntime
 * JD-Core Version:    0.7.0.1
 */