package com.tencent.mobileqq.msf.core;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.d;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
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
  n(MsfCore paramMsfCore, j paramj, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    this.d.netFlowStore = new d(MsfCore.sCore, BaseApplication.getContext());
    try
    {
      BaseApplication.monitor.start();
      QLog.d("MSF.C.MsfCore", 1, "init netflow monitor cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      this.a.f();
      if (this.a.c())
      {
        this.d.statReporter = this.a;
        if (k.f)
        {
          QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_Log do report JobScheduler alive MSF to rdm in msfcore init");
          k.a(true);
        }
        this.d.store.reportLoadCfgTempFile();
      }
      QLog.d("MSF.C.MsfCore", 1, "init beacon Cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      if (l.a)
      {
        QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_REPORT_Log do report MSF alive to bigT in msfcore init");
        l.a(null);
      }
      QLog.d("MSF.C.MsfCore", 1, "init BigT Cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      if (this.d.bLoadUseTxlib)
      {
        HashMap localHashMap = new HashMap();
        localHashMap.put("bLoadUseTxlib", String.valueOf(this.d.bLoadUseTxlib));
        localHashMap.put("newVersion", String.valueOf(this.b));
        localHashMap.put("oldVersion", String.valueOf(this.c));
        if (o.d() != null) {
          break label551;
        }
        String str1 = "null";
        localHashMap.put("imei", str1);
        localHashMap.put("product", Build.MANUFACTURER + "_" + Build.MODEL);
        localHashMap.put("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        localHashMap.put("platform", c.c(BaseApplication.getContext()));
        if (this.d.statReporter != null) {
          this.d.statReporter.a("msf.core.EvtLoadUseTxlib", true, 0L, 0L, localHashMap, false, false);
        }
      }
    }
    catch (Throwable localException1)
    {
      try
      {
        u.a().a(MsfCore.sCore, true);
        QLog.d("MSF.C.MsfCore", 1, "init wifiScan cost=" + (SystemClock.elapsedRealtime() - l));
        l = SystemClock.elapsedRealtime();
      }
      catch (Exception localException1)
      {
        try
        {
          label551:
          do
          {
            for (;;)
            {
              u.a(u.O);
              QLog.d("MSF.C.MsfCore", 1, "MsfCore init health step cost=" + (SystemClock.elapsedRealtime() - l));
              QLog.i("MSF.C.MsfCore", 1, "init quic_enable=" + a.e("quic_enable") + " version=" + QuicWrapper.getQuicResVersion() + " libpath=" + QuicWrapper.getQuicResLoadPath());
              return;
              localThrowable = localThrowable;
              QLog.d("MSF.C.MsfCore", 1, "", localThrowable);
              continue;
              String str2 = o.d();
            }
            localException1 = localException1;
          } while (!QLog.isColorLevel());
          QLog.d("MSF.C.MsfCore", 2, localException1.toString(), localException1);
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("MSF.C.MsfCore", 2, localException2.toString(), localException2);
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.n
 * JD-Core Version:    0.7.0.1
 */