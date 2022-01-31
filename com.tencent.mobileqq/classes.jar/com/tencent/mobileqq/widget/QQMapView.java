package com.tencent.mobileqq.widget;

import akwe;
import akwf;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.b;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.Overlay;

@SuppressLint({"HandlerLeak"})
public class QQMapView
  extends MapView
{
  public int a;
  public Handler a;
  public GeoPoint a;
  public QQMapView.QQMapViewObserver a;
  Runnable jdField_a_of_type_JavaLangRunnable = new akwf(this);
  public Thread a;
  boolean jdField_a_of_type_Boolean = false;
  public boolean b = false;
  public boolean c;
  public boolean d;
  protected boolean e;
  
  public QQMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidOsHandler = new akwe(this);
    this.jdField_a_of_type_JavaLangThread = ThreadManager.newFreeThread(this.jdField_a_of_type_JavaLangRunnable, "qqmapview_calculate_position", 8);
    this.jdField_a_of_type_JavaLangThread.setPriority(10);
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  public Message a(int paramInt, GeoPoint paramGeoPoint)
  {
    Message localMessage = new Message();
    localMessage.arg1 = paramInt;
    localMessage.obj = paramGeoPoint;
    return localMessage;
  }
  
  public void a(Overlay paramOverlay)
  {
    paramOverlay.remove();
    invalidateOverLay();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapView", 2, "removeQQverlay:" + paramOverlay.hashCode());
    }
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.jdField_a_of_type_Int += 1;
    if ((this.b) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver != null) && (this.jdField_a_of_type_JavaLangThread != null)) {
      synchronized (this.jdField_a_of_type_JavaLangThread)
      {
        this.jdField_a_of_type_JavaLangThread.notify();
        return;
      }
    }
  }
  
  public void destroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver = null;
    if (this.jdField_a_of_type_JavaLangThread != null)
    {
      this.jdField_a_of_type_JavaLangThread.interrupt();
      this.jdField_a_of_type_JavaLangThread = null;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      if ((this.c) && (this.e))
      {
        this.e = false;
        this.d = true;
        LatLng localLatLng = getMapCenter();
        this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint = new GeoPoint((int)(localLatLng.getLatitude() * 1000000.0D), (int)(localLatLng.getLongitude() * 1000000.0D));
        if ((this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver != null))
        {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver.b(this.jdField_a_of_type_ComTencentMapsdkRasterModelGeoPoint.Copy());
          continue;
          this.c = true;
          this.e = true;
          continue;
          this.c = false;
          computeScroll();
        }
      }
    }
  }
  
  public void invalidateOverLay()
  {
    getMapContext().c().invalidate();
    if (QLog.isColorLevel()) {
      QLog.d("QQMapView", 2, "invalidateOverLay");
    }
  }
  
  public void setObserver(QQMapView.QQMapViewObserver paramQQMapViewObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQMapView$QQMapViewObserver = paramQQMapViewObserver;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQMapView
 * JD-Core Version:    0.7.0.1
 */