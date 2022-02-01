package com.tencent.tencentmap.mapsdk.maps.model;

public final class CameraPosition$Builder
{
  private LatLng a;
  private float b;
  private float c = 1.4E-45F;
  private float d = 1.4E-45F;
  
  public CameraPosition$Builder() {}
  
  public CameraPosition$Builder(CameraPosition paramCameraPosition)
  {
    this.a = paramCameraPosition.target;
    this.b = paramCameraPosition.zoom;
    this.c = paramCameraPosition.tilt;
    this.d = paramCameraPosition.bearing;
  }
  
  public final Builder bearing(float paramFloat)
  {
    this.d = paramFloat;
    return this;
  }
  
  public final CameraPosition build()
  {
    return new CameraPosition(this.a, this.b, this.c, this.d);
  }
  
  public final Builder target(LatLng paramLatLng)
  {
    this.a = paramLatLng;
    return this;
  }
  
  public final Builder tilt(float paramFloat)
  {
    this.c = paramFloat;
    return this;
  }
  
  public final Builder zoom(float paramFloat)
  {
    this.b = paramFloat;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CameraPosition.Builder
 * JD-Core Version:    0.7.0.1
 */