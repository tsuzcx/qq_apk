package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import betv;
import betw;
import betx;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.MapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

@SuppressLint({"HandlerLeak"})
public class QQMapView
  extends MapView
{
  public static boolean b;
  public betx a;
  GeoPoint jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint;
  private TencentMap.OnCameraChangeListener jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnCameraChangeListener;
  public boolean a;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnCameraChangeListener = new betw(this);
    getMap().setOnCameraChangeListener(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnCameraChangeListener);
  }
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnCameraChangeListener = new betv(this);
    getMap().setOnCameraChangeListener(this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnCameraChangeListener);
  }
  
  private void a(CameraPosition paramCameraPosition)
  {
    paramCameraPosition = new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D));
    if (this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint != null)
    {
      int i = Math.abs(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLatitudeE6() - paramCameraPosition.getLatitudeE6());
      int j = Math.abs(this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint.getLongitudeE6() - paramCameraPosition.getLongitudeE6());
      QLog.d("QQMapView", 2, "dealMapScroll() latScroll =" + i + " lngScroll =" + j);
      if ((i == 0) || (j == 0)) {
        return;
      }
    }
    if (!b) {
      this.jdField_a_of_type_Betx.onMapScrollEnd(paramCameraPosition);
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentMapLibBasemapDataGeoPoint = paramCameraPosition;
      return;
      b = false;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Betx = null;
    this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap$OnCameraChangeListener = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    getParent().requestDisallowInterceptTouchEvent(true);
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setObserver(betx parambetx)
  {
    this.jdField_a_of_type_Betx = parambetx;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQMapView
 * JD-Core Version:    0.7.0.1
 */