package com.tencent.mobileqq.msf.sdk.report;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class e$d
  extends e.a
{
  public static final String b = "msf.sdk.MsfReceiverHeld";
  private static final String c = "EventMsfReceiverHeld";
  private boolean d = false;
  private boolean e = false;
  private int f = 0;
  private long g = 0L;
  private int h = 0;
  
  public static d b()
  {
    return e.d.a.a();
  }
  
  public void a(String paramString1, String paramString2, int paramInt)
  {
    if (this.f == 0) {
      if (paramInt >= 10)
      {
        this.g = SystemClock.uptimeMillis();
        this.f = paramInt;
      }
    }
    do
    {
      do
      {
        return;
        if ((this.f <= 0) || (paramInt <= this.f)) {
          break;
        }
        this.f = paramInt;
        this.h += 1;
      } while ((this.g <= 0L) || (this.h < 5) || (Math.abs(SystemClock.uptimeMillis() - this.g) <= 300000L) || (this.e));
      this.e = true;
      String str = MsfSdkUtils.getThreadStackString("MSF-Receiver");
      a();
      a("queuesize", String.valueOf(paramInt));
      a("time", "5");
      a("uin", paramString2);
      a("cmd", paramString1);
      if (MsfServiceSdk.get().getProxy() != null) {}
      for (paramString1 = Boolean.valueOf(MsfServiceSdk.get().getProxy().serviceConnected());; paramString1 = "false")
      {
        a("binder", String.valueOf(paramString1));
        a("stack", str);
        QLog.w("EventMsfReceiverHeld", 1, "MSF-Receiver held 5min " + BaseApplication.gMsfReceiverStarted);
        a.a(new b("MSF-Receiver Held " + BaseApplication.gMsfReceiverStarted), "MSFReceiverHeldCatchedException", "MSF-Receiver线程卡住5分钟");
        a("msf.sdk.MsfReceiverHeld", (int)(SystemClock.elapsedRealtime() - this.g));
        return;
      }
    } while (paramInt > this.f);
    this.f = 0;
    this.g = 0L;
    this.h = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.report.e.d
 * JD-Core Version:    0.7.0.1
 */