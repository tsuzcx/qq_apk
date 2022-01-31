package com.tencent.mobileqq.msf.service;

import android.os.IBinder.DeathRecipient;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class d
  implements IBinder.DeathRecipient
{
  d(c paramc) {}
  
  public void binderDied()
  {
    QLog.w("MSF.S.AppProcessInfo", 1, String.format("binderDied appProcessName=%s keepProcessAlive=%s", new Object[] { this.a.g, Boolean.valueOf(this.a.k) }));
    if (this.a.k)
    {
      String str = MsfCore.sCore.getAccountCenter().i();
      t.a(BaseApplication.getContext(), this.a.g, str, this.a.h, 0, 1, null);
    }
    this.a.k = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.service.d
 * JD-Core Version:    0.7.0.1
 */