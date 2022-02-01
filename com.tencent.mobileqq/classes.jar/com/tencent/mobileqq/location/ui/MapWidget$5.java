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
    this.jdField_a_of_type_AndroidViewViewTreeObserver.removeGlobalOnLayoutListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a != null)
    {
      MapWidget localMapWidget = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
      MapWidget.a(localMapWidget, localMapWidget.a.getPoints());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.5
 * JD-Core Version:    0.7.0.1
 */