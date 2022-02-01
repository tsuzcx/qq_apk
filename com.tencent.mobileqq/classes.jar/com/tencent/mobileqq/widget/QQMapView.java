package com.tencent.mobileqq.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
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
  QQMapView.QQMapViewObserver a;
  GeoPoint b;
  protected boolean c = false;
  boolean d = false;
  private TencentMap.OnCameraChangeListener e;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.e = new QQMapView.2(this);
    getMap().setOnCameraChangeListener(this.e);
  }
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    this.e = new QQMapView.1(this);
    getMap().setOnCameraChangeListener(this.e);
  }
  
  private void a(CameraPosition paramCameraPosition)
  {
    if (this.d)
    {
      QLog.d("QQMapView", 1, "dismiss map scroll");
      this.d = false;
      return;
    }
    paramCameraPosition = new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D));
    Object localObject = this.b;
    if (localObject != null)
    {
      int i = Math.abs(((GeoPoint)localObject).getLatitudeE6() - paramCameraPosition.getLatitudeE6());
      int j = Math.abs(this.b.getLongitudeE6() - paramCameraPosition.getLongitudeE6());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealMapScroll() latScroll =");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" lngScroll =");
      ((StringBuilder)localObject).append(j);
      QLog.d("QQMapView", 2, ((StringBuilder)localObject).toString());
      if ((i == 0) || (j == 0)) {
        return;
      }
    }
    this.a.onMapScrollEnd(paramCameraPosition);
    this.c = false;
    this.b = paramCameraPosition;
  }
  
  public void a()
  {
    this.a = null;
    this.e = null;
  }
  
  public void b()
  {
    this.d = true;
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
  
  public void setObserver(QQMapView.QQMapViewObserver paramQQMapViewObserver)
  {
    this.a = paramQQMapViewObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQMapView
 * JD-Core Version:    0.7.0.1
 */