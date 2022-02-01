package com.tencent.mobileqq.location.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;

class MapWidget$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  MapWidget$5(MapWidget paramMapWidget, ViewTreeObserver paramViewTreeObserver) {}
  
  public void onGlobalLayout()
  {
    this.a.removeGlobalOnLayoutListener(this);
    if (this.b.c != null)
    {
      MapWidget localMapWidget = this.b;
      MapWidget.a(localMapWidget, localMapWidget.c.getPoints());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.5
 * JD-Core Version:    0.7.0.1
 */