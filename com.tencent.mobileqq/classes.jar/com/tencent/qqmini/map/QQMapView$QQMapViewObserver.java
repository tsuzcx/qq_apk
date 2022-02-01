package com.tencent.qqmini.map;

import com.tencent.map.lib.basemap.data.GeoPoint;

public abstract interface QQMapView$QQMapViewObserver
{
  public abstract void onMapScrollEnd(GeoPoint paramGeoPoint);
  
  public abstract void onMapScrollStart(GeoPoint paramGeoPoint);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.QQMapView.QQMapViewObserver
 * JD-Core Version:    0.7.0.1
 */