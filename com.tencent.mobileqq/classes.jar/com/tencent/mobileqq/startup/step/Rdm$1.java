package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QFixApplicationImpl;
import com.tencent.hotpatch.config.PatchConfig;
import com.tencent.hotpatch.config.PatchConfigManager;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

class Rdm$1
  implements Runnable
{
  Rdm$1(Rdm paramRdm, String paramString) {}
  
  public void run()
  {
    PatchConfig localPatchConfig = PatchConfigManager.b(BaseApplicationImpl.sApplication, "dex");
    if ((localPatchConfig != null) && (localPatchConfig.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, this.a, localPatchConfig.e(), 0);
    }
    QFixApplicationImpl.resetNTryCount(BaseApplicationImpl.sApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm.1
 * JD-Core Version:    0.7.0.1
 */