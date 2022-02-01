package com.tencent.qqmini.map;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
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
  static final String TAG = "QQMapView";
  public static boolean isSelectPoiListItem;
  private TencentMap.OnCameraChangeListener cameraChangeListener;
  protected boolean mIsScrolling = false;
  GeoPoint mLastPoint;
  QQMapView.QQMapViewObserver mObserver;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.cameraChangeListener = new QQMapView.2(this);
    getMap().setOnCameraChangeListener(this.cameraChangeListener);
  }
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    this.cameraChangeListener = new QQMapView.1(this);
    getMap().setOnCameraChangeListener(this.cameraChangeListener);
  }
  
  private void dealMapScroll(CameraPosition paramCameraPosition)
  {
    paramCameraPosition = new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D));
    Object localObject = this.mLastPoint;
    if (localObject != null)
    {
      int i = Math.abs(((GeoPoint)localObject).getLatitudeE6() - paramCameraPosition.getLatitudeE6());
      int j = Math.abs(this.mLastPoint.getLongitudeE6() - paramCameraPosition.getLongitudeE6());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("dealMapScroll() latScroll =");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(" lngScroll =");
      ((StringBuilder)localObject).append(j);
      QMLog.d("QQMapView", ((StringBuilder)localObject).toString());
      if ((i == 0) || (j == 0)) {
        return;
      }
    }
    if (!isSelectPoiListItem) {
      this.mObserver.onMapScrollEnd(paramCameraPosition);
    } else {
      isSelectPoiListItem = false;
    }
    this.mIsScrolling = false;
    this.mLastPoint = paramCameraPosition;
  }
  
  public void destroy()
  {
    this.mObserver = null;
    this.cameraChangeListener = null;
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
    this.mObserver = paramQQMapViewObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.QQMapView
 * JD-Core Version:    0.7.0.1
 */