package com.tencent.mobileqq.msf.core;

import android.os.Build;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.auth.b;
import com.tencent.mobileqq.msf.core.c.d;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.quic.QuicWrapper;
import com.tencent.mobileqq.msf.sdk.utils.MonitorSocketStat;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Properties;

class s
  extends Thread
{
  s(MsfCore paramMsfCore, j paramj, boolean paramBoolean, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    long l = SystemClock.elapsedRealtime();
    NetConnInfoCenter.checkConnInfo(BaseApplication.getContext(), true);
    this.e.netFlowStore = new d(MsfCore.sCore, BaseApplication.getContext());
    try
    {
      BaseApplication.monitor.start();
      QLog.d("MSF.C.MsfCore", 1, "init netflow monitor cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      this.a.f();
      if (this.a.c()) {
        this.e.statReporter = this.a;
      }
      QLog.d("MSF.C.MsfCore", 1, "init beacon Cost=" + (SystemClock.elapsedRealtime() - l));
      l = SystemClock.elapsedRealtime();
      Object localObject;
      if (com.tencent.mobileqq.msf.core.c.a.a(BaseApplication.getContext(), false))
      {
        localObject = com.tencent.mobileqq.msf.core.c.a.a(BaseApplication.getContext());
        this.e.mtaReporter = ((com.tencent.mobileqq.msf.core.c.a)localObject);
      }
      QLog.d("MSF.C.MsfCore", 1, "init mtaSupport=" + com.tencent.mobileqq.msf.core.c.a.a(BaseApplication.getContext()).isMtaSupported() + " mtaCost=" + (SystemClock.elapsedRealtime() - l));
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
          com.tencent.mobileqq.msf.core.c.a.a(BaseApplication.getContext()).reportKVEvent("msf.core.EvtTxlibSoExist", localProperties);
        }
      }
      else if (this.e.bLoadUseTxlib)
      {
        localProperties = new Properties();
        localProperties.setProperty("bLoadUseTxlib", String.valueOf(this.e.bLoadUseTxlib));
        localProperties.setProperty("newVersion", String.valueOf(this.c));
        localProperties.setProperty("oldVersion", String.valueOf(this.d));
        if (t.d() != null) {
          break label620;
        }
        localObject = "null";
        localProperties.setProperty("imei", (String)localObject);
        localProperties.setProperty("product", Build.MANUFACTURER + "_" + Build.MODEL);
        localProperties.setProperty("uin", String.valueOf(MsfCore.sCore.getAccountCenter().i()));
        localProperties.setProperty("platform", c.c(BaseApplication.getContext()));
        com.tencent.mobileqq.msf.core.c.a.a(BaseApplication.getContext()).reportKVEvent("msf.core.EvtLoadUseTxlib", localProperties);
      }
    }
    catch (Throwable localException1)
    {
      try
      {
        x.a().a(MsfCore.sCore, true);
        QLog.d("MSF.C.MsfCore", 1, "init wifiScan cost=" + (SystemClock.elapsedRealtime() - l));
        l = SystemClock.elapsedRealtime();
      }
      catch (Exception localException1)
      {
        try
        {
          label620:
          do
          {
            for (;;)
            {
              x.a(x.O);
              QLog.d("MSF.C.MsfCore", 1, "MsfCore init health step cost=" + (SystemClock.elapsedRealtime() - l));
              QLog.i("MSF.C.MsfCore", 1, "init quic_enable=" + com.tencent.mobileqq.msf.core.a.a.e("quic_enable") + " version=" + QuicWrapper.getQuicResVersion() + " libpath=" + QuicWrapper.getQuicResLoadPath());
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