package com.tencent.mobileqq.startup.step;

import aclx;
import acly;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QFixApplicationImpl;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

class Rdm$1
  implements Runnable
{
  Rdm$1(Rdm paramRdm, String paramString) {}
  
  public void run()
  {
    aclx localaclx = acly.a(BaseApplicationImpl.sApplication, "dex");
    if ((localaclx != null) && (localaclx.a(BaseApplicationImpl.sApplication, BaseApplicationImpl.processName))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, this.a, localaclx.b(), 0);
    }
    QFixApplicationImpl.a(BaseApplicationImpl.sApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm.1
 * JD-Core Version:    0.7.0.1
 */