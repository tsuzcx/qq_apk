package com.tencent.util;

import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class ProfilePerformanceReport
{
  public static ProfilePerformanceReport a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "param_click2create", "param_first_draw", "param_first_show", "param_open", "param_run_delay", "param_init_data", "param_fetch_data", "param_prepare_res", "param_refresh_from_cache", "param_refresh_from_net" };
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final String jdField_a_of_type_JavaLangString;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private final long[] jdField_a_of_type_ArrayOfLong;
  private final long[] b;
  
  public static void a() {}
  
  public void a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 9) {
        return;
      }
      Object localObject = this.jdField_a_of_type_ArrayOfLong;
      if (localObject[paramInt] == 0L)
      {
        localObject[paramInt] = SystemClock.elapsedRealtime();
        if (paramInt == 0)
        {
          this.jdField_a_of_type_Int = 2;
          localObject = this.jdField_a_of_type_ArrayOfLong;
          localObject[3] = localObject[paramInt];
        }
        if (QLog.isDevelopLevel())
        {
          this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
          localObject = this.jdField_a_of_type_JavaLangStringBuilder;
          ((StringBuilder)localObject).append("markStart, [");
          ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_ArrayOfLong[paramInt]);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          ((StringBuilder)localObject).append("]");
          QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    HashMap localHashMap = new HashMap();
    long l1 = 0L;
    long l2 = l1;
    int i = 0;
    Object localObject;
    while (i <= 9)
    {
      localObject = this.b;
      if (localObject[i] != 0L)
      {
        long[] arrayOfLong = this.jdField_a_of_type_ArrayOfLong;
        if (arrayOfLong[i] != 0L)
        {
          l1 = localObject[i] - arrayOfLong[i];
          break label67;
        }
      }
      l1 = 0L;
      label67:
      if (i == 3) {
        l2 = l1;
      }
      localObject = jdField_a_of_type_ArrayOfJavaLangString[i];
      long l3;
      if (l1 > 0L) {
        l3 = l1;
      } else {
        l3 = 0L;
      }
      localHashMap.put(localObject, String.valueOf(l3));
      i += 1;
    }
    this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_Int = 1;
    if (QLog.isDevelopLevel())
    {
      this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
      localObject = this.jdField_a_of_type_JavaLangStringBuilder;
      ((StringBuilder)localObject).append("reportPerformance, [");
      ((StringBuilder)localObject).append(l1);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append(localHashMap.toString());
      ((StringBuilder)localObject).append("]");
      QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
    }
    ThreadManager.getSubThreadHandler().post(new ProfilePerformanceReport.1(this, paramString, l2, localHashMap));
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    return (i == 2) || (i == 3);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramInt >= 0)
    {
      if (paramInt > 9) {
        return false;
      }
      bool1 = bool2;
      if (this.jdField_a_of_type_ArrayOfLong[paramInt] != 0L)
      {
        bool1 = bool2;
        if (this.b[paramInt] != 0L) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(boolean paramBoolean)
  {
    int i = this.jdField_a_of_type_Int;
    if (i < 3) {
      return false;
    }
    return (i == 4) || (paramBoolean);
  }
  
  public void b(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt > 9) {
        return;
      }
      if (this.jdField_a_of_type_ArrayOfLong[paramInt] != 0L)
      {
        Object localObject = this.b;
        if (localObject[paramInt] == 0L)
        {
          localObject[paramInt] = SystemClock.elapsedRealtime();
          if (paramInt == 1)
          {
            localObject = this.b;
            localObject[3] = localObject[paramInt];
            this.jdField_a_of_type_Int = 3;
          }
          else if (paramInt == 9)
          {
            this.jdField_a_of_type_Int = 4;
          }
          if (QLog.isDevelopLevel())
          {
            this.jdField_a_of_type_JavaLangStringBuilder.setLength(0);
            localObject = this.jdField_a_of_type_JavaLangStringBuilder;
            ((StringBuilder)localObject).append("markEnd, [");
            ((StringBuilder)localObject).append(jdField_a_of_type_ArrayOfJavaLangString[paramInt]);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(this.b[paramInt]);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(this.b[paramInt] - this.jdField_a_of_type_ArrayOfLong[paramInt]);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
            ((StringBuilder)localObject).append("]");
            QLog.i("ProfilePerformanceReport", 4, this.jdField_a_of_type_JavaLangStringBuilder.toString());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.util.ProfilePerformanceReport
 * JD-Core Version:    0.7.0.1
 */