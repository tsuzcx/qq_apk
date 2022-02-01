package com.tencent.mobileqq.msf.service;

import android.os.IBinder.DeathRecipient;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.core.i;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class d
  implements IBinder.DeathRecipient
{
  d(c paramc) {}
  
  public void binderDied()
  {
    boolean bool = i.a().i();
    QLog.w("MSF.S.AppProcessInfo", 1, String.format("binderDied appProcessName = %s, keepProcessAlive = %s, isBinderConnectOptEnable = %b", new Object[] { this.a.g, Boolean.valueOf(this.a.k), Boolean.valueOf(bool) }));
    String str;
    if ((MsfCore.sCore != null) && (MsfCore.sCore.getAccountCenter() != null)) {
      str = MsfCore.sCore.getAccountCenter().i();
    } else {
      str = "";
    }
    if (this.a.k) {
      u.a(BaseApplication.getContext(), this.a.g, str, this.a.h, 0, 1, null);
    }
    Object localObject = this.a;
    ((c)localObject).k = false;
    if (bool) {
      ((c)localObject).a(((c)localObject).c());
    }
    localObject = new HashMap();
    ((HashMap)localObject).put("process", this.a.g);
    ((HashMap)localObject).put("isUseNewProxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
    ((HashMap)localObject).put("isProcess_exist", String.valueOf(MsfSdkUtils.isProcessExist(BaseApplication.getContext(), this.a.g)));
    ((HashMap)localObject).put("account_uin", str);
    ((HashMap)localObject).put("isBinderConnectOptEnable", String.valueOf(bool));
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("msf_binder_died_b", false, 0L, 0L, (Map)localObject, true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.d
 * JD-Core Version:    0.7.0.1
 */