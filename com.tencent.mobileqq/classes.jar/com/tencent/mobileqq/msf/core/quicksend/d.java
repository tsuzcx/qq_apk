package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class d
{
  private static final int b = 1000;
  private static final long c = 1800000L;
  private final ConcurrentHashMap a = new ConcurrentHashMap(1000);
  private Handler d = new e(this, Looper.getMainLooper());
  
  public d()
  {
    this.d.sendEmptyMessageDelayed(1000, 1800000L);
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        a locala = (a)localEntry.getValue();
        if (SystemClock.elapsedRealtime() - locala.d >= 1800000L)
        {
          if (locala.f > 0L) {
            if (locala.g <= 0L) {
              break label121;
            }
          }
          label121:
          for (boolean bool = true;; bool = false)
          {
            a(locala, bool);
            this.a.remove(localEntry.getKey());
            break;
          }
        }
      }
    }
  }
  
  private static void a(a parama, boolean paramBoolean)
  {
    if (parama != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", parama.a);
      localHashMap.put("ssoSeq", "" + parama.b);
      localHashMap.put("cmd", "" + parama.c);
      localHashMap.put("normalCost", "" + (parama.e - parama.d));
      localHashMap.put("quickCostTime", "" + (parama.g - parama.f));
      if (MsfService.core.getStatReporter() != null) {
        MsfService.core.getStatReporter().a("dim.Msf.QuickSendEffect", paramBoolean, 0L, 0L, localHashMap, false, false);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      a locala = new a();
      locala.a = paramToServiceMsg.getUin();
      locala.b = paramToServiceMsg.getRequestSsoSeq();
      locala.c = paramToServiceMsg.getServiceCmd();
      locala.d = SystemClock.elapsedRealtime();
      this.a.put(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()), locala);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = SystemClock.elapsedRealtime();
    if ((paramToServiceMsg != null) && (this.a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))))
    {
      paramFromServiceMsg = (a)this.a.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      if (paramFromServiceMsg.f > 0L)
      {
        paramFromServiceMsg.e = l;
        if ((paramFromServiceMsg.g <= 0L) || (paramFromServiceMsg.g > paramFromServiceMsg.d)) {
          break label103;
        }
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      a(paramFromServiceMsg, bool);
      this.a.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      return;
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (this.a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))) {
      ((a)this.a.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).f = SystemClock.elapsedRealtime();
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = SystemClock.elapsedRealtime();
    if ((paramToServiceMsg != null) && (this.a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))))
    {
      paramFromServiceMsg = (a)this.a.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      if (paramFromServiceMsg.f > 0L)
      {
        paramFromServiceMsg.g = l;
        if ((paramFromServiceMsg.e > 0L) && (paramFromServiceMsg.e <= paramFromServiceMsg.g)) {
          break label103;
        }
      }
    }
    label103:
    for (boolean bool = true;; bool = false)
    {
      a(paramFromServiceMsg, bool);
      this.a.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      return;
    }
  }
  
  static class a
  {
    public String a;
    public int b;
    public String c;
    public long d;
    public long e;
    public long f;
    public long g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.d
 * JD-Core Version:    0.7.0.1
 */