package com.tencent.tencentmap.mapsdk.maps.model;

public final class CameraPosition
{
  public final float bearing;
  public LatLng target;
  public final float tilt;
  public final float zoom;
  
  public CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(paramLatLng, paramFloat1, paramFloat2, paramFloat3, (byte)0);
  }
  
  private CameraPosition(LatLng paramLatLng, float paramFloat1, float paramFloat2, float paramFloat3, byte paramByte)
  {
    this.target = paramLatLng;
    this.zoom = paramFloat1;
    this.tilt = paramFloat2;
    this.bearing = paramFloat3;
  }
  
  public static CameraPosition.Builder builder()
  {
    return new CameraPosition.Builder();
  }
  
  public static CameraPosition.Builder builder(CameraPosition paramCameraPosition)
  {
    return new CameraPosition.Builder(paramCameraPosition);
  }
  
  public static final CameraPosition fromLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraPosition(paramLatLng, paramFloat, 0.0F, 0.0F);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof CameraPosition)) {
      return false;
    }
    paramObject = (CameraPosition)paramObject;
    return (this.target.equals(paramObject.target)) && (Float.floatToIntBits(this.zoom) == Float.floatToIntBits(paramObject.zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(paramObject.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(paramObject.bearing));
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("latlng:");
    localStringBuilder.append(this.target.latitude);
    localStringBuilder.append(",");
    localStringBuilder.append(this.target.longitude);
    localStringBuilder.append(",zoom:");
    localStringBuilder.append(this.zoom);
    localStringBuilder.append(",tilt=");
    localStringBuilder.append(this.tilt);
    localStringBuilder.append(",bearing:");
    localStringBuilder.append(this.bearing);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.CameraPosition
 * JD-Core Version:    0.7.0.1
 */