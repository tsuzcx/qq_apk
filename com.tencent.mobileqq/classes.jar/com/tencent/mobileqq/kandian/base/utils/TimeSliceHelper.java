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
  private static final Map<String, TimeSliceHelper> jdField_a_of_type_JavaUtilMap = new HashMap();
  private long jdField_a_of_type_Long = -1L;
  private List<Long> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  private long b = -1L;
  
  public static long a(String paramString)
  {
    return a(paramString, false).a();
  }
  
  public static long a(String paramString, boolean paramBoolean)
  {
    return a(paramString, false).a(paramBoolean);
  }
  
  public static TimeSliceHelper a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return (TimeSliceHelper)jdField_a_of_type_JavaUtilMap.get(paramString);
  }
  
  private static TimeSliceHelper a(String paramString, boolean paramBoolean)
  {
    TimeSliceHelper localTimeSliceHelper2 = a(paramString);
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
    jdField_a_of_type_JavaUtilMap.remove(paramString);
  }
  
  public static void a(String paramString, TimeSliceHelper paramTimeSliceHelper)
  {
    if (paramString != null)
    {
      if (paramTimeSliceHelper == null) {
        return;
      }
      jdField_a_of_type_JavaUtilMap.put(paramString, paramTimeSliceHelper);
    }
  }
  
  public static long b(String paramString)
  {
    return a(paramString, false).b();
  }
  
  public static void b(String paramString)
  {
    a(paramString, true).a();
  }
  
  public static void c(String paramString)
  {
    a(paramString, false).b();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public long a(boolean paramBoolean)
  {
    if (paramBoolean) {
      b();
    }
    Object localObject1 = new ArrayList(this.jdField_a_of_type_JavaUtilList);
    long l1 = 0L;
    Object localObject2 = ((List)localObject1).iterator();
    while (((Iterator)localObject2).hasNext()) {
      l1 += ((Long)((Iterator)localObject2).next()).longValue();
    }
    long l2 = l1;
    if (this.jdField_a_of_type_Boolean)
    {
      l2 = l1;
      if (!paramBoolean) {
        l2 = l1 + (SystemClock.elapsedRealtime() - this.b);
      }
    }
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startMillis : ");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
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
  
  public void a()
  {
    if (this.jdField_a_of_type_Long < 0L) {
      this.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = true;
      this.b = SystemClock.elapsedRealtime();
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public long b()
  {
    return a(true);
  }
  
  public void b()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        long l = SystemClock.elapsedRealtime() - this.b;
        if (l >= 0L) {
          this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(l));
        } else {
          AIOUtils.a("", "", new IllegalArgumentException());
        }
      }
      return;
    }
    finally {}
  }
  
  public void c()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_Boolean = false;
    this.b = -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.TimeSliceHelper
 * JD-Core Version:    0.7.0.1
 */