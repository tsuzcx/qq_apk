package com.tencent.mobileqq.msf.core.net.a;

import android.content.Context;
import android.os.Handler;
import com.huawei.android.bastet.HwBastet;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class c
  implements e
{
  public static final String a = "HwSocketAdaptor";
  public static Context b;
  public static Handler c;
  private static boolean d = false;
  private static HwBastet e = null;
  private static ConcurrentHashMap f = new ConcurrentHashMap();
  private static ConcurrentHashMap g = new ConcurrentHashMap();
  private static boolean h = false;
  private static int i = 0;
  private static int j = 0;
  private static int k = 0;
  private static int l = 0;
  private static long m = 0L;
  private static long n = 0L;
  private static ConcurrentLinkedQueue o = new ConcurrentLinkedQueue();
  private static final long p = 600000L;
  private static final long q = 240000L;
  private static int r = 0;
  private static boolean s = true;
  private static boolean t = false;
  private static c.a u = null;
  private static final int v = 153;
  private static final int w = 154;
  private static boolean x = false;
  private static int y = 0;
  
  public c(Context paramContext)
  {
    QLog.d("HwSocketAdaptor", 1, "init HwSocketAdaptor");
    b = paramContext;
    f();
    u = new c.a("netHandlerThread");
    u.start();
    c = new Handler(u.getLooper(), u);
    d = false;
    c.sendEmptyMessageDelayed(154, com.tencent.mobileqq.msf.core.a.a.aP());
    y = 0;
  }
  
  private static void f()
  {
    r = 0;
    i = 0;
    h = false;
    j = 0;
    m = 0L;
    s = true;
    x = false;
    t = false;
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 513: 
    case 516: 
    case 514: 
    case 515: 
      for (;;)
      {
        return null;
        try
        {
          localStringBuilder = new StringBuilder();
          localIterator = f.entrySet().iterator();
          l1 = 0L;
          i2 = 0;
          i1 = 0;
          while (localIterator.hasNext())
          {
            localEntry = (Map.Entry)localIterator.next();
            if ((((Long)localEntry.getValue()).longValue() <= 60000L) && (((Long)localEntry.getValue()).longValue() >= 0L))
            {
              localStringBuilder.append("seq_").append(localEntry.getKey()).append("+").append("consume_").append(localEntry.getValue()).append("|");
              l1 += ((Long)localEntry.getValue()).longValue();
              i2 += 1;
              i1 += 1;
            }
          }
          if (i2 > 0) {
            localStringBuilder.append("count_").append(i2).append("+").append("sumcount_").append(l1).append("+average_").append(l1 / i2);
          }
          f.clear();
          QLog.d("HwSocketAdaptor", 1, "report consume: " + localStringBuilder.toString());
          return localStringBuilder.toString();
        }
        catch (Throwable localThrowable)
        {
          StringBuilder localStringBuilder;
          Iterator localIterator;
          long l1;
          int i2;
          int i1;
          Map.Entry localEntry;
          QLog.d("HwSocketAdaptor", 1, "get config " + paramInt + " failed " + localThrowable.toString(), localThrowable);
        }
        if (g == null)
        {
          QLog.d("HwSocketAdaptor", 1, "exclude timeout packet is null");
          return null;
        }
        localStringBuilder = new StringBuilder();
        localIterator = g.entrySet().iterator();
        l1 = 0L;
        i2 = 0;
        i1 = 0;
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          if ((((Long)localEntry.getValue()).longValue() <= 45000L) && (((Long)localEntry.getValue()).longValue() >= 0L))
          {
            localStringBuilder.append("seq_").append(localEntry.getKey()).append("+").append("consume_").append(localEntry.getValue()).append("|");
            l1 += ((Long)localEntry.getValue()).longValue();
            i2 += 1;
            i1 += 1;
          }
        }
        if (i2 > 0) {
          localStringBuilder.append("count_").append(i2).append("+").append("sumcount_").append(l1).append("+average_").append(l1 / i2);
        }
        g.clear();
        QLog.d("HwSocketAdaptor", 1, "report consume exclude timeout: " + localStringBuilder.toString());
        return localStringBuilder.toString();
        if ((k == 0) && (l == 0)) {
          return null;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("send_except:").append(k).append("+");
        localStringBuilder.append("hb_except:").append(l);
        if (QLog.isColorLevel()) {
          QLog.d("HwSocketAdaptor", 2, "report hrt except: " + k + ", hb except" + l);
        }
        return localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localIterator = o.iterator();
        while (localIterator.hasNext()) {
          localStringBuilder.append((String)localIterator.next()).append("#");
        }
      }
      o.clear();
      QLog.d("HwSocketAdaptor", 2, "report heartbeat: " + localThrowable.toString());
      return localThrowable.toString();
    }
    boolean bool = s;
    return String.valueOf(bool);
  }
  
  public void a()
  {
    d = false;
    try
    {
      a.f();
      StringBuilder localStringBuilder;
      long l1;
      if (b.e)
      {
        QLog.d("HwSocketAdaptor", 1, "connection closed, proxy pause");
        b.e = false;
        b(153, true);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("begin_").append(m).append(":");
        localStringBuilder.append("end_").append(n).append(":");
        localStringBuilder.append("last_").append(n - m).append(":");
        localStringBuilder.append("quality_").append(e.inquireNetworkQuality()).append(":");
        localStringBuilder.append("net_").append(NetConnInfoCenter.isWifiOrMobileConn()).append(":");
        l1 = n - m;
        QLog.d("HwSocketAdaptor", 1, "connection last:" + l1);
        if ((600000L <= l1) || (240000L >= l1) || (!NetConnInfoCenter.isWifiOrMobileConn())) {
          break label283;
        }
        QLog.d("HwSocketAdaptor", 1, "heartbeatUnexpectCount:" + r);
        r += 1;
        if (r >= com.tencent.mobileqq.msf.core.a.a.aN())
        {
          QLog.d("HwSocketAdaptor", 1, "close heartbeat proxy switch");
          b(156, false);
          r = 0;
        }
      }
      for (;;)
      {
        c.removeMessages(153);
        return;
        label283:
        if (l1 > 600000L) {
          o.add(localStringBuilder.toString());
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.d("HwSocketAdaptor", 1, "failed to disconnect " + localThrowable.toString(), localThrowable);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    if ((f.containsKey(Integer.valueOf(paramInt))) && (NetConnInfoCenter.isMobileConn()))
    {
      l2 = ((Long)f.get(Integer.valueOf(paramInt))).longValue();
      f.put(Integer.valueOf(paramInt), Long.valueOf(l1 - l2));
      if (f.size() > 300) {
        a.g();
      }
    }
    if ((!paramBoolean) && (g.contains(Integer.valueOf(paramInt))) && (NetConnInfoCenter.isMobileConn()))
    {
      l2 = ((Long)g.get(Integer.valueOf(paramInt))).longValue();
      g.put(Integer.valueOf(paramInt), Long.valueOf(l1 - l2));
    }
    if (paramBoolean) {
      if ((e.inquireNetworkQuality() != 0) && (NetConnInfoCenter.isWifiOrMobileConn())) {}
    }
    while (!h)
    {
      do
      {
        return;
        if (!h)
        {
          h = true;
          i = 0;
        }
        i += 1;
      } while (i <= com.tencent.mobileqq.msf.core.a.a.aK());
      t = true;
      a.j();
      i = 0;
      return;
    }
    h = false;
    i = 0;
  }
  
  public void a(Socket paramSocket)
  {
    try
    {
      if (!d)
      {
        e = new HwBastet("", paramSocket, c, b);
        d = true;
      }
      if (e.inquireNetworkQuality() == 1) {
        QLog.d("HwSocketAdaptor", 1, "bastet detect network quality low");
      }
      for (;;)
      {
        a.e();
        return;
        if (e.inquireNetworkQuality() == 0) {
          QLog.d("HwSocketAdaptor", 1, "bastet detect network quality none");
        }
      }
      return;
    }
    catch (Throwable paramSocket)
    {
      paramSocket.printStackTrace();
      QLog.d("HwSocketAdaptor", 1, "failed to construct HwBastet instance " + paramSocket.toString());
      j += 1;
      d = false;
      if (j > com.tencent.mobileqq.msf.core.a.a.aL())
      {
        a.j();
        j = 0;
        k += 1;
      }
    }
  }
  
  public void a(byte[] paramArrayOfByte, Socket paramSocket, int paramInt)
  {
    try
    {
      if (!d)
      {
        e = new HwBastet("", paramSocket, c, b);
        d = true;
      }
      e.sendHrtData(paramArrayOfByte, paramSocket);
      f.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
      g.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
      return;
    }
    catch (Throwable paramArrayOfByte)
    {
      do
      {
        paramArrayOfByte.printStackTrace();
        QLog.d("HwSocketAdaptor", 1, "failed to send in huawei channel " + paramArrayOfByte.toString());
        j += 1;
        d = false;
      } while (j <= com.tencent.mobileqq.msf.core.a.a.aL());
      a.j();
      j = 0;
      k += 1;
    }
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    case 154: 
    case 155: 
    default: 
    case 151: 
      try
      {
        QLog.d("HwSocketAdaptor", 1, "unknown config " + paramInt);
        return false;
      }
      catch (Throwable localThrowable)
      {
        QLog.d("HwSocketAdaptor", 1, "set config " + paramInt + " failed " + localThrowable.toString(), localThrowable);
        return false;
      }
      try
      {
        if (!e.isBastetAvailable())
        {
          QLog.d("HwSocketAdaptor", 1, "bastet is not available ");
          return false;
        }
      }
      catch (Exception localException1)
      {
        l += 1;
        QLog.d("HwSocketAdaptor", 1, "failed to init heartbeat content " + localException1.toString(), localException1);
        return false;
      }
      if ((b.b == null) || (b.c == null))
      {
        QLog.d("HwSocketAdaptor", 1, "request or response null");
        return false;
      }
      e.setAolHeartbeat(1, b.b, b.c);
      m = System.currentTimeMillis();
      x = false;
      c.sendEmptyMessageDelayed(153, 2700000L);
      return true;
    case 153: 
      try
      {
        c.removeMessages(153);
        e.pauseHeartbeat();
        n = System.currentTimeMillis();
        return true;
      }
      catch (Exception localException2)
      {
        l += 1;
        QLog.d("HwSocketAdaptor", 1, "failed to pause heartbeat", localException2);
        return false;
      }
    case 152: 
      try
      {
        if (!e.isBastetAvailable())
        {
          QLog.d("HwSocketAdaptor", 1, "bastet is not available for resume");
          return false;
        }
      }
      catch (Exception localException3)
      {
        l += 1;
        QLog.d("HwSocketAdaptor", 1, "failed to resume heartbeat", localException3);
        return false;
      }
      e.resumeHeartbeat();
      return true;
    }
    s = paramBoolean;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.c
 * JD-Core Version:    0.7.0.1
 */