package com.tencent.mobileqq.location.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class MapWidget$1$1
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  MapWidget$1$1(MapWidget.1 param1) {}
  
  public void onGlobalLayout()
  {
    this.a.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    CameraPosition localCameraPosition = this.a.a.a.getCameraPosition();
    if (localCameraPosition != null) {
      MapWidget.a(this.a.a).a(localCameraPosition.target);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.1.1
 * JD-Core Version:    0.7.0.1
 */