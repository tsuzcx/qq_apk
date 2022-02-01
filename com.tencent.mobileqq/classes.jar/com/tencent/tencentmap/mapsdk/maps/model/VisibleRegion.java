package com.tencent.tencentmap.mapsdk.maps.model;

public final class VisibleRegion
{
  public final LatLng farLeft;
  public final LatLng farRight;
  public final LatLngBounds latLngBounds;
  public final LatLng nearLeft;
  public final LatLng nearRight;
  
  public VisibleRegion(LatLng paramLatLng1, LatLng paramLatLng2, LatLng paramLatLng3, LatLng paramLatLng4, LatLngBounds paramLatLngBounds)
  {
    this.nearLeft = paramLatLng1;
    this.nearRight = paramLatLng2;
    this.farLeft = paramLatLng3;
    this.farRight = paramLatLng4;
    this.latLngBounds = paramLatLngBounds;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof VisibleRegion)) {
      return false;
    }
    paramObject = (VisibleRegion)paramObject;
    return (this.nearLeft.equals(paramObject.nearLeft)) && (this.nearRight.equals(paramObject.nearRight)) && (this.farLeft.equals(paramObject.farLeft)) && (this.farRight.equals(paramObject.farRight)) && (this.latLngBounds.equals(paramObject.latLngBounds));
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("nearLeft");
    localStringBuilder.append(this.nearLeft);
    localStringBuilder.append("nearRight");
    localStringBuilder.append(this.nearRight);
    localStringBuilder.append("farLeft");
    localStringBuilder.append(this.farLeft);
    localStringBuilder.append("farRight");
    localStringBuilder.append(this.farRight);
    localStringBuilder.append("latLngBounds");
    localStringBuilder.append(this.latLngBounds);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion
 * JD-Core Version:    0.7.0.1
 */