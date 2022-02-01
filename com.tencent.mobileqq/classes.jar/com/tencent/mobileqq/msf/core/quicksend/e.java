package com.tencent.mobileqq.msf.core.quicksend;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.d.j;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class e
{
  private static final int b = 1000;
  private static final long c = 1800000L;
  private final ConcurrentHashMap a = new ConcurrentHashMap(1000);
  private Handler d = new f(this, Looper.getMainLooper());
  
  public e()
  {
    this.d.sendEmptyMessageDelayed(1000, 1800000L);
  }
  
  private void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (((ConcurrentHashMap)localObject).size() > 0))
    {
      localObject = this.a.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        e.a locala = (e.a)localEntry.getValue();
        if (SystemClock.elapsedRealtime() - locala.d >= 1800000L)
        {
          if (locala.f > 0L)
          {
            boolean bool;
            if (locala.g > 0L) {
              bool = true;
            } else {
              bool = false;
            }
            a(locala, bool);
          }
          this.a.remove(localEntry.getKey());
        }
      }
    }
  }
  
  private static void a(e.a parama, boolean paramBoolean)
  {
    if (parama != null)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("uin", parama.a);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.b);
      localHashMap.put("ssoSeq", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.c);
      localHashMap.put("cmd", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.e - parama.d);
      localHashMap.put("normalCost", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(parama.g - parama.f);
      localHashMap.put("quickCostTime", localStringBuilder.toString());
      if (MsfService.core.getStatReporter() != null) {
        MsfService.core.getStatReporter().a("dim_Msf_QuickSendEffect", paramBoolean, 0L, 0L, localHashMap, false, false);
      }
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg)
  {
    if (paramToServiceMsg != null)
    {
      e.a locala = new e.a();
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
      paramFromServiceMsg = (e.a)this.a.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      if (paramFromServiceMsg.f > 0L)
      {
        paramFromServiceMsg.e = l;
        boolean bool;
        if ((paramFromServiceMsg.g > 0L) && (paramFromServiceMsg.g <= paramFromServiceMsg.d)) {
          bool = true;
        } else {
          bool = false;
        }
        a(paramFromServiceMsg, bool);
      }
      this.a.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg != null) && (this.a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq())))) {
      ((e.a)this.a.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))).f = SystemClock.elapsedRealtime();
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = SystemClock.elapsedRealtime();
    if ((paramToServiceMsg != null) && (this.a.containsKey(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()))))
    {
      paramFromServiceMsg = (e.a)this.a.get(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
      if (paramFromServiceMsg.f > 0L)
      {
        paramFromServiceMsg.g = l;
        boolean bool;
        if ((paramFromServiceMsg.e > 0L) && (paramFromServiceMsg.e <= paramFromServiceMsg.g)) {
          bool = false;
        } else {
          bool = true;
        }
        a(paramFromServiceMsg, bool);
      }
      this.a.remove(Integer.valueOf(paramToServiceMsg.getRequestSsoSeq()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.quicksend.e
 * JD-Core Version:    0.7.0.1
 */