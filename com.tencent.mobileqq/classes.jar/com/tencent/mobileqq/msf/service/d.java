package com.tencent.mobileqq.msf.service;

import android.os.IBinder.DeathRecipient;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.j;
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
    boolean bool = i.a().g();
    QLog.w("MSF.S.AppProcessInfo", 1, String.format("binderDied appProcessName = %s, keepProcessAlive = %s, isBinderConnectOptEnable = %b", new Object[] { this.a.g, Boolean.valueOf(this.a.k), Boolean.valueOf(bool) }));
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (MsfCore.sCore != null)
    {
      localObject1 = localObject2;
      if (MsfCore.sCore.getAccountCenter() != null) {
        localObject1 = MsfCore.sCore.getAccountCenter().i();
      }
    }
    if (this.a.k) {
      u.a(BaseApplication.getContext(), this.a.g, (String)localObject1, this.a.h, 0, 1, null);
    }
    this.a.k = false;
    if (bool) {
      this.a.a(this.a.c());
    }
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("process", this.a.g);
    ((HashMap)localObject2).put("isUseNewProxy", String.valueOf(MsfServiceSdk.isUseNewProxy));
    ((HashMap)localObject2).put("isProcess_exist", String.valueOf(MsfSdkUtils.isProcessExist(BaseApplication.getContext(), this.a.g)));
    ((HashMap)localObject2).put("account_uin", localObject1);
    ((HashMap)localObject2).put("isBinderConnectOptEnable", String.valueOf(bool));
    if (MsfService.getCore().getStatReporter() != null) {
      MsfService.getCore().getStatReporter().a("msf_binder_died_b", false, 0L, 0L, (Map)localObject2, true, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.d
 * JD-Core Version:    0.7.0.1
 */