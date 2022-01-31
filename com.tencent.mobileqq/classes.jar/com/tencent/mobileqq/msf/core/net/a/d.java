package com.tencent.mobileqq.msf.core.net.a;

import android.content.Context;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class d
  implements e
{
  public static final String a = "NormalSocketAdaptor";
  private static OutputStream b;
  private static ConcurrentHashMap d = new ConcurrentHashMap();
  private static ConcurrentHashMap e = new ConcurrentHashMap();
  private static ConcurrentLinkedQueue f = new ConcurrentLinkedQueue();
  private static long g = 0L;
  private static long h = 0L;
  private static final long i = 600000L;
  private static int j = 0;
  private Socket c = null;
  
  public d(Context paramContext)
  {
    QLog.d("NormalSocketAdaptor", 1, "init normal socket adaptor");
    j = 0;
  }
  
  public String a(int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return null;
      try
      {
        localStringBuilder = new StringBuilder();
        localIterator = d.entrySet().iterator();
        l = 0L;
        k = 0;
        paramInt = 0;
        while (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          if ((((Long)localEntry.getValue()).longValue() <= 600000L) && (((Long)localEntry.getValue()).longValue() >= 0L))
          {
            localStringBuilder.append("seq_").append(localEntry.getKey()).append("+").append("consume_").append(localEntry.getValue()).append("|");
            l += ((Long)localEntry.getValue()).longValue();
            k += 1;
            paramInt += 1;
          }
        }
        if (k > 0) {
          localStringBuilder.append("count_").append(k).append("+").append("sumcount_").append(l).append("+average_").append(l / k);
        }
        d.clear();
        QLog.d("NormalSocketAdaptor", 1, "report consume: " + localStringBuilder.toString());
        return localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder;
        Iterator localIterator;
        long l;
        int k;
        Map.Entry localEntry;
        QLog.d("NormalSocketAdaptor", 1, "failed to get config ", localException);
      }
      localStringBuilder = new StringBuilder();
      localIterator = e.entrySet().iterator();
      l = 0L;
      k = 0;
      paramInt = 0;
      while (localIterator.hasNext())
      {
        localEntry = (Map.Entry)localIterator.next();
        if ((((Long)localEntry.getValue()).longValue() <= 45000L) && (((Long)localEntry.getValue()).longValue() >= 0L))
        {
          localStringBuilder.append("seq_").append(localEntry.getKey()).append("+").append("consume_").append(localEntry.getValue()).append("|");
          l += ((Long)localEntry.getValue()).longValue();
          k += 1;
          paramInt += 1;
        }
      }
      if (k > 0) {
        localStringBuilder.append("count_").append(k).append("+").append("sumcount_").append(l).append("+average_").append(l / k);
      }
      e.clear();
      QLog.d("NormalSocketAdaptor", 1, "report consume exclude timeout: " + localStringBuilder.toString());
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localIterator = f.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append((String)localIterator.next()).append("#");
      }
    }
    f.clear();
    QLog.d("NormalSocketAdaptor", 2, "report heartbeat: " + localException.toString());
    String str = localException.toString();
    return str;
  }
  
  public void a()
  {
    try
    {
      h = System.currentTimeMillis();
      long l = h - g;
      if (l > 600000L)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("begin_").append(g).append(":");
        localStringBuilder.append("end_").append(h).append(":");
        localStringBuilder.append("last_").append(l).append(":");
        localStringBuilder.append("net_").append(NetConnInfoCenter.isWifiOrMobileConn());
        f.add(localStringBuilder.toString());
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("NormalSocketAdaptor", 1, "failed to disconnect in normal way", localException);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2;
      if ((d.containsKey(Integer.valueOf(paramInt))) && (NetConnInfoCenter.isMobileConn()))
      {
        l2 = ((Long)d.get(Integer.valueOf(paramInt))).longValue();
        d.put(Integer.valueOf(paramInt), Long.valueOf(l1 - l2));
        if (d.size() > 300) {
          a.g();
        }
      }
      if ((!paramBoolean) && (e.containsKey(Integer.valueOf(paramInt))) && (NetConnInfoCenter.isMobileConn()))
      {
        l2 = ((Long)e.get(Integer.valueOf(paramInt))).longValue();
        e.put(Integer.valueOf(paramInt), Long.valueOf(l1 - l2));
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.d("NormalSocketAdaptor", 1, "failed to recv in normal way ", localException);
    }
  }
  
  public void a(Socket paramSocket)
  {
    g = System.currentTimeMillis();
  }
  
  public void a(byte[] paramArrayOfByte, Socket paramSocket, int paramInt)
  {
    QLog.d("NormalSocketAdaptor", 1, "start to send in normal channel");
    try
    {
      if (this.c != paramSocket)
      {
        this.c = paramSocket;
        b = this.c.getOutputStream();
      }
      b.write(paramArrayOfByte);
      b.flush();
      d.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
      e.put(Integer.valueOf(paramInt), Long.valueOf(System.currentTimeMillis()));
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      j += 1;
      if (j > com.tencent.mobileqq.msf.core.a.a.aL()) {
        a.j();
      }
      QLog.d("NormalSocketAdaptor", 1, "failed to send in normal way " + paramArrayOfByte.toString());
    }
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.d
 * JD-Core Version:    0.7.0.1
 */