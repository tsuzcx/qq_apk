package com.tencent.mobileqq.onlinestatus.location;

import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

public class LocationMapInfo
{
  private volatile CameraPosition a;
  private volatile boolean b;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(10);
    localStringBuilder.append("mLastCameraPosition:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" mMapZoomKey:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationMapInfo
 * JD-Core Version:    0.7.0.1
 */