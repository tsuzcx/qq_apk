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
  public String a;
  public long b;
  public String c;
  public String d;
  public String e;
  public int f = 1;
  public AppRuntime.Status g = AppRuntime.Status.online;
  public int h;
  public String i;
  public boolean j = true;
  public String k;
  public String l;
  public String m;
  public String n;
  
  public OnlineStatusItem() {}
  
  public OnlineStatusItem(long paramLong, String paramString1, String paramString2)
  {
    this.b = paramLong;
    this.c = paramString1;
    this.d = paramString2;
  }
  
  public OnlineStatusItem(long paramLong, String paramString1, String paramString2, String paramString3)
  {
    this(paramLong, paramString1, paramString2);
    if (TextUtils.isEmpty(paramString3)) {
      QLog.d("OnlineStatusConfProcessor", 1, "bigIcon is empty, use icon");
    } else {
      paramString2 = paramString3;
    }
    this.e = paramString2;
  }
  
  public OnlineStatusItem(AppRuntime.Status paramStatus)
  {
    this.f = 2;
    this.g = paramStatus;
    this.b = 0L;
    this.h = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getButtonId(paramStatus);
    this.c = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusName(paramStatus);
  }
  
  public static int a(Object... paramVarArgs)
  {
    return Arrays.hashCode(paramVarArgs);
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
  
  public static String b(AppRuntime.Status paramStatus, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramStatus.getValue());
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    return localStringBuilder.toString();
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
      return (this.b == paramObject.b) && (this.f == paramObject.f) && (this.h == paramObject.h) && (this.j == paramObject.j) && (this.g == paramObject.g) && (a(this.a, paramObject.a)) && (a(this.c, paramObject.c)) && (a(this.d, paramObject.d)) && (a(this.i, paramObject.i));
    }
    return false;
  }
  
  public int hashCode()
  {
    return a(new Object[] { this.a, Long.valueOf(this.b), this.c, this.d, Integer.valueOf(this.f), this.g, Integer.valueOf(this.h), this.i, Boolean.valueOf(this.j) });
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("id=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" title=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.OnlineStatusItem
 * JD-Core Version:    0.7.0.1
 */