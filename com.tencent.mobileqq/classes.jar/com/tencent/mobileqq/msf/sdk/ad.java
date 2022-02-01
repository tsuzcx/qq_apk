package com.tencent.mobileqq.msf.sdk;

import android.os.IBinder.DeathRecipient;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class ad
  implements IBinder.DeathRecipient
{
  ad(ab paramab) {}
  
  public void binderDied()
  {
    HashMap localHashMap = new HashMap();
    if (this.a.r != null) {}
    for (String str = this.a.r.processName;; str = "sdk_null")
    {
      localHashMap.put("process", str);
      localHashMap.put("isUseNewProxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
      UserAction.onUserAction("msf_binder_died", false, 0L, 0L, localHashMap, true);
      QLog.i("MSF.D.RemoteServiceProxy", 1, "binderDied, process = " + str);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.ad
 * JD-Core Version:    0.7.0.1
 */