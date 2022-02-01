package com.tencent.mobileqq.onlinestatus.location;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Location
{
  public final LatLng a;
  public final String b;
  public final float c;
  public final long d;
  
  public Location(LatLng paramLatLng, String paramString, float paramFloat, long paramLong)
  {
    this.a = paramLatLng;
    this.b = paramString;
    this.c = paramFloat;
    this.d = paramLong;
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.d >= Constant.Q;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Location{latLng=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", provider='");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", accuracy=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", time=");
    localStringBuilder.append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.d)));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.Location
 * JD-Core Version:    0.7.0.1
 */