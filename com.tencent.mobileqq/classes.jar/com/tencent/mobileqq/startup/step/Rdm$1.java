package com.tencent.mobileqq.startup.step;

import aarp;
import aarq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QFixApplicationImpl;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;

class Rdm$1
  implements Runnable
{
  Rdm$1(Rdm paramRdm, String paramString) {}
  
  public void run()
  {
    aarp localaarp = aarq.a(BaseApplicationImpl.sApplication, "dex");
    if ((localaarp != null) && (localaarp.a(BaseApplicationImpl.sApplication, true))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, this.a, localaarp.b(), 0);
    }
    QFixApplicationImpl.a(BaseApplicationImpl.sApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm.1
 * JD-Core Version:    0.7.0.1
 */