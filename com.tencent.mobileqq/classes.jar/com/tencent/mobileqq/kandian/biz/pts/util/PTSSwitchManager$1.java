package com.tencent.mobileqq.kandian.biz.pts.util;

import android.os.Build;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSJSCLoader;
import com.tencent.qphone.base.util.QLog;

class PTSSwitchManager$1
  implements Runnable
{
  PTSSwitchManager$1(PTSSwitchManager paramPTSSwitchManager) {}
  
  public void run()
  {
    Object localObject = Aladdin.getConfig(266);
    boolean bool4 = false;
    boolean bool1;
    if ((localObject != null) && (((AladdinConfig)localObject).getIntegerFromString("pts_jsc_switch", 0) == 1)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    PTSSwitchManager.a(this.this$0, bool1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[init], ptsJSCEnabled = ");
    ((StringBuilder)localObject).append(PTSSwitchManager.a(this.this$0));
    QLog.i("PTSSwitchManager", 1, ((StringBuilder)localObject).toString());
    if (PTSSwitchManager.a(this.this$0))
    {
      PTSJSCLoader.a().c();
      localObject = Build.CPU_ABI;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("armeabi"))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      localObject = Aladdin.getConfig(223);
      int i;
      if ((localObject != null) && (((AladdinConfig)localObject).getIntegerFromString("pts_switch", 0) == 1)) {
        i = 1;
      } else {
        i = 0;
      }
      localObject = Aladdin.getConfig(246);
      int j;
      if ((localObject != null) && (((AladdinConfig)localObject).getIntegerFromString("pts_item_view_switch", 0) == 1)) {
        j = 1;
      } else {
        j = 0;
      }
      boolean bool2;
      if ((i != 0) && (bool1)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      boolean bool3 = bool4;
      if (j != 0)
      {
        bool3 = bool4;
        if (bool1) {
          bool3 = true;
        }
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[init], pageEnabledTmp = ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", viewEnabledTmp = ");
      ((StringBuilder)localObject).append(bool3);
      ((StringBuilder)localObject).append(", isArm = ");
      ((StringBuilder)localObject).append(bool1);
      QLog.i("PTSSwitchManager", 1, ((StringBuilder)localObject).toString());
      if ((bool2) || (bool3)) {
        PTSSwitchManager.b(this.this$0);
      }
      PTSSwitchManager.b(this.this$0, bool2);
      PTSSwitchManager.c(this.this$0, bool3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSSwitchManager.1
 * JD-Core Version:    0.7.0.1
 */