package com.tencent.mobileqq.kandian.base.utils;

import android.os.SystemClock;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TimeSliceHelper
{
  private static final Map<String, TimeSliceHelper> a = new HashMap();
  private long b = -1L;
  private List<Long> c = new ArrayList();
  private boolean d = false;
  private long e = -1L;
  
  public static long a(String paramString, boolean paramBoolean)
  {
    return b(paramString, false).a(paramBoolean);
  }
  
  public static String a()
  {
    Object localObject = Calendar.getInstance();
    if (localObject == null) {
      return "";
    }
    int i = ((Calendar)localObject).get(1);
    int j = ((Calendar)localObject).get(2);
    int k = ((Calendar)localObject).get(5);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.valueOf(i));
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(k);
    return ((StringBuilder)localObject).toString();
  }
  
  public static void a(String paramString)
  {
    a.remove(paramString);
  }
  
  public static void a(String paramString, TimeSliceHelper paramTimeSliceHelper)
  {
    if (paramString != null)
    {
      if (paramTimeSliceHelper == null) {
        return;
      }
      a.put(paramString, paramTimeSliceHelper);
    }
  }
  
  public static TimeSliceHelper b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (TimeSliceHelper)a.get(paramString);
  }
  
  private static TimeSliceHelper b(String paramString, boolean paramBoolean)
  {
    TimeSliceHelper localTimeSliceHelper2 = b(paramString);
    TimeSliceHelper localTimeSliceHelper1 = localTimeSliceHelper2;
    if (localTimeSliceHelper2 == null)
    {
      localTimeSliceHelper2 = new TimeSliceHelper();
      localTimeSliceHelper1 = localTimeSliceHelper2;
      if (paramBoolean)
      {
        a(paramString, localTimeSliceHelper2);
        localTimeSliceHelper1 = localTimeSliceHelper2;
      }
    }
    return localTimeSliceHelper1;
  }
  
  public static void c(String paramString)
  {
    b(paramString, true).b();
  }
  
  public static void d(String paramString)
  {
    b(paramString, false).c();
  }
  
  public static long e(String paramString)
  {
    return b(paramString, false).d();
  }
  
  public static long f(String paramString)
  {
    return b(paramString, false).e();
  }
  
  public long a(boolean paramBoolean)
  {
    if (paramBoolean) {
      c();
    }
    Object localObject1 = new ArrayList(this.c);
    long l1 = 0L;
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      l1 += ((Long)((Iterator)localObject2).next()).longValue();
    }
    long l2 = l1;
    if (this.d)
    {
      l2 = l1;
      if (!paramBoolean) {
        l2 = l1 + (SystemClock.elapsedRealtime() - this.e);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startMillis : ");
      ((StringBuilder)localObject2).append(this.b);
      ((StringBuilder)localObject2).append("  during : ");
      ((StringBuilder)localObject2).append(l2);
      ((StringBuilder)localObject2).append("  :  ");
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ((StringBuilder)localObject2).append((Long)((Iterator)localObject1).next());
        ((StringBuilder)localObject2).append("  : ");
      }
      QLog.d("TimeSliceHelper", 2, ((StringBuilder)localObject2).toString());
    }
    return l2;
  }
  
  public void b()
  {
    if (this.b < 0L) {
      this.b = NetConnInfoCenter.getServerTimeMillis();
    }
    if (!this.d)
    {
      this.d = true;
      this.e = SystemClock.elapsedRealtime();
    }
  }
  
  public void c()
  {
    try
    {
      if (this.d)
      {
        this.d = false;
        long l = SystemClock.elapsedRealtime() - this.e;
        if (l >= 0L) {
          this.c.add(Long.valueOf(l));
        } else {
          AIOUtils.a("", "", new IllegalArgumentException());
        }
      }
      return;
    }
    finally {}
  }
  
  public long d()
  {
    return this.b;
  }
  
  public long e()
  {
    return a(true);
  }
  
  public boolean f()
  {
    return this.d;
  }
  
  public void g()
  {
    this.b = -1L;
    this.c.clear();
    this.d = false;
    this.e = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper
 * JD-Core Version:    0.7.0.1
 */