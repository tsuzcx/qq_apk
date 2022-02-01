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
  private static HwBastet e;
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
    int i2;
    if (paramInt != 156)
    {
      i2 = 0;
      i1 = 0;
      switch (paramInt)
      {
      default: 
        return null;
      }
    }
    long l2;
    try
    {
      if (g == null)
      {
        QLog.d("HwSocketAdaptor", 1, "exclude timeout packet is null");
        return null;
      }
      localStringBuilder = new StringBuilder();
      localObject = g.entrySet().iterator();
      l1 = 0L;
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        l2 = l1;
        i2 = i1;
        if (((Long)localEntry.getValue()).longValue() > 45000L) {
          break label951;
        }
        if (((Long)localEntry.getValue()).longValue() < 0L)
        {
          l2 = l1;
          i2 = i1;
          break label951;
        }
        localStringBuilder.append("seq_");
        localStringBuilder.append(localEntry.getKey());
        localStringBuilder.append("+");
        localStringBuilder.append("consume_");
        localStringBuilder.append(localEntry.getValue());
        localStringBuilder.append("|");
        l2 = l1 + ((Long)localEntry.getValue()).longValue();
        i2 = i1 + 1;
        break label951;
      }
      if (i1 > 0)
      {
        localStringBuilder.append("count_");
        localStringBuilder.append(i1);
        localStringBuilder.append("+");
        localStringBuilder.append("sumcount_");
        localStringBuilder.append(l1);
        localStringBuilder.append("+average_");
        localStringBuilder.append(l1 / i1);
      }
      g.clear();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report consume exclude timeout: ");
      ((StringBuilder)localObject).append(localStringBuilder.toString());
      QLog.d("HwSocketAdaptor", 1, ((StringBuilder)localObject).toString());
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder;
      Map.Entry localEntry;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get config ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" failed ");
      ((StringBuilder)localObject).append(localThrowable.toString());
      QLog.d("HwSocketAdaptor", 1, ((StringBuilder)localObject).toString(), localThrowable);
      return null;
    }
    localStringBuilder = new StringBuilder();
    localObject = o.iterator();
    while (((Iterator)localObject).hasNext())
    {
      localStringBuilder.append((String)((Iterator)localObject).next());
      localStringBuilder.append("#");
    }
    o.clear();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("report heartbeat: ");
    ((StringBuilder)localObject).append(localStringBuilder.toString());
    QLog.d("HwSocketAdaptor", 2, ((StringBuilder)localObject).toString());
    return localStringBuilder.toString();
    if ((k == 0) && (l == 0)) {
      return null;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("send_except:");
    localStringBuilder.append(k);
    localStringBuilder.append("+");
    localStringBuilder.append("hb_except:");
    localStringBuilder.append(l);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report hrt except: ");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(", hb except");
      ((StringBuilder)localObject).append(l);
      QLog.d("HwSocketAdaptor", 2, ((StringBuilder)localObject).toString());
    }
    return localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localObject = f.entrySet().iterator();
    long l1 = 0L;
    int i1 = i2;
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject).next();
        if (((Long)localEntry.getValue()).longValue() <= 60000L) {
          if (((Long)localEntry.getValue()).longValue() >= 0L)
          {
            localStringBuilder.append("seq_");
            localStringBuilder.append(localEntry.getKey());
            localStringBuilder.append("+");
            localStringBuilder.append("consume_");
            localStringBuilder.append(localEntry.getValue());
            localStringBuilder.append("|");
            l1 += ((Long)localEntry.getValue()).longValue();
            i1 += 1;
          }
        }
      }
      else
      {
        if (i1 > 0)
        {
          localStringBuilder.append("count_");
          localStringBuilder.append(i1);
          localStringBuilder.append("+");
          localStringBuilder.append("sumcount_");
          localStringBuilder.append(l1);
          localStringBuilder.append("+average_");
          localStringBuilder.append(l1 / i1);
        }
        f.clear();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report consume: ");
        ((StringBuilder)localObject).append(localStringBuilder.toString());
        QLog.d("HwSocketAdaptor", 1, ((StringBuilder)localObject).toString());
        return localStringBuilder.toString();
        boolean bool = s;
        return String.valueOf(bool);
        label951:
        l1 = l2;
        i1 = i2;
        break;
      }
    }
  }
  
  public void a()
  {
    d = false;
    try
    {
      a.f();
      if (b.e)
      {
        QLog.d("HwSocketAdaptor", 1, "connection closed, proxy pause");
        b.e = false;
        b(153, true);
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("begin_");
        localStringBuilder1.append(m);
        localStringBuilder1.append(":");
        localStringBuilder1.append("end_");
        localStringBuilder1.append(n);
        localStringBuilder1.append(":");
        localStringBuilder1.append("last_");
        localStringBuilder1.append(n - m);
        localStringBuilder1.append(":");
        localStringBuilder1.append("quality_");
        localStringBuilder1.append(e.inquireNetworkQuality());
        localStringBuilder1.append(":");
        localStringBuilder1.append("net_");
        localStringBuilder1.append(NetConnInfoCenter.isWifiOrMobileConn());
        localStringBuilder1.append(":");
        long l1 = n - m;
        localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("connection last:");
        localStringBuilder2.append(l1);
        QLog.d("HwSocketAdaptor", 1, localStringBuilder2.toString());
        if ((600000L > l1) && (240000L < l1) && (NetConnInfoCenter.isWifiOrMobileConn()))
        {
          localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("heartbeatUnexpectCount:");
          localStringBuilder1.append(r);
          QLog.d("HwSocketAdaptor", 1, localStringBuilder1.toString());
          r += 1;
          if (r >= com.tencent.mobileqq.msf.core.a.a.aN())
          {
            QLog.d("HwSocketAdaptor", 1, "close heartbeat proxy switch");
            b(156, false);
            r = 0;
          }
        }
        else if (l1 > 600000L)
        {
          o.add(localStringBuilder1.toString());
        }
      }
      c.removeMessages(153);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("failed to disconnect ");
      localStringBuilder2.append(localThrowable.toString());
      QLog.d("HwSocketAdaptor", 1, localStringBuilder2.toString(), localThrowable);
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
    if (paramBoolean)
    {
      if (e.inquireNetworkQuality() != 0)
      {
        if (!NetConnInfoCenter.isWifiOrMobileConn()) {
          return;
        }
        if (!h)
        {
          h = true;
          i = 0;
        }
        i += 1;
        if (i <= com.tencent.mobileqq.msf.core.a.a.aK()) {
          return;
        }
        t = true;
        a.j();
        i = 0;
      }
    }
    else if (h)
    {
      h = false;
      i = 0;
    }
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
      } else if (e.inquireNetworkQuality() == 0) {
        QLog.d("HwSocketAdaptor", 1, "bastet detect network quality none");
      }
      a.e();
      return;
    }
    catch (Throwable paramSocket)
    {
      paramSocket.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("failed to construct HwBastet instance ");
      localStringBuilder.append(paramSocket.toString());
      QLog.d("HwSocketAdaptor", 1, localStringBuilder.toString());
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
      paramArrayOfByte.printStackTrace();
      paramSocket = new StringBuilder();
      paramSocket.append("failed to send in huawei channel ");
      paramSocket.append(paramArrayOfByte.toString());
      QLog.d("HwSocketAdaptor", 1, paramSocket.toString());
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
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    if (paramInt != 156) {
      switch (paramInt)
      {
      default: 
      case 153: 
        for (;;)
        {
          try
          {
            StringBuilder localStringBuilder1 = new StringBuilder();
            localStringBuilder1.append("unknown config ");
            localStringBuilder1.append(paramInt);
            QLog.d("HwSocketAdaptor", 1, localStringBuilder1.toString());
            return false;
          }
          catch (Throwable localThrowable)
          {
            try
            {
              if (!e.isBastetAvailable())
              {
                QLog.d("HwSocketAdaptor", 1, "bastet is not available ");
                return false;
              }
              if ((b.b != null) && (b.c != null))
              {
                e.setAolHeartbeat(1, b.b, b.c);
                m = System.currentTimeMillis();
                x = false;
                c.sendEmptyMessageDelayed(153, 2700000L);
                return true;
              }
              QLog.d("HwSocketAdaptor", 1, "request or response null");
              return false;
            }
            catch (Exception localException3)
            {
              l += 1;
              localStringBuilder2 = new StringBuilder();
              localStringBuilder2.append("failed to init heartbeat content ");
              localStringBuilder2.append(localException3.toString());
              QLog.d("HwSocketAdaptor", 1, localStringBuilder2.toString(), localException3);
              return false;
            }
            localThrowable = localThrowable;
          }
          try
          {
            c.removeMessages(153);
            e.pauseHeartbeat();
            n = System.currentTimeMillis();
            return true;
          }
          catch (Exception localException1)
          {
            l += 1;
            QLog.d("HwSocketAdaptor", 1, "failed to pause heartbeat", localException1);
            return false;
          }
        }
      case 152: 
        try
        {
          if (!e.isBastetAvailable())
          {
            QLog.d("HwSocketAdaptor", 1, "bastet is not available for resume");
            return false;
          }
          e.resumeHeartbeat();
          return true;
        }
        catch (Exception localException2)
        {
          l += 1;
          QLog.d("HwSocketAdaptor", 1, "failed to resume heartbeat", localException2);
          return false;
        }
      }
    }
    s = paramBoolean;
    return false;
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("set config ");
    localStringBuilder2.append(paramInt);
    localStringBuilder2.append(" failed ");
    localStringBuilder2.append(localException3.toString());
    QLog.d("HwSocketAdaptor", 1, localStringBuilder2.toString(), localException3);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.c
 * JD-Core Version:    0.7.0.1
 */