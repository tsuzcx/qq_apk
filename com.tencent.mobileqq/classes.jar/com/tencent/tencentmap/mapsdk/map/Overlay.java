package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Canvas;
import android.view.MotionEvent;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.e.c;

public class Overlay
  implements c
{
  protected static final float SHADOW_X_SKEW = -0.89F;
  protected static final float SHADOW_Y_SCALE = 0.5F;
  protected a contentLayer;
  protected String id = getId();
  protected boolean isVisible = true;
  protected f mapContext;
  protected MapView mapView;
  protected float zIndex = 0.0F;
  
  public boolean checkInBounds()
  {
    return false;
  }
  
  public void destroy() {}
  
  public void draw(Canvas paramCanvas)
  {
    draw(paramCanvas, this.mapView);
  }
  
  protected void draw(Canvas paramCanvas, MapView paramMapView) {}
  
  public boolean equalsRemote(c paramc)
  {
    return (equals(paramc)) || (paramc.getId().equals(getId()));
  }
  
  public String getId()
  {
    if (this.id == null) {
      this.id = a.a("Overlay");
    }
    return this.id;
  }
  
  public float getZIndex()
  {
    return this.zIndex;
  }
  
  public int hashCodeRemote()
  {
    return 0;
  }
  
  public void init(MapView paramMapView)
  {
    this.mapView = paramMapView;
    this.mapContext = paramMapView.getMapContext();
    this.contentLayer = this.mapContext.e();
  }
  
  public boolean isVisible()
  {
    return this.isVisible;
  }
  
  public void onEmptyTap(GeoPoint paramGeoPoint) {}
  
  public boolean onLongPress(GeoPoint paramGeoPoint, MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public void onRemoveOverlay() {}
  
  public boolean onTap(GeoPoint paramGeoPoint, MapView paramMapView)
  {
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, MapView paramMapView)
  {
    return false;
  }
  
  public void remove()
  {
    this.contentLayer.b(getId());
    onRemoveOverlay();
  }
  
  public void setVisible(boolean paramBoolean)
  {
    this.isVisible = paramBoolean;
    this.mapContext.a(false, false);
  }
  
  public void setZIndex(float paramFloat)
  {
    this.zIndex = paramFloat;
    this.contentLayer.c();
    this.mapContext.a(false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.Overlay
 * JD-Core Version:    0.7.0.1
 */