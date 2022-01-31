package com.tencent.mobileqq.startup.step;

import aife;
import aiff;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hotpatch.DexPatchInstaller;
import com.tencent.hotpatch.PatchSecurityMode;
import com.tencent.mobileqq.app.InjectUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadRegulator;
import mqq.os.MqqHandler;

public class LoadDex
  extends Step
{
  protected boolean a()
  {
    if ("Success".equals(BaseApplicationImpl.sInjectResult))
    {
      if (BaseApplicationImpl.sProcessId == 1) {
        PatchSecurityMode.a(BaseApplicationImpl.sApplication);
      }
      DexPatchInstaller.a(BaseApplicationImpl.sApplication);
    }
    for (;;)
    {
      return true;
      boolean bool1;
      if ((!AppSetting.a()) || (this.c == 1))
      {
        bool1 = true;
        BaseApplicationImpl.sInjectResult = InjectUtils.injectExtraDexes(BaseApplicationImpl.sApplication, bool1);
        if (bool1) {
          if (BaseApplicationImpl.sInjectResult != null) {
            break label96;
          }
        }
      }
      label96:
      for (boolean bool2 = true;; bool2 = false)
      {
        BaseApplicationImpl.isCurrentVersionFirstLaunch = bool2;
        if ((bool1) || ("Success".equals(BaseApplicationImpl.sInjectResult))) {
          break label101;
        }
        return false;
        bool1 = false;
        break;
      }
      label101:
      if ("Success".equals(BaseApplicationImpl.sInjectResult)) {
        try
        {
          if (BaseApplicationImpl.sProcessId == 1) {
            PatchSecurityMode.a(BaseApplicationImpl.sApplication);
          }
          DexPatchInstaller.a(BaseApplicationImpl.sApplication);
          if (BaseApplicationImpl.sProcessId == 1) {
            ThreadRegulator.a().a();
          }
          if (BaseApplicationImpl.sProcessId != 4)
          {
            Step.AmStepFactory.a();
            Step.QIPCConnectStep.a();
          }
          if (2 != BaseApplicationImpl.sProcessId) {
            ThreadManager.getSubThreadHandler().postDelayed(Step.AmStepFactory.b(12, this.a, null), 3000L);
          }
          if ((1 == BaseApplicationImpl.sProcessId) || (2 == BaseApplicationImpl.sProcessId) || (8 == BaseApplicationImpl.sProcessId) || (7 == BaseApplicationImpl.sProcessId)) {
            Step.AmStepFactory.b(14, this.a, null).c();
          }
          if (BaseApplicationImpl.sProcessId != 1) {
            ThreadManager.getSubThreadHandler().postDelayed(new aife(this), 3000L);
          }
          if (BaseApplicationImpl.sProcessId == 4) {
            ThreadManager.getSubThreadHandler().postDelayed(new aiff(this), 3000L);
          }
          if (BaseApplicationImpl.sProcessId == 1)
          {
            Step.AmStepFactory.b(6, this.a, null).c();
            Step.AmStepFactory.b(38, this.a, null).c();
            return true;
          }
        }
        catch (Exception localException) {}
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadDex
 * JD-Core Version:    0.7.0.1
 */