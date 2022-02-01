package com.tencent.mobileqq.location.ui;

import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;

class MapWidget$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  MapWidget$3(MapWidget paramMapWidget, LocationRoom.Venue paramVenue) {}
  
  public void onGlobalLayout()
  {
    this.b.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    if (this.a == null)
    {
      this.b.a(true, Float.valueOf(15.0F));
      return;
    }
    MapWidget.b(this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.3
 * JD-Core Version:    0.7.0.1
 */