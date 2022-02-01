package com.tencent.mobileqq.location.data;

import android.support.annotation.Nullable;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

public class LocationItem
{
  private double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int = -1;
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private String jdField_a_of_type_JavaLangString;
  
  public LocationItem(String paramString, LatLng paramLatLng, double paramDouble)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    this.jdField_a_of_type_Double = paramDouble;
  }
  
  public double a()
  {
    return this.jdField_a_of_type_Double;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public LatLng a()
  {
    return this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(LatLng paramLatLng, Double paramDouble)
  {
    if (paramLatLng != null) {
      this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng = paramLatLng;
    }
    if (paramDouble != null) {
      this.jdField_a_of_type_Double = paramDouble.doubleValue();
    }
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if ((paramObject instanceof LocationItem))
    {
      paramObject = (LocationItem)paramObject;
      return this.jdField_a_of_type_JavaLangString.equals(paramObject.a());
    }
    return super.equals(paramObject);
  }
  
  public String toString()
  {
    return "LocationItem{mUin='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mLatLng=" + this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng + ", mRotation=" + this.jdField_a_of_type_Double + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.data.LocationItem
 * JD-Core Version:    0.7.0.1
 */