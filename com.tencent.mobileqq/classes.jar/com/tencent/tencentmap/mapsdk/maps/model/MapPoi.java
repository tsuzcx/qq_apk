package com.tencent.tencentmap.mapsdk.maps.model;

public class MapPoi
{
  protected double latitude;
  protected double longitude;
  public String name;
  public LatLng position;
  
  public MapPoi() {}
  
  public MapPoi(double paramDouble1, double paramDouble2)
  {
    this.latitude = paramDouble1;
    this.longitude = paramDouble2;
  }
  
  public MapPoi(double paramDouble1, double paramDouble2, String paramString)
  {
    this(paramDouble1, paramDouble2);
    this.name = paramString;
  }
  
  public double getLatitude()
  {
    return this.latitude;
  }
  
  public double getLongitude()
  {
    return this.longitude;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public LatLng getPosition()
  {
    return this.position;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.MapPoi
 * JD-Core Version:    0.7.0.1
 */