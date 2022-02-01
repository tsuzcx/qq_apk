package com.tencent.mobileqq.msf.core.net.b;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.MsfStore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class k
  extends o
{
  public static final int a = 0;
  public static final int b = -1;
  public static final int c = -2;
  public static final int d = -3;
  public static final int e = -4;
  private static final String g = "WifiDetector";
  private static final String h = "_wifi_detect_history";
  private static final long i = 7200000L;
  private static final long j = 10000L;
  private static final long k = 30000L;
  private static final long l = 86400000L;
  private static final long m = 5L;
  private static final int u = 1000;
  private MsfCore n;
  private AtomicBoolean o = new AtomicBoolean(false);
  private volatile int p = 0;
  private int q = -1;
  private String r;
  private String s;
  private ConcurrentHashMap t = new ConcurrentHashMap();
  private Handler v = new l(this);
  private a.a w = new m(this);
  
  public k(MsfCore paramMsfCore)
  {
    this.n = paramMsfCore;
    f();
    d();
  }
  
  private int a(int paramInt)
  {
    if (paramInt != -3)
    {
      if ((paramInt != -2) && (paramInt != -1))
      {
        if (paramInt != 0) {
          return -1;
        }
        return 0;
      }
      return -1;
    }
    return -2;
  }
  
  private void a(int paramInt, String paramString)
  {
    if ((this.q != -2) || (paramInt == 0)) {
      this.q = paramInt;
    }
    if (this.q == -2) {
      this.r = paramString;
    }
  }
  
  private void a(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    n localn = new n(paramString, paramLong, paramBoolean, paramInt);
    Iterator localIterator = this.t.entrySet().iterator();
    for (;;)
    {
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        paramInt = 0;
        if (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (n)((Map.Entry)localObject).getValue();
          if ((!((n)localObject).a.equals(paramString)) && (System.currentTimeMillis() - ((n)localObject).b > 86400000L))
          {
            localIterator.remove();
            continue;
          }
          localObject = ((n)localObject).a();
          if (localObject != null) {
            if (localStringBuffer.length() <= 0)
            {
              localStringBuffer.append((String)localObject);
            }
            else
            {
              localStringBuffer.append("#&#");
              localStringBuffer.append((String)localObject);
            }
          }
        }
        else
        {
          this.t.put(paramString, localn);
          MsfStore.getNativeConfigStore().setConfig("_wifi_detect_history", localStringBuffer.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return;
      }
      int i1 = paramInt + 1;
      paramInt = i1;
      if (i1 <= 5L) {}
    }
  }
  
  private void b(String paramString, int paramInt)
  {
    try
    {
      a(paramString, System.currentTimeMillis(), false, paramInt);
      c(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    this.v.removeMessages(1000);
    Message localMessage = this.v.obtainMessage();
    localMessage.obj = paramString;
    this.v.sendMessageDelayed(localMessage, paramLong);
  }
  
  private void c(String paramString)
  {
    try
    {
      if (!NetConnInfoCenter.isWifiConn())
      {
        QLog.d("WifiDetector", 1, "WIFI detect start failed, wifi is not connected!");
        return;
      }
      if (!d(paramString))
      {
        QLog.d("WifiDetector", 1, "WIFI detect start failed, ssid is invalid!");
        return;
      }
      Object localObject = this.o;
      int i1 = 0;
      if (!((AtomicBoolean)localObject).compareAndSet(false, true))
      {
        QLog.d("WifiDetector", 1, "WIFI detect start failed, there is detect running!");
        b(paramString, 30000L);
        return;
      }
      QLog.d("WifiDetector", 1, "WIFI detect started!");
      this.s = paramString;
      a(this.s, System.currentTimeMillis());
      b(paramString, 7200000L);
      while (i1 < this.f.length)
      {
        this.p |= 1 << i1;
        localObject = a(this.f[i1], i1, this.w);
        ((a)localObject).g = paramString;
        if (localObject != null)
        {
          localObject = new Thread((Runnable)localObject);
          ((Thread)localObject).setName("WifiDetectEchoThread");
          ((Thread)localObject).start();
        }
        i1 += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void d()
  {
    if ((NetConnInfoCenter.isWifiConn()) && (d(NetConnInfoCenter.getLastWifiSSID()))) {
      a(NetConnInfoCenter.getLastWifiSSID(), 0);
    }
  }
  
  private boolean d(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.equals(NetConnInfoCenter.getLastWifiSSID()));
  }
  
  private void e()
  {
    this.o.set(false);
    this.p = 0;
    this.q = -1;
    this.r = null;
    this.s = "";
  }
  
  private void f()
  {
    Object localObject = MsfStore.getNativeConfigStore().getConfig("_wifi_detect_history");
    try
    {
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = ((String)localObject).split("#&#");
      int i1 = 0;
      while (i1 < localObject.length)
      {
        n localn = n.a(localObject[i1]);
        if (localn != null) {
          this.t.put(localn.a, localn);
        }
        i1 += 1;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiDisconnected!");
    this.v.removeMessages(1000);
  }
  
  public void a(String paramString)
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnSucc!");
    a(paramString, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("WIFI detect onWifiConnected! with ");
    ((StringBuilder)localObject).append(paramInt);
    QLog.d("WifiDetector", 1, ((StringBuilder)localObject).toString());
    localObject = this.n.configManager;
    if (!com.tencent.mobileqq.msf.core.a.a.y())
    {
      paramInt = 0;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("WIFI detect onWifiConnected into:  ");
      ((StringBuilder)localObject).append(0);
      QLog.d("WifiDetector", 1, ((StringBuilder)localObject).toString());
    }
    localObject = (n)this.t.get(paramString);
    long l2 = System.currentTimeMillis();
    if (localObject == null)
    {
      b(paramString, paramInt);
      return;
    }
    if (!((n)localObject).c)
    {
      ((n)localObject).d = paramInt;
      c(paramString);
      return;
    }
    ((n)localObject).d = paramInt;
    long l1;
    if (1 == paramInt) {
      l1 = 10000L;
    } else {
      l1 = 7200000L;
    }
    if (l2 - ((n)localObject).b >= l1)
    {
      c(paramString);
      return;
    }
    b(paramString, l1 - (l2 - ((n)localObject).b));
  }
  
  public void a(String paramString, long paramLong)
  {
    n localn = (n)this.t.get(paramString);
    if (localn != null) {
      a(paramString, paramLong, localn.c, localn.d);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    n localn = (n)this.t.get(paramString);
    if (localn != null) {
      a(paramString, localn.b, paramBoolean, localn.d);
    }
  }
  
  public void b()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiAllConnFailed!");
    b(NetConnInfoCenter.getLastWifiSSID(), 0);
  }
  
  public void b(String paramString)
  {
    int i1 = this.q;
    String str = this.r;
    if (NetConnInfoCenter.isWifiConn())
    {
      if (i1 == 0)
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_OK");
        if (paramString != null)
        {
          paramString = (n)this.t.get(paramString);
          if ((paramString != null) && (paramString.d == 1)) {
            this.n.sender.b.l().a(com.tencent.qphone.base.a.b);
          }
        }
      }
      else if (i1 == -1)
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_EXCEPTION");
      }
      else if ((i1 == -2) && (!this.n.sender.b.c()) && (d(this.s)))
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NEED_AUTH");
        paramString = new FromServiceMsg(NetConnInfoCenter.msfCore.getMsfAppid(), MsfCore.getNextSeq(), "0", "cmd_netNeedSignon");
        paramString.setMsgSuccess();
        paramString.setMsfCommand(MsfCommand.onNetNeedSignon);
        paramString.addAttribute("signonurl", str);
        MsfSdkUtils.addFromMsgProcessName("*", paramString);
        NetConnInfoCenter.msfCore.addRespToQuque(null, paramString);
      }
      else
      {
        QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_OTHER");
      }
    }
    else {
      QLog.d("WifiDetector", 1, "WIFI detect result, WIFI_NONE");
    }
    e();
  }
  
  public void c()
  {
    QLog.d("WifiDetector", 1, "WIFI detect onWifiConnFake!");
    b(NetConnInfoCenter.getLastWifiSSID(), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.k
 * JD-Core Version:    0.7.0.1
 */