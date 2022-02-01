package com.tencent.mobileqq.msf.core;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.d;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.core.stepcount.i;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.msf.service.k;
import com.tencent.mobileqq.msf.service.l;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

class n
  extends Thread
{
  n(MsfCore paramMsfCore, j paramj, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    this.e.netFlowStore = new d(MsfCore.sCore, BaseApplication.getContext());
    try
    {
      BaseApplication.monitor.start();
    }
    catch (Throwable localThrowable)
    {
      QLog.d("MSF.C.MsfCore", 1, "", localThrowable);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init netflow monitor cost=");
    ((StringBuilder)localObject).append(SystemClock.elapsedRealtime() - l);
    QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject).toString());
    l = SystemClock.elapsedRealtime();
    this.a.f();
    if (this.a.c())
    {
      this.e.statReporter = this.a;
      if (k.f)
      {
        QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_Log do report JobScheduler alive MSF to rdm in msfcore init");
        k.a(true);
      }
      this.e.store.reportLoadCfgTempFile();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init beacon Cost=");
    ((StringBuilder)localObject).append(SystemClock.elapsedRealtime() - l);
    QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject).toString());
    l = SystemClock.elapsedRealtime();
    if (l.a)
    {
      QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_REPORT_Log do report MSF alive to bigT in msfcore init");
      l.a(null);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init BigT Cost=");
    ((StringBuilder)localObject).append(SystemClock.elapsedRealtime() - l);
    QLog.d("MSF.C.MsfCore", 1, ((StringBuilder)localObject).toString());
    l = SystemClock.elapsedRealtime();
    if (this.e.bLoadUseTxlib)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("bLoadUseTxlib", String.valueOf(this.e.bLoadUseTxlib));
      localHashMap.put("newVersion", String.valueOf(this.b));
      localHashMap.put("oldVersion", String.valueOf(this.c));
      if (o.d() == null) {
        localObject = "null";
      } else {
        localObject = o.d();
      }
      localHashMap.put("imei", localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Build.MANUFACTURER);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(Build.MODEL);
      localHashMap.put("product", ((StringBuilder)localObject).toString());
      localHashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
      localHashMap.put("platform", c.c(BaseApplication.getContext()));
      if (this.e.statReporter != null) {
        this.e.statReporter.a("msf.core.EvtLoadUseTxlib", true, 0L, 0L, localHashMap, false, false);
      }
    }
    try
    {
      u.a().a(MsfCore.sCore, true);
    }
    catch (Exception localException1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MsfCore", 2, localException1.toString(), localException1);
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("init wifiScan cost=");
    localStringBuilder1.append(SystemClock.elapsedRealtime() - l);
    QLog.d("MSF.C.MsfCore", 1, localStringBuilder1.toString());
    l = SystemClock.elapsedRealtime();
    try
    {
      i.b().a(this.d);
    }
    catch (Exception localException2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MSF.C.MsfCore", 2, localException2.toString(), localException2);
      }
    }
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("MsfCore init health step cost=");
    localStringBuilder2.append(SystemClock.elapsedRealtime() - l);
    QLog.d("MSF.C.MsfCore", 1, localStringBuilder2.toString());
    localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("init quic_enable=");
    localStringBuilder2.append(a.e("quic_enable"));
    localStringBuilder2.append(" version=");
    localStringBuilder2.append(QuicWrapper.getQuicResVersion());
    localStringBuilder2.append(" libpath=");
    localStringBuilder2.append(QuicWrapper.getQuicResLoadPath());
    QLog.i("MSF.C.MsfCore", 1, localStringBuilder2.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.n
 * JD-Core Version:    0.7.0.1
 */