package com.tencent.mobileqq.utils;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TimeTraceUtil
{
  public String a = "TimeTraceUtil";
  public ConcurrentHashMap<String, String> b = new ConcurrentHashMap();
  private long c = SystemClock.elapsedRealtime();
  
  private long a(String paramString, long paramLong)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    long l2 = 0L;
    if ((!bool) && (this.b.containsKey(paramString)))
    {
      paramString = (String)this.b.get(paramString);
      l1 = l2;
      if (TextUtils.isEmpty(paramString)) {
        break label114;
      }
      paramString = paramString.split(",");
      l1 = l2;
      if (paramString.length < 2) {
        break label114;
      }
      l1 = l2;
      if (!TextUtils.isDigitsOnly(paramString[1])) {
        break label114;
      }
      l1 = Long.parseLong(paramString[1]);
    }
    else
    {
      l1 = l2;
      if (!"~~startTime".equals(paramString)) {
        break label114;
      }
      l1 = this.c;
    }
    long l1 = paramLong - l1;
    label114:
    return l1;
  }
  
  public HashMap<String, String> a()
  {
    long l1;
    long l2;
    label194:
    synchronized (new HashMap())
    {
      if (this.b != null)
      {
        Iterator localIterator = this.b.entrySet().iterator();
        l1 = SystemClock.elapsedRealtime() - this.c;
        while (localIterator.hasNext())
        {
          Object localObject2 = (Map.Entry)localIterator.next();
          String str1 = (String)((Map.Entry)localObject2).getKey();
          localObject2 = ((String)((Map.Entry)localObject2).getValue()).split(",");
          l2 = l1;
          if (localObject2 == null) {
            break label194;
          }
          l2 = l1;
          if (localObject2.length < 3) {
            break label194;
          }
          String str2 = localObject2[0];
          CharSequence localCharSequence = localObject2[1];
          if (!Boolean.parseBoolean(localObject2[2]))
          {
            l2 = l1;
            if (!TextUtils.isDigitsOnly(localCharSequence)) {
              break label194;
            }
            l2 = a(str2, Long.parseLong(localCharSequence));
            break label194;
            ???.put(str1, String.valueOf(l1));
          }
        }
      }
      return ???;
    }
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if ((this.b != null) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      long l = SystemClock.elapsedRealtime();
      ConcurrentHashMap localConcurrentHashMap = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2);
      localStringBuilder.append(",");
      localStringBuilder.append(String.valueOf(l));
      localStringBuilder.append(",");
      String str;
      if (paramBoolean) {
        str = "true";
      } else {
        str = "false";
      }
      localStringBuilder.append(str);
      localConcurrentHashMap.put(paramString1, localStringBuilder.toString());
      paramString1 = String.format("TimerOutput: %s to %s cost=%d", new Object[] { paramString2, paramString1, Long.valueOf(a(paramString2, l)) });
      if (QLog.isColorLevel())
      {
        QLog.d(this.a, 2, paramString1);
        return;
      }
      Log.i(this.a, paramString1);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    a(paramString, "~~startTime", paramBoolean);
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    HashMap localHashMap = a();
    if (localHashMap != null) {}
    try
    {
      Iterator localIterator = localHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject3 = (Map.Entry)localIterator.next();
        String str = (String)((Map.Entry)localObject3).getKey();
        localObject3 = (String)((Map.Entry)localObject3).getValue();
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject3)))
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(str);
          localStringBuilder.append(":");
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append("ms,");
          ((StringBuilder)localObject1).append(localStringBuilder.toString());
        }
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.TimeTraceUtil
 * JD-Core Version:    0.7.0.1
 */