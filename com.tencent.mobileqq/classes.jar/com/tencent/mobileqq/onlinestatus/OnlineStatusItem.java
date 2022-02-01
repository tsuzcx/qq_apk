package com.tencent.mobileqq.onlinestatus;

import androidx.annotation.NonNull;
import java.util.Arrays;
import mqq.app.AppRuntime.Status;

public class OnlineStatusItem
{
  public int a;
  public long a;
  public String a;
  public AppRuntime.Status a;
  public boolean a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  public OnlineStatusItem()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public OnlineStatusItem(long paramLong, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = paramString2;
  }
  
  public OnlineStatusItem(AppRuntime.Status paramStatus)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = OnlineStatusConstants.a(paramStatus);
    this.jdField_b_of_type_JavaLangString = OnlineStatusConstants.a(paramStatus);
  }
  
  public static int a(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static String a(AppRuntime.Status paramStatus, long paramLong)
  {
    return paramStatus.getValue() + "" + paramLong + "";
  }
  
  public static boolean a(long paramLong)
  {
    return paramLong == 1000L;
  }
  
  public static boolean a(Object paramObject1, Object paramObject2)
  {
    return (paramObject1 == paramObject2) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean a(AppRuntime.Status paramStatus, long paramLong)
  {
    return (paramStatus == AppRuntime.Status.online) && (paramLong > 40000L);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass())) {
        return false;
      }
      paramObject = (OnlineStatusItem)paramObject;
    } while ((this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.jdField_a_of_type_Boolean == paramObject.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramObject.jdField_a_of_type_MqqAppAppRuntime$Status) && (a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (a(this.c, paramObject.c)) && (a(this.d, paramObject.d)));
    return false;
  }
  
  public int hashCode()
  {
    return a(new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long), this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_MqqAppAppRuntime$Status, Integer.valueOf(this.jdField_b_of_type_Int), this.d, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
  }
  
  @NonNull
  public String toString()
  {
    return "id=" + this.jdField_a_of_type_Long + " title=" + this.jdField_b_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItem
 * JD-Core Version:    0.7.0.1
 */