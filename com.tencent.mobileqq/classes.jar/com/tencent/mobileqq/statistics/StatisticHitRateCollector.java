package com.tencent.mobileqq.statistics;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class StatisticHitRateCollector
{
  public static StatisticHitRateCollector a = new StatisticHitRateCollector("qzone");
  public Map<String, Boolean> b = new ConcurrentHashMap();
  public Map<String, Boolean> c = new ConcurrentHashMap();
  private final String d;
  
  public StatisticHitRateCollector(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StatisticHitRateCollector_");
    localStringBuilder.append(paramString);
    this.d = localStringBuilder.toString();
  }
  
  public static StatisticHitRateCollector a()
  {
    return a;
  }
  
  public static String b()
  {
    Object localObject = MobileQQ.getMobileQQ();
    if (localObject != null) {
      localObject = ((MobileQQ)localObject).peekAppRuntime();
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return "0";
    }
    if (((AppRuntime)localObject).getAccount() == null) {
      return "0";
    }
    return ((AppRuntime)localObject).getAccount();
  }
  
  public void a(String paramString)
  {
    a(paramString, "actQZLoadHitRateRed");
  }
  
  public void a(String paramString1, String paramString2)
  {
    Object localObject = (Boolean)this.b.get(paramString2);
    if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
    {
      localObject = (Boolean)this.c.get(paramString2);
      if ((localObject != null) && (((Boolean)localObject).booleanValue()))
      {
        this.b.put(paramString2, Boolean.valueOf(true));
        if (QLog.isColorLevel())
        {
          localObject = this.d;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("hitEnd sucess action = ");
          localStringBuilder.append(paramString2);
          localStringBuilder.append(" , hit = true, uin = ");
          localStringBuilder.append(paramString1);
          QLog.d((String)localObject, 2, localStringBuilder.toString());
        }
        StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, true, 0L, 0L, null, null);
        this.b.remove(paramString2);
        this.c.remove(paramString2);
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preloadMark preloadAction = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" , flag = ");
      localStringBuilder.append(paramBoolean);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    if (paramBoolean) {
      b(b(), paramString);
    }
    this.b.put(paramString, Boolean.valueOf(false));
    this.c.put(paramString, Boolean.valueOf(true));
  }
  
  public void b(String paramString)
  {
    a(paramString, "actQZLoadHitRateLeba");
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (paramString2 != null)
    {
      Object localObject = (Boolean)this.b.get(paramString2);
      if ((localObject == null) || (!((Boolean)localObject).booleanValue()))
      {
        localObject = (Boolean)this.c.get(paramString2);
        if ((localObject != null) && (((Boolean)localObject).booleanValue()))
        {
          this.b.put(paramString2, Boolean.valueOf(true));
          if (QLog.isColorLevel())
          {
            localObject = this.d;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("hitEnd action = ");
            localStringBuilder.append(paramString2);
            localStringBuilder.append(" , hit = false, uin = ");
            localStringBuilder.append(paramString1);
            QLog.d((String)localObject, 2, localStringBuilder.toString());
          }
          StatisticCollector.getInstance(MobileQQ.getContext()).collectPerformance(paramString1, paramString2, false, 0L, 0L, null, null);
          this.b.remove(paramString2);
          this.c.remove(paramString2);
        }
      }
    }
  }
  
  public void c(String paramString)
  {
    a(paramString, "actQZLoadHitRateProfile");
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = new ArrayList(this.c.keySet()).iterator();
    while (localIterator.hasNext()) {
      b(paramString, (String)localIterator.next());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.StatisticHitRateCollector
 * JD-Core Version:    0.7.0.1
 */