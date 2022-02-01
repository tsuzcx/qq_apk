package com.tencent.mobileqq.startup.step;

import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.IScreenShotShareHandler;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.compact.LoadCompactDynamicFeature;
import com.tencent.mobileqq.haoliyou.IATHandler;
import com.tencent.mobileqq.managers.MsgPushReportHelper;
import com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor;
import com.tencent.mobileqq.vfs.ReportCallback;
import com.tencent.mobileqq.vfs.VFSRegisterProxy;
import com.tencent.open.appstore.dl.TMADownloadMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.file.ExternalDirFileOperationMonitor;
import com.tencent.qqperf.monitor.file.ExternalDirOperationConfig;
import com.tencent.qqperf.opt.threadpriority.ThreadRegulator;
import com.tencent.qqperf.tools.SceneTracker;
import com.tencent.tmdownloader.notify.DownloadTaskNotifier;
import com.tencent.util.notification.NotificationReportControllerImpl;
import java.lang.reflect.Method;
import mqq.os.MqqHandler;

public class LoadDex
  extends Step
{
  private void a()
  {
    try
    {
      NotificationReportControllerImpl localNotificationReportControllerImpl;
      if (Build.VERSION.SDK_INT >= 21) {
        localNotificationReportControllerImpl = new NotificationReportControllerImpl();
      } else {
        localNotificationReportControllerImpl = (NotificationReportControllerImpl)Class.forName("com.tencent.util.notification.NotificationReportControllerImpl").newInstance();
      }
      NotificationReportUtil.setReport(localNotificationReportControllerImpl);
      MsgPushReportHelper.a(localNotificationReportControllerImpl);
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("initNotificationReport", 1, "initNotificationReport throws e", localThrowable);
    }
  }
  
  private void b()
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
  
  private void c()
  {
    if (ExternalDirOperationConfig.a(BaseApplicationImpl.sApplication))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExternalDirFileOperationMonitor", 2, "init hook");
      }
      NativeMemoryMonitor.getInstance(BaseApplicationImpl.getContext()).setupFileHook(new ExternalDirFileOperationMonitor(BaseApplicationImpl.getContext()));
    }
  }
  
  protected boolean doStep()
  {
    if ("Success".equals(BaseApplicationImpl.sInjectResult))
    {
      DexPatchInstaller.a(BaseApplicationImpl.sApplication);
      return true;
    }
    boolean bool1;
    if (this.mId == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    BaseApplicationImpl.sInjectResult = InjectUtils.injectExtraDexes(BaseApplicationImpl.sApplication, bool1);
    if (bool1)
    {
      boolean bool2;
      if (BaseApplicationImpl.sInjectResult == null) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      com.tencent.mobileqq.automator.AutomatorHelper.b = bool2;
    }
    if ((!bool1) && (!"Success".equals(BaseApplicationImpl.sInjectResult))) {
      return false;
    }
    if ("Success".equals(BaseApplicationImpl.sInjectResult)) {}
    for (;;)
    {
      try
      {
        DexPatchInstaller.a(BaseApplicationImpl.sApplication);
        VFSRegisterProxy localVFSRegisterProxy = VFSRegisterProxy.a();
        BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
        ReportCallback localReportCallback = ReportCallback.a();
        if (BaseApplicationImpl.sProcessId != 1) {
          break label551;
        }
        bool1 = true;
        localVFSRegisterProxy.a(localBaseApplicationImpl, localReportCallback, bool1, false);
        if (BaseApplicationImpl.sProcessId == 1)
        {
          eipc.EIPCContentProvider.sIsDexInjectFinish = true;
          ThreadRegulator.a().a();
        }
        if (BaseApplicationImpl.sProcessId != 4)
        {
          Step.AmStepFactory.a();
          Step.QIPCConnectStep.a();
        }
        if (2 != BaseApplicationImpl.sProcessId) {
          if ((7 != BaseApplicationImpl.sProcessId) && (11 != BaseApplicationImpl.sProcessId))
          {
            if (1 != BaseApplicationImpl.sProcessId) {
              ThreadManager.getSubThreadHandler().postDelayed(Step.AmStepFactory.b(14, this.mDirector, null), 3000L);
            }
          }
          else {
            ThreadManager.getSubThreadHandler().post(Step.AmStepFactory.b(14, this.mDirector, null));
          }
        }
        LoadCompactDynamicFeature.a().a();
        if (1 == BaseApplicationImpl.sProcessId) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.1(this), 30000L);
        } else {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.2(this), 5000L);
        }
        if (1 == BaseApplicationImpl.sProcessId) {
          ThreadManager.getFileThreadHandler().post(new LoadDex.3(this));
        }
        if (BaseApplicationImpl.sProcessId != 1) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.4(this), 3000L);
        }
        if (BaseApplicationImpl.sProcessId == 4) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.5(this), 3000L);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.6(this), 3000L);
        if ((BaseApplicationImpl.processName != null) && (Build.VERSION.SDK_INT >= 21) && (BaseApplicationImpl.processName.endsWith("TMAssistantDownloadSDKService"))) {
          DownloadTaskNotifier.get().addListener(TMADownloadMonitor.a());
        }
        if (Build.VERSION.SDK_INT < 21)
        {
          bool1 = Step.AmStepFactory.b(6, this.mDirector, null).step();
          if (QLog.isColorLevel()) {
            QLog.d("LoadDex", 2, new Object[] { "try init LoadModule after LoadDex Finish, result=", Boolean.valueOf(bool1) });
          }
        }
        if (BaseApplicationImpl.sProcessId == 1) {
          Step.AmStepFactory.b(8, this.mDirector, null).step();
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.8(this), 5000L);
        c();
        if (BaseApplicationImpl.sProcessId != 1) {
          SceneTracker.a();
        }
        IATHandler.a();
        IScreenShotShareHandler.a();
        b();
        a();
        return true;
      }
      catch (Exception localException)
      {
        QLog.e("LoadDex", 1, "doStep: failed. ", localException);
      }
      return true;
      label551:
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex
 * JD-Core Version:    0.7.0.1
 */