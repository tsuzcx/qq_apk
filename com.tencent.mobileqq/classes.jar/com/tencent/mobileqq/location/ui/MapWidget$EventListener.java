package com.tencent.mobileqq.location.ui;

import android.graphics.Point;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;

public abstract interface MapWidget$EventListener
{
  public abstract void a(LocationRoom.Venue paramVenue);
  
  public abstract void a(LatLng paramLatLng);
  
  public abstract void a(LatLng paramLatLng, float paramFloat, List<String> paramList);
  
  public abstract void a(boolean paramBoolean, Point paramPoint);
  
  public abstract void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.EventListener
 * JD-Core Version:    0.7.0.1
 */