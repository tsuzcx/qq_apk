package com.tencent.mobileqq.msf.core.net.a;

import android.os.Handler;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.core.ad;
import com.tencent.mobileqq.msf.core.d.j;
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
  private static a.a k;
  private static Handler l;
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
        str = a;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("pause heartbeat proxy ");
        localStringBuilder.append(paramString);
        QLog.d(str, 1, localStringBuilder.toString());
        g.pushManager.b(300000L);
        return true;
      }
    }
    catch (Exception paramString)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to pause heartbeat ");
      localStringBuilder.append(paramString.toString());
      QLog.d(str, 1, localStringBuilder.toString());
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
        if (!l.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM()))
        {
          QLog.d(a, 1, "failed to add msg testHeartbeat");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to process onConnect event ");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
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
      if ((h == 2) || (h == 1))
      {
        l.sendEmptyMessage(21);
        return;
      }
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
      int i1 = h;
      Object localObject1;
      if (i1 == 2)
      {
        localObject1 = g.sender.I.b().a(513);
        if (localObject1 != null)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("report", localObject1);
          if (MsfService.core.getStatReporter() != null) {
            MsfService.core.getStatReporter().a("dim_Msf_hwSending", true, 0L, 0L, (Map)localObject2, false, false);
          }
        }
        localObject2 = g.sender.I.b().a(516);
        if (localObject1 != null)
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("reportExTimeout", localObject2);
          if (MsfService.core.getStatReporter() != null) {
            MsfService.core.getStatReporter().a("dim_Msf_hwSendingExTimeout", true, 0L, 0L, (Map)localObject1, false, false);
          }
        }
        localObject1 = g.sender.I.b().a(514);
        if (localObject1 != null)
        {
          localObject2 = new HashMap();
          ((HashMap)localObject2).put("except", localObject1);
          if (g.getStatReporter() != null) {
            g.getStatReporter().a("dim_Msf_hwExcept", true, 0L, 0L, (Map)localObject2, false, false);
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
            MsfService.core.getStatReporter().a("dim_Msf_NmSending", false, 0L, 0L, (Map)localObject2, false, false);
          }
        }
        localObject2 = g.sender.I.b().a(516);
        if (localObject1 != null)
        {
          localObject1 = new HashMap();
          ((HashMap)localObject1).put("reportExTimeout", localObject2);
          if (MsfService.core.getStatReporter() != null)
          {
            MsfService.core.getStatReporter().a("dim_Msf_NmSendingExTimeout", false, 0L, 0L, (Map)localObject1, false, false);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2 = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to report sending ");
      localStringBuilder.append(localException.toString());
      QLog.d((String)localObject2, 1, localStringBuilder.toString());
    }
  }
  
  public static void i()
  {
    try
    {
      int i1 = h;
      String str;
      if (i1 == 2)
      {
        str = g.sender.I.b().a(515);
        if (str != null)
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("heartbeat", str);
          if (g.getStatReporter() != null) {
            g.getStatReporter().a("dim_Msf_hwHeartbeat", true, 0L, 0L, (Map)localObject, false, false);
          }
        }
      }
      else if (h == 1)
      {
        str = g.sender.I.b().a(515);
        if (str != null)
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("heartbeat", str);
          if (g.getStatReporter() != null)
          {
            g.getStatReporter().a("dim_Msf_NmHeartbeat", false, 0L, 0L, (Map)localObject, false, false);
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to report heartbeat ");
      localStringBuilder.append(localException.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public static void j()
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reset current mode: ");
    localStringBuilder.append(h);
    QLog.d(str, 1, localStringBuilder.toString());
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
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("resume current mode: ");
    localStringBuilder.append(h);
    QLog.d(str, 1, localStringBuilder.toString());
    try
    {
      g.sender.I.e();
    }
    catch (Exception localException)
    {
      QLog.d(a, 1, "failed to resume mode", localException);
    }
    h = f.b;
  }
  
  public static boolean l()
  {
    try
    {
      if (h == 2)
      {
        m.set(false);
        String str = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("maincount: ");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(", fore: ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", mobile: ");
        ((StringBuilder)localObject).append(NetConnInfoCenter.isMobileConn());
        ((StringBuilder)localObject).append(", screenoff: ");
        ((StringBuilder)localObject).append(n);
        QLog.d(str, 1, ((StringBuilder)localObject).toString());
        if (((j <= 0) && (!i)) || ((n) && (NetConnInfoCenter.isMobileConn())))
        {
          if (g.sender.I.b().a(156).equals("false"))
          {
            QLog.d(a, 1, "native switch closed");
            return false;
          }
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
            return true;
          }
          QLog.d(a, 1, "failed to set heartbeat proxy");
          return true;
        }
        QLog.d(a, 1, "condition check failed");
        return false;
      }
    }
    catch (Exception localException)
    {
      Object localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to set heartbeat proxy ");
      localStringBuilder.append(localException.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
    return true;
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
        return true;
      }
    }
    catch (Exception localException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to resume heartbeat ");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
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
        return true;
      }
    }
    catch (Exception localException)
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to stop heartbeat ");
      localStringBuilder.append(localException.toString());
      QLog.d(str, 1, localStringBuilder.toString());
    }
    return true;
  }
  
  public void a()
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("main process enter background inMode:");
    ((StringBuilder)localObject).append(h);
    ((StringBuilder)localObject).append(", mobile:");
    ((StringBuilder)localObject).append(NetConnInfoCenter.isMobileConn());
    ((StringBuilder)localObject).append(" ,inproxy:");
    ((StringBuilder)localObject).append(b.e);
    ((StringBuilder)localObject).append(", enterprocess:");
    ((StringBuilder)localObject).append(m);
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      if ((h == 2) && (NetConnInfoCenter.isMobileConn()))
      {
        i = false;
        j += 1;
        if ((!b.e) && (m.compareAndSet(false, true)))
        {
          j = 0;
          if (!l.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM()))
          {
            QLog.d(a, 1, "failed to add msg testHeartbeat");
            return;
          }
        }
      }
    }
    catch (Exception localException)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to process background event ");
      localStringBuilder.append(localException.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void b()
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("main process enter foreground inproxy:");
    ((StringBuilder)localObject).append(b.e);
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      if (h == 2)
      {
        if (true == b.e) {
          a("foreground");
        }
        i = true;
        j += 1;
        if (!o)
        {
          l.sendEmptyMessageDelayed(20, 3600000L);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to process foreground event ");
      localStringBuilder.append(localException.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void c()
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive screen off msg inMode:");
    ((StringBuilder)localObject).append(h);
    ((StringBuilder)localObject).append(", mobile:");
    ((StringBuilder)localObject).append(NetConnInfoCenter.isMobileConn());
    ((StringBuilder)localObject).append(" ,inproxy:");
    ((StringBuilder)localObject).append(b.e);
    ((StringBuilder)localObject).append(", enterprocess:");
    ((StringBuilder)localObject).append(m);
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      if ((h == 2) && (NetConnInfoCenter.isMobileConn()) && (!b.e) && (m.compareAndSet(false, true)))
      {
        n = true;
        if (!l.sendEmptyMessageDelayed(18, com.tencent.mobileqq.msf.core.a.a.aM()))
        {
          QLog.d(a, 1, "failed to add msg testHeartbeat");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to process screenoff event ");
      localStringBuilder.append(localException.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
  
  public void d()
  {
    String str = a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("receive screen on msg inproxy:");
    ((StringBuilder)localObject).append(b.e);
    QLog.d(str, 1, ((StringBuilder)localObject).toString());
    try
    {
      if (h == 2)
      {
        n = false;
        if ((true == b.e) && (i))
        {
          a("screenon");
          return;
        }
      }
    }
    catch (Exception localException)
    {
      localObject = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to process screenoff event ");
      localStringBuilder.append(localException.toString());
      QLog.d((String)localObject, 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.a
 * JD-Core Version:    0.7.0.1
 */