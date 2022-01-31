package com.tencent.tencentmap.mapsdk.map;

import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.d.e;

public class MapFragmentUtil
{
  UiSettings mUi;
  MapView mapView;
  TencentMap tencentMap;
  
  public MapFragmentUtil(QSupportMapFragment paramQSupportMapFragment)
  {
    this.mapView = paramQSupportMapFragment.getMapView();
    this.mUi = this.mapView.getUiSettings();
    this.tencentMap = this.mapView.getMap();
    this.mUi.setLogoPosition(1);
    setScaleControlsEnable(true);
    this.mUi.setScaleViewPosition(0);
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    return this.mapView.addCircle(paramCircleOptions);
  }
  
  public GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    return this.mapView.getMap().addGroundOverlay(paramGroundOverlayOptions);
  }
  
  public Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    paramMarkerOptions = this.mapView.addMarker(paramMarkerOptions);
    invalidate();
    return paramMarkerOptions;
  }
  
  public GroundOverlay addOverlay(BitmapDescriptor paramBitmapDescriptor, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return this.mapView.addOverlay(paramBitmapDescriptor.getBitmap(), paramLatLng1, paramLatLng2);
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    return this.mapView.addPolygon(paramPolygonOptions);
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    return this.mapView.addPolyline(paramPolylineOptions);
  }
  
  public void clearAllOverlays()
  {
    this.mapView.clearAllOverlays();
  }
  
  public int getLatitudeSpan()
  {
    return this.mapView.getLatitudeSpan();
  }
  
  public int getLongitudeSpan()
  {
    return this.mapView.getLongitudeSpan();
  }
  
  public LatLng getMapCenter()
  {
    return this.mapView.getMapCenter();
  }
  
  public MapController getMapController()
  {
    return this.mapView.getController();
  }
  
  public float getScalePerPixel()
  {
    return this.mapView.getScalePerPixel();
  }
  
  public int getZoomLevel()
  {
    return this.tencentMap.getZoomLevel();
  }
  
  public void invalidate()
  {
    this.mapView.getMapContext().a(false, false);
  }
  
  public boolean isSatellite()
  {
    return this.tencentMap.isSatelliteEnabled();
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    this.mapView.moveCamera(paramCameraUpdate);
  }
  
  public void postInvalidate()
  {
    refreshMap();
  }
  
  public void refreshMap()
  {
    this.mapView.getMapContext().a(false, false);
  }
  
  public void removeOverlay(IOverlay paramIOverlay)
  {
    this.mapView.removeOverlay(paramIOverlay);
  }
  
  public void setLogoPosition(int paramInt)
  {
    this.mUi.setLogoPosition(paramInt);
  }
  
  public void setPinchEnabeled(boolean paramBoolean)
  {
    this.mUi.setZoomGesturesEnabled(paramBoolean);
  }
  
  public void setSatellite(boolean paramBoolean)
  {
    this.tencentMap.setSatelliteEnabled(paramBoolean);
  }
  
  public void setScaleControlsEnable(boolean paramBoolean)
  {
    this.mUi.setScaleControlsEnabled(paramBoolean);
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    this.mUi.setScaleViewPosition(paramInt);
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.mUi.setScrollGesturesEnabled(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapFragmentUtil
 * JD-Core Version:    0.7.0.1
 */