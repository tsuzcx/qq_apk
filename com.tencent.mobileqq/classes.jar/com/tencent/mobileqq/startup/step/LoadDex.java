package com.tencent.mobileqq.startup.step;

import abes;
import acut;
import android.os.Build.VERSION;
import auxf;
import bcrg;
import bcri;
import bhgh;
import bisi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmdownloader.notify.DownloadTaskNotifier;
import java.lang.reflect.Method;
import mqq.os.MqqHandler;

public class LoadDex
  extends Step
{
  private void a()
  {
    try
    {
      if (Build.VERSION.SDK_INT >= 21)
      {
        DtSdkInitStep.initDTSDK(1);
        return;
      }
      Class localClass = Class.forName("com.tencent.mobileqq.startup.step.DtSdkInitStep");
      Method localMethod = localClass.getMethod("initDTSDK", new Class[] { Integer.TYPE });
      localMethod.setAccessible(true);
      localMethod.invoke(localClass, new Object[] { Integer.valueOf(1) });
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("DtSdkInitStep", 1, "initDTSDKIfNeed throws e", localThrowable);
    }
  }
  
  protected boolean doStep()
  {
    if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
      acut.a(BaseApplicationImpl.sApplication);
    }
    boolean bool1;
    label83:
    label88:
    do
    {
      return true;
      if ((!AppSetting.b()) || (this.mId == 1))
      {
        bool1 = true;
        BaseApplicationImpl.sInjectResult = InjectUtils.injectExtraDexes(BaseApplicationImpl.sApplication, bool1);
        if (bool1) {
          if (BaseApplicationImpl.sInjectResult != null) {
            break label83;
          }
        }
      }
      for (boolean bool2 = true;; bool2 = false)
      {
        BaseApplicationImpl.isCurrentVersionFirstLaunch = bool2;
        if ((bool1) || ("Success".equals(BaseApplicationImpl.sInjectResult))) {
          break label88;
        }
        return false;
        bool1 = false;
        break;
      }
    } while (!"Success".equals(BaseApplicationImpl.sInjectResult));
    try
    {
      acut.a(BaseApplicationImpl.sApplication);
      bhgh.a().a(BaseApplicationImpl.sApplication);
      if (BaseApplicationImpl.sProcessId == 1)
      {
        eipc.EIPCContentProvider.sIsDexInjectFinish = true;
        ThreadRegulator.a().a();
      }
      if (BaseApplicationImpl.sProcessId != 4)
      {
        bcrg.a();
        bcri.a();
      }
      if (2 != BaseApplicationImpl.sProcessId)
      {
        if ((7 == BaseApplicationImpl.sProcessId) || (11 == BaseApplicationImpl.sProcessId)) {
          ThreadManager.getSubThreadHandler().post(bcrg.b(14, this.mDirector, null));
        }
      }
      else
      {
        if (1 != BaseApplicationImpl.sProcessId) {
          break label482;
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.1(this), 30000L);
      }
      for (;;)
      {
        if (1 == BaseApplicationImpl.sProcessId) {
          ThreadManager.getFileThreadHandler().post(new LoadDex.3(this));
        }
        if ((Build.VERSION.SDK_INT < 24) || (BaseApplicationImpl.sProcessId != 1)) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.4(this), 3000L);
        }
        if (BaseApplicationImpl.sProcessId == 4) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.5(this), 3000L);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.6(this), 3000L);
        if ((BaseApplicationImpl.processName != null) && (Build.VERSION.SDK_INT >= 21) && (BaseApplicationImpl.processName.endsWith("TMAssistantDownloadSDKService"))) {
          DownloadTaskNotifier.get().addListener(bisi.a());
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          bool1 = bcrg.b(6, this.mDirector, null).step();
          if (QLog.isColorLevel()) {
            QLog.d("LoadDex", 2, new Object[] { "try init LoadModule after LoadDex Finish, result=", Boolean.valueOf(bool1) });
          }
        }
        if (BaseApplicationImpl.sProcessId == 1) {
          bcrg.b(8, this.mDirector, null).step();
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.8(this), 5000L);
        if (BaseApplicationImpl.sProcessId != 1) {
          UnifiedMonitor.d();
        }
        auxf.a();
        abes.a();
        a();
        return true;
        if (1 == BaseApplicationImpl.sProcessId) {
          break;
        }
        ThreadManager.getSubThreadHandler().postDelayed(bcrg.b(14, this.mDirector, null), 3000L);
        break;
        label482:
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.2(this), 5000L);
      }
      return true;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex
 * JD-Core Version:    0.7.0.1
 */