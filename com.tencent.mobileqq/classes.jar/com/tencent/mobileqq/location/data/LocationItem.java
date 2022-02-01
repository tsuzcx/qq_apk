package com.tencent.mobileqq.location.data;

import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class LocationItem
{
  private String a;
  private LatLng b;
  private double c;
  private int d = -1;
  
  public LocationItem(String paramString, LatLng paramLatLng, double paramDouble)
  {
    this.a = paramString;
    this.b = paramLatLng;
    this.c = paramDouble;
  }
  
  public LatLng a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    if (paramLatLng != null) {
      this.b = paramLatLng;
    }
    if (paramDouble != null) {
      this.c = paramDouble.doubleValue();
    }
  }
  
  public double b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.a;
  }
  
  public void d()
  {
    this.b = null;
  }
  
  public int e()
  {
    return this.d;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof LocationItem))
    {
      paramObject = (LocationItem)paramObject;
      return this.a.equals(paramObject.c());
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LocationItem{mUin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mLatLng=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mRotation=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationItem
 * JD-Core Version:    0.7.0.1
 */