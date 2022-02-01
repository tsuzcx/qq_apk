package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSSoLoader;
import com.tencent.mobileqq.kandian.repo.pts.PTSStyleManager;
import com.tencent.qphone.base.util.QLog;

class PTSLiteSwitchManager$1
  implements Runnable
{
  PTSLiteSwitchManager$1(PTSLiteSwitchManager paramPTSLiteSwitchManager) {}
  
  public void run()
  {
    Object localObject = Aladdin.getConfig(289);
    boolean bool2 = false;
    boolean bool1;
    if ((localObject != null) && (((AladdinConfig)localObject).getIntegerFromString("pts_lite_switch", 0) == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[init], ptsLiteSwitchTmp = ");
    ((StringBuilder)localObject).append(bool1);
    QLog.i("PTSLiteSwitchManager", 1, ((StringBuilder)localObject).toString());
    localObject = Aladdin.getConfig(332);
    if ((localObject == null) || (((AladdinConfig)localObject).getIntegerFromString("enabled", 1) == 1)) {
      bool2 = true;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[init], ptsLiteMasterSwitchTmp = ");
    ((StringBuilder)localObject).append(bool2);
    QLog.i("PTSLiteSwitchManager", 1, ((StringBuilder)localObject).toString());
    if ((bool1) || (bool2))
    {
      PTSHelper.b();
      PTSSoLoader.a().a("ptslite");
      PTSStyleManager.a().a();
    }
    PTSLiteSwitchManager.a(this.this$0, bool1);
    PTSLiteSwitchManager.b(this.this$0, bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */