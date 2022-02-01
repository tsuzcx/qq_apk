package com.tencent.mobileqq.onlinestatus.location;

import android.text.TextUtils;

public class LocationInfo
{
  public double a;
  public double b;
  public double c;
  public String d;
  public String e;
  public long f;
  public String g = "";
  public int h;
  
  public LocationInfo(double paramDouble1, double paramDouble2, String paramString1, String paramString2)
  {
    this.a = paramDouble1;
    this.b = paramDouble2;
    this.d = paramString1;
    this.g = paramString2;
    if (a(this.a, this.b, paramString2))
    {
      this.h = 0;
      return;
    }
    this.h = 1;
  }
  
  public static boolean a(double paramDouble1, double paramDouble2, String paramString)
  {
    return (Math.abs(paramDouble1) > 0.0001D) && (Math.abs(paramDouble2) > 0.0001D) && (!TextUtils.isEmpty(paramString));
  }
  
  public static boolean a(LocationInfo paramLocationInfo, double paramDouble1, double paramDouble2, String paramString)
  {
    boolean bool = true;
    if (paramLocationInfo == null) {
      return true;
    }
    if (paramString == null) {
      return false;
    }
    if (!paramString.equals(paramLocationInfo.g)) {
      return true;
    }
    if (Math.abs(paramDouble1) >= 0.0001D)
    {
      if (Math.abs(paramDouble2) < 0.0001D) {
        return false;
      }
      if (Math.abs(paramLocationInfo.a - paramDouble1) <= 0.001D)
      {
        if (Math.abs(paramLocationInfo.b - paramDouble2) > 0.001D) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("mLatitude:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mLongitude:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(" mDirection:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" mPoiName:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(" mPoiAddr:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(" adCode:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(" mUpdateTime:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(" mValidFlag:");
    localStringBuilder.append(this.h);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationInfo
 * JD-Core Version:    0.7.0.1
 */