package com.tencent.mobileqq.msf.sdk.b;

import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.mobileqq.msf.sdk.handler.IMsfProxy;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

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
    int i = this.f;
    if (i == 0)
    {
      if (paramInt >= 10)
      {
        this.g = SystemClock.uptimeMillis();
        this.f = paramInt;
      }
    }
    else if ((i > 0) && (paramInt > i))
    {
      this.f = paramInt;
      this.h += 1;
      if ((this.g > 0L) && (this.h >= 5) && (Math.abs(SystemClock.uptimeMillis() - this.g) > 300000L) && (!this.e))
      {
        this.e = true;
        String str = MsfSdkUtils.getThreadStackString("MSF-Receiver");
        a();
        a("queuesize", String.valueOf(paramInt));
        a("time", "5");
        a("uin", paramString2);
        a("cmd", paramString1);
        if (MsfServiceSdk.get().getProxy() != null) {
          paramString1 = Boolean.valueOf(MsfServiceSdk.get().getProxy().serviceConnected());
        } else {
          paramString1 = "false";
        }
        a("binder", String.valueOf(paramString1));
        a("stack", str);
        paramString1 = new StringBuilder();
        paramString1.append("MSF-Receiver held 5min ");
        paramString1.append(BaseApplication.gMsfReceiverStarted);
        QLog.w("EventMsfReceiverHeld", 1, paramString1.toString());
        paramString1 = new StringBuilder();
        paramString1.append("MSF-Receiver Held ");
        paramString1.append(BaseApplication.gMsfReceiverStarted);
        a.a(new b(paramString1.toString()), "MSFReceiverHeldCatchedException", "MSF-Receiver线程卡住5分钟");
        if ((MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null)) {
          MsfCore.sCore.statReporter.a("msf.sdk.MsfReceiverHeld", true, SystemClock.elapsedRealtime() - this.g, 0L, new HashMap(), false, false);
        }
      }
    }
    else if (paramInt <= this.f)
    {
      this.f = 0;
      this.g = 0L;
      this.h = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.sdk.b.e.d
 * JD-Core Version:    0.7.0.1
 */