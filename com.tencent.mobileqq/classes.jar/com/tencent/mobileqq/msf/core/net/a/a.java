package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ac;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.core.push.g;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class a
{
  public static String a = "AdaptorController";
  public static final String b = "foreground";
  public static final String c = "screenon";
  public static final String d = "kicked";
  public static final String e = "disconnect";
  public static final String f = "exception";
  static MsfCore g;
  private static int h = -2;
  private static boolean i = true;
  private static int j = -1;
  private static a.a k = null;
  private static Handler l = null;
  private static volatile AtomicBoolean m = new AtomicBoolean(false);
  private static boolean n = false;
  private static boolean o = false;
  private static int p = 0;
  private static final int q = 18;
  private static final int r = 19;
  private static final int s = 20;
  private static final int t = 21;
  
  public a(MsfCore paramMsfCore, int paramInt)
  {
    g = paramMsfCore;
    k = new a.a(this, "controllerthread");
    k.start();
    l = new Handler(k.getLooper(), k);
    i = true;
    j = 0;
    m = new AtomicBoolean(false);
    o = false;
    h = paramInt;
  }
  
  public static boolean a(String paramString)
  {
    try
    {
      if (h == 2)
      {
        if (!b.e) {
          return true;
        }
        if (!g.sender.I.b().b(153, true)) {
          QLog.d(a, 1, "failed to pause heartbeat");
        }
        b.e = false;
        QLog.d(a, 1, "pause heartbeat proxy " + paramString);
        g.pushManager.b(300000L);
        return true;
      }
    }
    catch (Exception paramString)
    {
      QLog.d(a, 1, "failed to pause heartbeat " + paramString.toString());
    }
    return true;
  }
  
  public static void e()
  {
    try
    {
      QLog.d(a, 1, "connection established");
      if ((h == 2) && (NetConnInfoCenter.isMobileConn()) && ((!i) || (n)) && (!b.e) && (m.compareAndSet(false, true)))
      {
        p = 0;
        j = 0;
        if (!l.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM())) {
          QLog.d(a, 1, "failed to add msg testHeartbeat");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to process onConnect event " + localException.toString());
    }
  }
  
  public static void f()
  {
    l.removeMessages(19);
    l.removeMessages(18);
    m.set(false);
    j = 0;
    p = 0;
  }
  
  public static void g()
  {
    try
    {
      if ((h == 2) || (h == 1)) {
        l.sendEmptyMessage(21);
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to report at once ", localException);
    }
  }
  
  public static void h()
  {
    try
    {
      Object localObject1;
      Object localObject2;
      if (h == 2)
      {
        localObject1 = g.sender.I.b().a(513);
        if (localObject1 != null)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("report", localObject1);
          if (MsfService.core.getStatReporter() != null) {
            MsfService.core.getStatReporter().a("dim.Msf.hwSending", true, 0L, 0L, (Map)localObject2, false, false);
          }
        }
        localObject2 = g.sender.I.b().a(516);
        if (localObject1 != null)
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("reportExTimeout", localObject2);
          if (MsfService.core.getStatReporter() != null) {
            MsfService.core.getStatReporter().a("dim.Msf.hwSendingExTimeout", true, 0L, 0L, (Map)localObject1, false, false);
          }
        }
        localObject1 = g.sender.I.b().a(514);
        if (localObject1 != null)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("except", localObject1);
          if (g.getStatReporter() != null) {
            g.getStatReporter().a("dim.Msf.hwExcept", true, 0L, 0L, (Map)localObject2, false, false);
          }
        }
      }
      else if (h == 1)
      {
        localObject1 = g.sender.I.b().a(513);
        if (localObject1 != null)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("report", localObject1);
          if (MsfService.core.getStatReporter() != null) {
            MsfService.core.getStatReporter().a("dim.Msf.NmSending", false, 0L, 0L, (Map)localObject2, false, false);
          }
        }
        localObject2 = g.sender.I.b().a(516);
        if (localObject1 != null)
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("reportExTimeout", localObject2);
          if (MsfService.core.getStatReporter() != null)
          {
            MsfService.core.getStatReporter().a("dim.Msf.NmSendingExTimeout", false, 0L, 0L, (Map)localObject1, false, false);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to report sending " + localException.toString());
    }
  }
  
  public static void i()
  {
    try
    {
      String str;
      HashMap localHashMap;
      if (h == 2)
      {
        str = g.sender.I.b().a(515);
        if (str != null)
        {
          localHashMap = new HashMap();
          localHashMap.put("heartbeat", str);
          if (g.getStatReporter() != null) {
            g.getStatReporter().a("dim.Msf.hwHeartbeat", true, 0L, 0L, localHashMap, false, false);
          }
        }
      }
      else if (h == 1)
      {
        str = g.sender.I.b().a(515);
        if (str != null)
        {
          localHashMap = new HashMap();
          localHashMap.put("heartbeat", str);
          if (g.getStatReporter() != null)
          {
            g.getStatReporter().a("dim.Msf.NmHeartbeat", false, 0L, 0L, localHashMap, false, false);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to report heartbeat " + localException.toString());
    }
  }
  
  public static void j()
  {
    QLog.d(a, 1, "reset current mode: " + h);
    try
    {
      a("exception");
      g.sender.I.d();
      h = f.b;
      m.set(false);
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to reset mode", localException);
    }
  }
  
  public static void k()
  {
    QLog.d(a, 1, "resume current mode: " + h);
    try
    {
      g.sender.I.e();
      h = f.b;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d(a, 1, "failed to resume mode", localException);
      }
    }
  }
  
  public static boolean l()
  {
    try
    {
      if (h == 2)
      {
        m.set(false);
        QLog.d(a, 1, "maincount: " + j + ", fore: " + i + ", mobile: " + NetConnInfoCenter.isMobileConn() + ", screenoff: " + n);
        if (((j <= 0) && (!i)) || ((!n) || (!NetConnInfoCenter.isMobileConn())))
        {
          QLog.d(a, 1, "condition check failed");
          return false;
        }
        if (!g.sender.I.b().a(156).equals("false")) {
          break label189;
        }
        QLog.d(a, 1, "native switch closed");
        return false;
      }
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to set heartbeat proxy " + localException.toString());
    }
    for (;;)
    {
      return true;
      label189:
      if (b.e)
      {
        QLog.d(a, 1, "already in proxy heartbeat, return");
        return true;
      }
      if (g.sender.I.b().b(151, true))
      {
        QLog.d(a, 1, "set heartbeat proxy");
        if (!m())
        {
          QLog.d(a, 1, "resume heartbeat failed");
          return false;
        }
        b.e = true;
        g.pushManager.b(1500000L);
      }
      else
      {
        QLog.d(a, 1, "failed to set heartbeat proxy");
      }
    }
  }
  
  public static boolean m()
  {
    try
    {
      if (h == 2)
      {
        QLog.d(a, 1, "resume heartbeat");
        b.e = true;
        g.sender.I.b().b(152, true);
      }
      return true;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to resume heartbeat " + localException.toString());
    }
    return true;
  }
  
  public static boolean n()
  {
    try
    {
      if (h == 2)
      {
        QLog.d(a, 1, "stop heartbeat");
        b.e = true;
        g.sender.I.b().b(153, true);
      }
      return true;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to stop heartbeat " + localException.toString());
    }
    return true;
  }
  
  public void a()
  {
    QLog.d(a, 1, "main process enter background inMode:" + h + ", mobile:" + NetConnInfoCenter.isMobileConn() + " ,inproxy:" + b.e + ", enterprocess:" + m);
    try
    {
      if ((h == 2) && (NetConnInfoCenter.isMobileConn()))
      {
        i = false;
        j += 1;
        if ((!b.e) && (m.compareAndSet(false, true)))
        {
          j = 0;
          if (!l.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM())) {
            QLog.d(a, 1, "failed to add msg testHeartbeat");
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to process background event " + localException.toString());
    }
  }
  
  public void b()
  {
    QLog.d(a, 1, "main process enter foreground inproxy:" + b.e);
    try
    {
      if (h == 2)
      {
        if (true == b.e) {
          a("foreground");
        }
        i = true;
        j += 1;
        if (!o) {
          l.sendEmptyMessageDelayed(20, 3600000L);
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to process foreground event " + localException.toString());
    }
  }
  
  public void c()
  {
    QLog.d(a, 1, "receive screen off msg inMode:" + h + ", mobile:" + NetConnInfoCenter.isMobileConn() + " ,inproxy:" + b.e + ", enterprocess:" + m);
    try
    {
      if ((h == 2) && (NetConnInfoCenter.isMobileConn()) && (!b.e) && (m.compareAndSet(false, true)))
      {
        n = true;
        if (!l.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM())) {
          QLog.d(a, 1, "failed to add msg testHeartbeat");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to process screenoff event " + localException.toString());
    }
  }
  
  public void d()
  {
    QLog.d(a, 1, "receive screen on msg inproxy:" + b.e);
    try
    {
      if (h == 2)
      {
        n = false;
        if ((true == b.e) && (i)) {
          a("screenon");
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to process screenoff event " + localException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.a
 * JD-Core Version:    0.7.0.1
 */