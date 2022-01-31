package com.tencent.mobileqq.startup.step;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.QFixApplicationImpl;
import com.tencent.mobileqq.msf.core.net.patch.PatchSharedPreUtil;
import ytb;
import ytc;

class Rdm$1
  implements Runnable
{
  Rdm$1(Rdm paramRdm, String paramString) {}
  
  public void run()
  {
    ytb localytb = ytc.a(BaseApplicationImpl.sApplication, "dex");
    if ((localytb != null) && (localytb.a(BaseApplicationImpl.sApplication, true))) {
      PatchSharedPreUtil.updateCountFailStartupPatch(BaseApplicationImpl.sApplication, this.a, localytb.b(), 0);
    }
    QFixApplicationImpl.a(BaseApplicationImpl.sApplication);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Rdm.1
 * JD-Core Version:    0.7.0.1
 */