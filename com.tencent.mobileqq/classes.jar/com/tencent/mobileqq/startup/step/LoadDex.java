package com.tencent.mobileqq.startup.step;

import aarg;
import android.os.Build.VERSION;
import asls;
import azkw;
import azky;
import bdux;
import bfgq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.tmdownloader.notify.DownloadTaskNotifier;
import mqq.os.MqqHandler;
import zdg;

public class LoadDex
  extends Step
{
  protected boolean doStep()
  {
    if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
      aarg.a(BaseApplicationImpl.sApplication);
    }
    label83:
    label88:
    do
    {
      return true;
      boolean bool1;
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
      aarg.a(BaseApplicationImpl.sApplication);
      bdux.a().a(BaseApplicationImpl.sApplication);
      if (BaseApplicationImpl.sProcessId == 1)
      {
        eipc.EIPCContentProvider.sIsDexInjectFinish = true;
        ThreadRegulator.a().a();
      }
      if (BaseApplicationImpl.sProcessId != 4)
      {
        azkw.a();
        azky.a();
      }
      if (2 != BaseApplicationImpl.sProcessId)
      {
        if ((7 != BaseApplicationImpl.sProcessId) && (11 != BaseApplicationImpl.sProcessId)) {
          break label425;
        }
        ThreadManager.getSubThreadHandler().post(azkw.b(13, this.mDirector, null));
      }
      for (;;)
      {
        if ((1 == BaseApplicationImpl.sProcessId) || (2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId) || (7 == BaseApplicationImpl.sProcessId) || (10 == BaseApplicationImpl.sProcessId)) {
          azkw.b(15, this.mDirector, null).step();
        }
        if (1 == BaseApplicationImpl.sProcessId) {
          ThreadManager.getFileThreadHandler().post(new LoadDex.1(this));
        }
        if ((Build.VERSION.SDK_INT < 24) || (BaseApplicationImpl.sProcessId != 1)) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.2(this), 3000L);
        }
        if (BaseApplicationImpl.sProcessId == 4) {
          ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.3(this), 3000L);
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.4(this), 3000L);
        if ((BaseApplicationImpl.processName != null) && (Build.VERSION.SDK_INT >= 21) && (BaseApplicationImpl.processName.endsWith("TMAssistantDownloadSDKService"))) {
          DownloadTaskNotifier.get().addListener(bfgq.a());
        }
        if (BaseApplicationImpl.sProcessId == 1) {
          azkw.b(7, this.mDirector, null).step();
        }
        ThreadManager.getSubThreadHandler().postDelayed(new LoadDex.6(this), 5000L);
        if (BaseApplicationImpl.sProcessId != 1) {
          UnifiedMonitor.e();
        }
        asls.a();
        zdg.a();
        return true;
        label425:
        if (1 != BaseApplicationImpl.sProcessId) {
          ThreadManager.getSubThreadHandler().postDelayed(azkw.b(13, this.mDirector, null), 3000L);
        }
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