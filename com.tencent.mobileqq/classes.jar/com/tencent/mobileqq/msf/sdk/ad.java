package com.tencent.mobileqq.msf.sdk;

import android.os.IBinder.DeathRecipient;
import com.tencent.beacon.event.UserAction;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.sdk.b.e;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ad
  implements IBinder.DeathRecipient
{
  ad(ab paramab) {}
  
  public void binderDied()
  {
    if ((MsfCore.sCore != null) && (MsfCore.sCore.getAccountCenter() != null)) {
      localObject = MsfCore.sCore.getAccountCenter().i();
    } else {
      localObject = "";
    }
    HashMap localHashMap = new HashMap();
    String str;
    if (this.a.r != null) {
      str = this.a.r.processName;
    } else {
      str = "sdk_null";
    }
    localHashMap.put("process", str);
    localHashMap.put("isUseNewProxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
    localHashMap.put("account_uin", localObject);
    e.a((String)localObject, "msf_binder_died_c", true, 0L, 0L, localHashMap, null, true);
    UserAction.onUserAction("msf_binder_died", false, 0L, 0L, localHashMap, true);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("binderDied, process = ");
    ((StringBuilder)localObject).append(str);
    QLog.i("MSF.D.RemoteServiceProxy", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ad
 * JD-Core Version:    0.7.0.1
 */