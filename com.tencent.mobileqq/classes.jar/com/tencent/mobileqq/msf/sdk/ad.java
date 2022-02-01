package com.tencent.mobileqq.msf.sdk;

import android.os.IBinder.DeathRecipient;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.sdk.report.e;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ad
  implements IBinder.DeathRecipient
{
  ad(ab paramab) {}
  
  public void binderDied()
  {
    String str2 = "";
    String str1 = str2;
    if (MsfCore.sCore != null)
    {
      str1 = str2;
      if (MsfCore.sCore.getAccountCenter() != null) {
        str1 = MsfCore.sCore.getAccountCenter().i();
      }
    }
    HashMap localHashMap = new HashMap();
    if (this.a.r != null) {}
    for (str2 = this.a.r.processName;; str2 = "sdk_null")
    {
      localHashMap.put("process", str2);
      localHashMap.put("isUseNewProxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
      localHashMap.put("account_uin", str1);
      e.a(str1, "msf_binder_died_c", true, 0L, 0L, localHashMap, null, true);
      UserAction.onUserAction("msf_binder_died", false, 0L, 0L, localHashMap, true);
      QLog.i("MSF.D.RemoteServiceProxy", 1, "binderDied, process = " + str2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ad
 * JD-Core Version:    0.7.0.1
 */