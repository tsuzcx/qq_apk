package com.tencent.mobileqq.msf.core;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.a.a;
import com.tencent.mobileqq.msf.core.c.e;
import com.tencent.mobileqq.msf.core.c.k;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.mobileqq.msf.service.g;
import com.tencent.mobileqq.msf.service.h;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Properties;

class s
  extends Thread
{
  s(MsfCore paramMsfCore, k paramk, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    this.e.netFlowStore = new e(MsfCore.sCore, BaseApplication.getContext());
    try
    {
      BaseApplication.monitor.start();
      QLog.d("MSF.C.MsfCore", 1, "init netflow monitor cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      this.a.f();
      if (this.a.c())
      {
        this.e.statReporter = this.a;
        if (g.f)
        {
          QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_Log do report JobScheduler alive MSF to rdm in msfcore init");
          g.a(true);
        }
        this.e.store.reportLoadCfgTempFile();
      }
      QLog.d("MSF.C.MsfCore", 1, "init beacon Cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      if (h.a)
      {
        QLog.d("MSF.C.MsfCore", 1, "MSF_Alive_REPORT_Log do report MSF alive to bigT in msfcore init");
        h.a(null);
      }
      QLog.d("MSF.C.MsfCore", 1, "init BigT Cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      Object localObject;
      if (com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext(), false))
      {
        localObject = com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext());
        this.e.mtaReporter = ((com.tencent.mobileqq.msf.core.c.b)localObject);
      }
      QLog.d("MSF.C.MsfCore", 1, "init mtaSupport=" + com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).isMtaSupported() + " mtaCost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      Properties localProperties;
      if (MsfCore.access$000(this.e))
      {
        localProperties = new Properties();
        localProperties.setProperty("isNewVersion", String.valueOf(this.b));
        localProperties.setProperty("newVersion", String.valueOf(this.c));
        localProperties.setProperty("oldVersion", String.valueOf(this.d));
        if (t.d() == null)
        {
          localObject = "null";
          localProperties.setProperty("imei", (String)localObject);
          com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.EvtTxlibSoExist", localProperties);
        }
      }
      else if (this.e.bLoadUseTxlib)
      {
        localProperties = new Properties();
        localProperties.setProperty("bLoadUseTxlib", String.valueOf(this.e.bLoadUseTxlib));
        localProperties.setProperty("newVersion", String.valueOf(this.c));
        localProperties.setProperty("oldVersion", String.valueOf(this.d));
        if (t.d() != null) {
          break label703;
        }
        localObject = "null";
        localProperties.setProperty("imei", (String)localObject);
        localProperties.setProperty("product", Build.MANUFACTURER + "_" + Build.MODEL);
        localProperties.setProperty("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        localProperties.setProperty("platform", c.c(BaseApplication.getContext()));
        com.tencent.mobileqq.msf.core.c.b.a(BaseApplication.getContext()).reportKVEvent("msf.core.EvtLoadUseTxlib", localProperties);
      }
    }
    catch (Throwable localException1)
    {
      try
      {
        y.a().a(MsfCore.sCore, true);
        QLog.d("MSF.C.MsfCore", 1, "init wifiScan cost=" + (SystemClock.elapsedRealtime() - l));
        l = SystemClock.elapsedRealtime();
      }
      catch (Exception localException1)
      {
        try
        {
          label703:
          do
          {
            for (;;)
            {
              y.a(y.O);
              QLog.d("MSF.C.MsfCore", 1, "MsfCore init health step cost=" + (SystemClock.elapsedRealtime() - l));
              QLog.i("MSF.C.MsfCore", 1, "init quic_enable=" + a.e("quic_enable") + " version=" + QuicWrapper.getQuicResVersion() + " libpath=" + QuicWrapper.getQuicResLoadPath());
              return;
              localThrowable = localThrowable;
              QLog.d("MSF.C.MsfCore", 1, "", localThrowable);
              continue;
              String str = t.d();
              continue;
              str = t.d();
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
 * Qualified Name:     com.tencent.mobileqq.msf.core.s
 * JD-Core Version:    0.7.0.1
 */