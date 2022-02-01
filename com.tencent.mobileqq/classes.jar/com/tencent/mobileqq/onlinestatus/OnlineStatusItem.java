package com.tencent.mobileqq.onlinestatus;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
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
  public String g;
  
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
  
  public OnlineStatusItem(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this(paramLong, paramString1, paramString2);
    if (TextUtils.isEmpty(paramString3)) {
      QLog.d("OnlineStatusConfProcessor", 1, "bigIcon is empty, use icon");
    } else {
      paramString2 = paramString3;
    }
    this.d = paramString2;
  }
  
  public OnlineStatusItem(AppRuntime.Status paramStatus)
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = AppRuntime.Status.online;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 2;
    this.jdField_a_of_type_MqqAppAppRuntime$Status = paramStatus;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Int = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getButtonId(paramStatus);
    this.jdField_b_of_type_JavaLangString = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusName(paramStatus);
  }
  
  public static int a(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
  }
  
  public static String a(AppRuntime.Status paramStatus, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStatus.getValue());
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    return localStringBuilder.toString();
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
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (OnlineStatusItem)paramObject;
      return (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long) && (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int) && (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int) && (this.jdField_a_of_type_Boolean == paramObject.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_MqqAppAppRuntime$Status == paramObject.jdField_a_of_type_MqqAppAppRuntime$Status) && (a(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) && (a(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString)) && (a(this.c, paramObject.c)) && (a(this.e, paramObject.e));
    }
    return false;
  }
  
  public int hashCode()
  {
    return a(new Object[] { this.jdField_a_of_type_JavaLangString, Long.valueOf(this.jdField_a_of_type_Long), this.jdField_b_of_type_JavaLangString, this.c, Integer.valueOf(this.jdField_a_of_type_Int), this.jdField_a_of_type_MqqAppAppRuntime$Status, Integer.valueOf(this.jdField_b_of_type_Int), this.e, Boolean.valueOf(this.jdField_a_of_type_Boolean) });
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("id=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" title=");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItem
 * JD-Core Version:    0.7.0.1
 */