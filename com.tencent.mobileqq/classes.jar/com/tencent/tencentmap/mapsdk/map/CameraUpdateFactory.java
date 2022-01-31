package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.CameraPosition.Builder;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.rastercore.c.d;
import com.tencent.mapsdk.rastercore.c.f;
import com.tencent.mapsdk.rastercore.c.g;
import com.tencent.mapsdk.rastercore.c.h;
import com.tencent.mapsdk.rastercore.d.a;

public final class CameraUpdateFactory
{
  public static CameraUpdate newCameraPosition(CameraPosition paramCameraPosition)
  {
    return new CameraUpdate(d.a.a(paramCameraPosition));
  }
  
  public static CameraUpdate newLatLng(LatLng paramLatLng)
  {
    return new CameraUpdate(d.a.a(CameraPosition.builder().target(paramLatLng).build()));
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt)
  {
    return new CameraUpdate(d.a.a(paramLatLngBounds, 0, 0, paramInt));
  }
  
  public static CameraUpdate newLatLngBounds(LatLngBounds paramLatLngBounds, int paramInt1, int paramInt2, int paramInt3)
  {
    return new CameraUpdate(d.a.a(paramLatLngBounds, paramInt1, paramInt2, paramInt3));
  }
  
  public static CameraUpdate newLatLngZoom(LatLng paramLatLng, float paramFloat)
  {
    return new CameraUpdate(d.a.a(CameraPosition.builder().target(paramLatLng).zoom(paramFloat).build()));
  }
  
  public static CameraUpdate scrollBy(float paramFloat1, float paramFloat2)
  {
    d locald = new d();
    locald.a(paramFloat1);
    locald.b(paramFloat2);
    return new CameraUpdate(locald);
  }
  
  public static CameraUpdate zoomBy(float paramFloat)
  {
    return new CameraUpdate(d.a.a(paramFloat, null));
  }
  
  public static CameraUpdate zoomBy(float paramFloat, Point paramPoint)
  {
    return new CameraUpdate(d.a.a(paramFloat, paramPoint));
  }
  
  public static CameraUpdate zoomIn()
  {
    return new CameraUpdate(new f());
  }
  
  public static CameraUpdate zoomOut()
  {
    return new CameraUpdate(new g());
  }
  
  public static CameraUpdate zoomTo(float paramFloat)
  {
    h localh = new h();
    localh.a(paramFloat);
    return new CameraUpdate(localh);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.CameraUpdateFactory
 * JD-Core Version:    0.7.0.1
 */