package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Point;
import android.graphics.PointF;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.VisibleRegion;
import com.tencent.mapsdk.rastercore.d.f;

public class Projection
{
  private f mapContext;
  private com.tencent.mapsdk.rastercore.d.c projection;
  
  public Projection(f paramf)
  {
    this.mapContext = paramf;
    this.projection = paramf.b();
  }
  
  public double distanceBetween(GeoPoint paramGeoPoint1, GeoPoint paramGeoPoint2)
  {
    return distanceBetween(com.tencent.mapsdk.rastercore.f.b.a(paramGeoPoint1), com.tencent.mapsdk.rastercore.f.b.a(paramGeoPoint2));
  }
  
  public double distanceBetween(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return com.tencent.mapsdk.rastercore.c.a(paramLatLng1, paramLatLng2);
  }
  
  public GeoPoint fromPixels(int paramInt1, int paramInt2)
  {
    return com.tencent.mapsdk.rastercore.f.b.a(this.projection.a(paramInt1, paramInt2));
  }
  
  public LatLng fromScreenLocation(Point paramPoint)
  {
    return this.projection.a(paramPoint.x, paramPoint.y);
  }
  
  public int getLatitudeSpan()
  {
    LatLngBounds localLatLngBounds = getVisibleRegion().getLatLngBounds();
    LatLng localLatLng = localLatLngBounds.getSouthwest();
    return (int)(localLatLngBounds.getNortheast().getLatitude() * 1000000.0D - localLatLng.getLatitude() * 1000000.0D);
  }
  
  public int getLongitudeSpan()
  {
    LatLngBounds localLatLngBounds = getVisibleRegion().getLatLngBounds();
    LatLng localLatLng = localLatLngBounds.getSouthwest();
    return (int)(localLatLngBounds.getNortheast().getLongitude() * 1000000.0D - localLatLng.getLongitude() * 1000000.0D);
  }
  
  public float getScalePerPixel()
  {
    return this.projection.f();
  }
  
  public VisibleRegion getVisibleRegion()
  {
    int i = this.mapContext.c().getWidth();
    int j = this.mapContext.c().getHeight();
    LatLng localLatLng1 = fromScreenLocation(new Point(0, 0));
    LatLng localLatLng2 = fromScreenLocation(new Point(i, 0));
    LatLng localLatLng3 = fromScreenLocation(new Point(0, j));
    LatLng localLatLng4 = fromScreenLocation(new Point(i, j));
    return new VisibleRegion(localLatLng3, localLatLng4, localLatLng1, localLatLng2, LatLngBounds.builder().include(localLatLng3).include(localLatLng4).include(localLatLng1).include(localLatLng2).build());
  }
  
  public float metersToEquatorPixels(float paramFloat)
  {
    return this.projection.a(paramFloat);
  }
  
  public float metersToPixels(double paramDouble1, double paramDouble2)
  {
    return this.projection.a(paramDouble1, paramDouble2);
  }
  
  public Point toPixels(GeoPoint paramGeoPoint, Point paramPoint)
  {
    Point localPoint = paramPoint;
    if (paramPoint == null) {
      localPoint = new Point();
    }
    paramGeoPoint = this.projection.a(com.tencent.mapsdk.rastercore.f.b.a(paramGeoPoint));
    localPoint.x = ((int)paramGeoPoint.x);
    localPoint.y = ((int)paramGeoPoint.y);
    return localPoint;
  }
  
  public Point toScreenLocation(LatLng paramLatLng)
  {
    paramLatLng = this.projection.a(paramLatLng);
    return new Point((int)paramLatLng.x, (int)paramLatLng.y);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.Projection
 * JD-Core Version:    0.7.0.1
 */