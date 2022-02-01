package com.tencent.mobileqq.startup.step;

import android.os.Looper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qqperf.opt.clearmemory.MemoryClearManager;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class NewRuntime
  extends Step
{
  protected boolean doStep()
  {
    int i;
    if (BaseApplicationImpl.sProcessId == 1) {
      i = 41;
    } else {
      i = 43;
    }
    Step.AmStepFactory.b(i, this.mDirector, null).step();
    if (BaseApplicationImpl.sProcessId == 1) {}
    try
    {
      if (new File(BaseApplicationImpl.getContext().getFilesDir(), "disableSmallLock").exists()) {
        break label394;
      }
      bool = true;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        boolean bool = false;
      }
    }
    AppSetting.b = bool;
    break label73;
    AppSetting.b = false;
    label73:
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("enableManagerSmallLock ");
    ((StringBuilder)localObject).append(AppSetting.b);
    QLog.i("QQAppInterface", 1, ((StringBuilder)localObject).toString());
    if ((BaseApplicationImpl.sProcessId == 1) && (SafeModeUtil.a(BaseApplicationImpl.sApplication)))
    {
      BaseApplicationImpl.sApplication.doInit(true);
      localObject = BaseApplicationImpl.getApplication().getRuntime();
      if ((localObject != null) && ((localObject instanceof QQAppInterface)))
      {
        SafeModeUtil.a();
        SafeModeUtil.a("QQ处于安全模式");
        localObject = (QQAppInterface)localObject;
        str = ((QQAppInterface)localObject).getCurrentAccountUin();
        ConfigServlet.a((QQAppInterface)localObject, 283, str);
        PatchConfigServlet.a((QQAppInterface)localObject, str, -1, "SafeMode");
        QLog.d("SafeModeUtil", 1, "request Patch and CmdConfig for SafeMode");
        if ((Looper.getMainLooper().getThread() != Thread.currentThread()) && (((QQAppInterface)localObject).isLogin()))
        {
          QLog.d("SafeModeUtil", 1, "waiting config for max 10s in SafeMode");
          BaseApplicationImpl.sLaunchTime = 0L;
          BaseApplicationImpl.sShowTime = 0L;
          SafeModeUtil.b();
        }
      }
    }
    else
    {
      BaseApplicationImpl.sApplication.doInit(false);
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
        ((AppRuntime)localObject).setAppStateChangeListener(MemoryClearManager.a());
      }
    }
    if ((BaseApplicationImpl.sProcessId != 1) && (BaseApplicationImpl.sProcessId != 4) && (BaseApplicationImpl.sProcessId != -1)) {
      ThreadManager.getSubThreadHandler().postDelayed(new NewRuntime.1(this), 5000L);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.NewRuntime
 * JD-Core Version:    0.7.0.1
 */