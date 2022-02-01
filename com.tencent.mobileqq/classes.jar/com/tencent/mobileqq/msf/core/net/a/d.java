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
    int m = 0;
    int k = 0;
    long l1;
    long l2;
    if ((paramInt == 513) || ((paramInt == 515) || (paramInt == 516)))
    {
      try
      {
        localObject1 = new StringBuilder();
        localObject2 = e.entrySet().iterator();
        l1 = 0L;
        paramInt = k;
        if (((Iterator)localObject2).hasNext())
        {
          localEntry = (Map.Entry)((Iterator)localObject2).next();
          k = paramInt;
          l2 = l1;
          if (((Long)localEntry.getValue()).longValue() > 45000L) {
            break label735;
          }
          if (((Long)localEntry.getValue()).longValue() < 0L)
          {
            k = paramInt;
            l2 = l1;
            break label735;
          }
          ((StringBuilder)localObject1).append("seq_");
          ((StringBuilder)localObject1).append(localEntry.getKey());
          ((StringBuilder)localObject1).append("+");
          ((StringBuilder)localObject1).append("consume_");
          ((StringBuilder)localObject1).append(localEntry.getValue());
          ((StringBuilder)localObject1).append("|");
          l2 = l1 + ((Long)localEntry.getValue()).longValue();
          k = paramInt + 1;
          break label735;
        }
        if (paramInt > 0)
        {
          ((StringBuilder)localObject1).append("count_");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append("+");
          ((StringBuilder)localObject1).append("sumcount_");
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append("+average_");
          ((StringBuilder)localObject1).append(l1 / paramInt);
        }
        e.clear();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report consume exclude timeout: ");
        ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
        QLog.d("NormalSocketAdaptor", 1, ((StringBuilder)localObject2).toString());
        return ((StringBuilder)localObject1).toString();
      }
      catch (Exception localException)
      {
        Object localObject1;
        Object localObject2;
        Map.Entry localEntry;
        QLog.d("NormalSocketAdaptor", 1, "failed to get config ", localException);
      }
      localObject1 = new StringBuilder();
      localObject2 = f.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((StringBuilder)localObject1).append((String)((Iterator)localObject2).next());
        ((StringBuilder)localObject1).append("#");
      }
      f.clear();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("report heartbeat: ");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("NormalSocketAdaptor", 2, ((StringBuilder)localObject2).toString());
      return ((StringBuilder)localObject1).toString();
      localObject1 = new StringBuilder();
      localObject2 = d.entrySet().iterator();
      l1 = 0L;
      paramInt = m;
    }
    for (;;)
    {
      if (((Iterator)localObject2).hasNext())
      {
        localEntry = (Map.Entry)((Iterator)localObject2).next();
        if (((Long)localEntry.getValue()).longValue() <= 600000L) {
          if (((Long)localEntry.getValue()).longValue() >= 0L)
          {
            ((StringBuilder)localObject1).append("seq_");
            ((StringBuilder)localObject1).append(localEntry.getKey());
            ((StringBuilder)localObject1).append("+");
            ((StringBuilder)localObject1).append("consume_");
            ((StringBuilder)localObject1).append(localEntry.getValue());
            ((StringBuilder)localObject1).append("|");
            l1 += ((Long)localEntry.getValue()).longValue();
            paramInt += 1;
          }
        }
      }
      else
      {
        if (paramInt > 0)
        {
          ((StringBuilder)localObject1).append("count_");
          ((StringBuilder)localObject1).append(paramInt);
          ((StringBuilder)localObject1).append("+");
          ((StringBuilder)localObject1).append("sumcount_");
          ((StringBuilder)localObject1).append(l1);
          ((StringBuilder)localObject1).append("+average_");
          ((StringBuilder)localObject1).append(l1 / paramInt);
        }
        d.clear();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("report consume: ");
        ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
        QLog.d("NormalSocketAdaptor", 1, ((StringBuilder)localObject2).toString());
        localObject1 = ((StringBuilder)localObject1).toString();
        return localObject1;
        return null;
        label735:
        paramInt = k;
        l1 = l2;
        break;
      }
    }
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
        localStringBuilder.append("begin_");
        localStringBuilder.append(g);
        localStringBuilder.append(":");
        localStringBuilder.append("end_");
        localStringBuilder.append(h);
        localStringBuilder.append(":");
        localStringBuilder.append("last_");
        localStringBuilder.append(l);
        localStringBuilder.append(":");
        localStringBuilder.append("net_");
        localStringBuilder.append(NetConnInfoCenter.isWifiOrMobileConn());
        f.add(localStringBuilder.toString());
        return;
      }
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
        return;
      }
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
      paramSocket = new StringBuilder();
      paramSocket.append("failed to send in normal way ");
      paramSocket.append(paramArrayOfByte.toString());
      QLog.d("NormalSocketAdaptor", 1, paramSocket.toString());
    }
  }
  
  public boolean b(int paramInt, boolean paramBoolean)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.d
 * JD-Core Version:    0.7.0.1
 */