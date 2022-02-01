package com.tencent.mobileqq.onlinestatus.location;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.onlinestatus.auto.Constant;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Location
{
  public final float a;
  public final long a;
  public final LatLng a;
  public final String a;
  
  public Location(LatLng paramLatLng, String paramString, float paramFloat, long paramLong)
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public boolean a()
  {
    return System.currentTimeMillis() - this.jdField_a_of_type_Long >= Constant.N;
  }
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Location{latLng=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng);
    localStringBuilder.append(", provider='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", accuracy=");
    localStringBuilder.append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", time=");
    localStringBuilder.append(new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date(this.jdField_a_of_type_Long)));
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.Location
 * JD-Core Version:    0.7.0.1
 */