package com.tencent.tencentmap.mapsdk.map;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.raster.model.TileOverlay;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.rastercore.b.d;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.c;
import com.tencent.mapsdk.rastercore.d.g;
import com.tencent.mapsdk.rastercore.tile.MapTile.MapSource;

public class TencentMap
{
  private static OnErrorListener onErrorListener;
  private com.tencent.mapsdk.rastercore.d.a contentLayer;
  private com.tencent.mapsdk.rastercore.d.f mapContext;
  private c projection;
  
  public TencentMap(com.tencent.mapsdk.rastercore.d.f paramf)
  {
    this.mapContext = paramf;
    this.contentLayer = paramf.e();
    this.projection = paramf.b();
  }
  
  private void changeCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback)
  {
    if ((!this.mapContext.f().k()) || (paramLong < 0L)) {
      paramCameraUpdate.getCameraUpdateFactoryDelegate().a(false);
    }
    paramCameraUpdate.getCameraUpdateFactoryDelegate().a(paramCancelableCallback);
    paramCameraUpdate.getCameraUpdateFactoryDelegate().a(paramLong);
    this.mapContext.c().a(paramCameraUpdate.getCameraUpdateFactoryDelegate());
  }
  
  public static OnErrorListener getErrorListener()
  {
    return onErrorListener;
  }
  
  private boolean setBounds(LatLngBounds paramLatLngBounds)
  {
    return this.projection.a(paramLatLngBounds);
  }
  
  public static void setErrorListener(OnErrorListener paramOnErrorListener)
  {
    onErrorListener = paramOnErrorListener;
  }
  
  private void setMaxZoomLevel(int paramInt)
  {
    this.projection.c(paramInt);
  }
  
  private void setMinZoomLevel(int paramInt)
  {
    this.projection.d(paramInt);
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    return new Circle(this.contentLayer.a(paramCircleOptions));
  }
  
  public GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    return new GroundOverlay(this.contentLayer.a(paramGroundOverlayOptions));
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    return new Marker(this.contentLayer.a(paramMarkerOptions));
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    return new Polygon(this.contentLayer.a(paramPolygonOptions));
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    return new Polyline(this.contentLayer.a(paramPolylineOptions));
  }
  
  public TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
  {
    return new TileOverlay(this.mapContext.g().a(paramTileOverlayOptions));
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate)
  {
    changeCamera(paramCameraUpdate, 1000L, null);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, CancelableCallback paramCancelableCallback)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = 0L;
    }
    changeCamera(paramCameraUpdate, l, paramCancelableCallback);
  }
  
  public void animateCamera(CameraUpdate paramCameraUpdate, CancelableCallback paramCancelableCallback)
  {
    changeCamera(paramCameraUpdate, 1000L, paramCancelableCallback);
  }
  
  public void animateTo(LatLng paramLatLng)
  {
    changeCamera(CameraUpdateFactory.newLatLng(paramLatLng), 1000L, null);
  }
  
  public void animateTo(LatLng paramLatLng, long paramLong, CancelableCallback paramCancelableCallback)
  {
    changeCamera(CameraUpdateFactory.newLatLng(paramLatLng), paramLong, paramCancelableCallback);
  }
  
  public void animateTo(LatLng paramLatLng, final Runnable paramRunnable)
  {
    changeCamera(CameraUpdateFactory.newLatLng(paramLatLng), 1000L, new CancelableCallback()
    {
      public void onCancel()
      {
        paramRunnable.run();
      }
      
      public void onFinish()
      {
        paramRunnable.run();
      }
    });
  }
  
  public final void clearAllOverlays()
  {
    this.contentLayer.a();
    this.mapContext.a(false, false);
  }
  
  public boolean clearCache()
  {
    return (com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.WORLD)) && (com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.TENCENT)) && (com.tencent.mapsdk.rastercore.tile.a.a.a().a(MapTile.MapSource.SATELLITE));
  }
  
  public LatLng getMapCenter()
  {
    return this.projection.d().getTarget();
  }
  
  public int getMaxZoomLevel()
  {
    return this.projection.i().a();
  }
  
  public int getMinZoomLevel()
  {
    return this.projection.j().a();
  }
  
  public void getScreenShot(OnScreenShotListener paramOnScreenShotListener)
  {
    this.mapContext.a(paramOnScreenShotListener);
  }
  
  public void getScreenShot(OnScreenShotListener paramOnScreenShotListener, Rect paramRect)
  {
    this.mapContext.a(paramOnScreenShotListener, paramRect);
  }
  
  public final String getVersion()
  {
    return "1.3.1.3";
  }
  
  public int getZoomLevel()
  {
    return (int)this.projection.d().getZoom();
  }
  
  public final boolean isAppKeyAvailable()
  {
    return com.tencent.mapsdk.rastercore.d.f.p();
  }
  
  public boolean isHandDrawMapEnable()
  {
    if (this.mapContext == null) {
      return false;
    }
    return this.mapContext.r();
  }
  
  public final boolean isSatelliteEnabled()
  {
    return this.mapContext.l() == 2;
  }
  
  public boolean isTrafficEnabled()
  {
    return this.mapContext.i().a();
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    if (paramCameraUpdate != null)
    {
      paramCameraUpdate = paramCameraUpdate.getCameraUpdateFactoryDelegate();
      if (paramCameraUpdate != null)
      {
        paramCameraUpdate.a(false);
        this.mapContext.c().a(paramCameraUpdate);
      }
    }
  }
  
  public void removeOverlay(IOverlay paramIOverlay)
  {
    if (paramIOverlay == null) {
      return;
    }
    paramIOverlay.remove();
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2)
  {
    changeCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), 1000L, null);
  }
  
  public void scrollBy(float paramFloat1, float paramFloat2, long paramLong, CancelableCallback paramCancelableCallback)
  {
    changeCamera(CameraUpdateFactory.scrollBy(paramFloat1, paramFloat2), paramLong, paramCancelableCallback);
  }
  
  public void setCenter(LatLng paramLatLng)
  {
    changeCamera(CameraUpdateFactory.newLatLngZoom(paramLatLng, getZoomLevel()), 0L, null);
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    if (this.mapContext != null) {
      this.mapContext.g(paramBoolean);
    }
  }
  
  public void setInfoWindowAdapter(InfoWindowAdapter paramInfoWindowAdapter)
  {
    this.mapContext.h().a(paramInfoWindowAdapter);
  }
  
  public void setLanguage(QMapLanguage paramQMapLanguage)
  {
    com.tencent.mapsdk.rastercore.d.f.a(QMapLanguage.getLanguageCode(paramQMapLanguage));
    this.mapContext.a(true, true);
  }
  
  public void setOnInfoWindowClickListener(OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    this.mapContext.h().a(paramOnInfoWindowClickListener);
  }
  
  public void setOnMapCameraChangeListener(OnMapCameraChangeListener paramOnMapCameraChangeListener)
  {
    this.mapContext.h().a(paramOnMapCameraChangeListener);
  }
  
  public void setOnMapClickListener(OnMapClickListener paramOnMapClickListener)
  {
    this.mapContext.h().a(paramOnMapClickListener);
  }
  
  public void setOnMapLoadedListener(OnMapLoadedListener paramOnMapLoadedListener)
  {
    this.mapContext.c().a(paramOnMapLoadedListener);
  }
  
  public void setOnMapLongClickListener(OnMapLongClickListener paramOnMapLongClickListener)
  {
    this.mapContext.h().a(paramOnMapLongClickListener);
  }
  
  public void setOnMarkerClickListener(OnMarkerClickListener paramOnMarkerClickListener)
  {
    this.mapContext.h().a(paramOnMarkerClickListener);
  }
  
  public void setOnMarkerDraggedListener(OnMarkerDraggedListener paramOnMarkerDraggedListener)
  {
    this.mapContext.h().a(paramOnMarkerDraggedListener);
  }
  
  public void setSatelliteEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mapContext.a(2);
      return;
    }
    this.mapContext.a(1);
  }
  
  public void setTrafficEnabled(boolean paramBoolean)
  {
    this.mapContext.i().a(paramBoolean);
  }
  
  public void setZoom(int paramInt)
  {
    changeCamera(CameraUpdateFactory.zoomTo(paramInt), 0L, null);
  }
  
  public void stopAnimation()
  {
    this.mapContext.d().stopAnimation();
  }
  
  public void zoomIn()
  {
    changeCamera(CameraUpdateFactory.zoomIn(), 1000L, null);
  }
  
  public void zoomInFixing(int paramInt1, int paramInt2)
  {
    changeCamera(CameraUpdateFactory.zoomBy(1.0F, new Point(paramInt1, paramInt2)), 1000L, null);
  }
  
  public void zoomOut()
  {
    changeCamera(CameraUpdateFactory.zoomOut(), 1000L, null);
  }
  
  public void zoomOutFixing(int paramInt1, int paramInt2)
  {
    changeCamera(CameraUpdateFactory.zoomBy(-1.0F, new Point(paramInt1, paramInt2)), 1000L, null);
  }
  
  public void zoomToSpan(double paramDouble1, double paramDouble2)
  {
    zoomToSpan(new LatLng(getMapCenter().getLatitude() - paramDouble1 / 2.0D, getMapCenter().getLongitude() + paramDouble2 / 2.0D), new LatLng(getMapCenter().getLatitude() + paramDouble1 / 2.0D, getMapCenter().getLongitude() - paramDouble2 / 2.0D));
  }
  
  public void zoomToSpan(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    paramLatLng1 = new LatLngBounds.Builder().include(paramLatLng1).include(paramLatLng2).build();
    this.mapContext.c().a(CameraUpdateFactory.newLatLngBounds(paramLatLng1, 10).getCameraUpdateFactoryDelegate());
  }
  
  public static abstract interface InfoWindowAdapter
  {
    public abstract View getInfoWindow(Marker paramMarker);
    
    public abstract void onInfoWindowDettached(Marker paramMarker, View paramView);
  }
  
  public static abstract interface OnErrorListener
  {
    public abstract void collectErrorInfo(String paramString);
  }
  
  public static abstract interface OnInfoWindowClickListener
  {
    public abstract void onInfoWindowClick(Marker paramMarker);
  }
  
  public static abstract interface OnMapCameraChangeListener
  {
    public abstract void onCameraChange(CameraPosition paramCameraPosition);
    
    public abstract void onCameraChangeFinish(CameraPosition paramCameraPosition);
  }
  
  public static abstract interface OnMapClickListener
  {
    public abstract void onMapClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMapLoadedListener
  {
    public abstract void onMapLoaded();
  }
  
  public static abstract interface OnMapLongClickListener
  {
    public abstract void onMapLongClick(LatLng paramLatLng);
  }
  
  public static abstract interface OnMarkerClickListener
  {
    public abstract boolean onMarkerClick(Marker paramMarker);
  }
  
  public static abstract interface OnMarkerDraggedListener
  {
    public abstract void onMarkerDrag(Marker paramMarker);
    
    public abstract void onMarkerDragEnd(Marker paramMarker);
    
    public abstract void onMarkerDragStart(Marker paramMarker);
  }
  
  public static abstract interface OnScreenShotListener
  {
    public abstract void onMapScreenShot(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.TencentMap
 * JD-Core Version:    0.7.0.1
 */