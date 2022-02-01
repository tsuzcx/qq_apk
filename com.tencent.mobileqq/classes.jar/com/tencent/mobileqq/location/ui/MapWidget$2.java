package com.tencent.mobileqq.location.ui;

import android.graphics.Point;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;

class MapWidget$2
  implements TencentMapGestureListener
{
  private boolean jdField_a_of_type_Boolean = false;
  private volatile boolean b = false;
  
  MapWidget$2(MapWidget paramMapWidget) {}
  
  public boolean onDoubleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onDown(float paramFloat1, float paramFloat2)
  {
    this.b = true;
    if (MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget) != null) {
      MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget).a(false, new Point(Math.round(paramFloat1), Math.round(paramFloat2)));
    }
    return false;
  }
  
  public boolean onFling(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onLongPress(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public void onMapStable()
  {
    if ((this.b) && (MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget) != null)) {
      MapWidget.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget).a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a.getCameraPosition().target);
    }
    this.b = false;
  }
  
  public boolean onScroll(float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Boolean = true;
    return false;
  }
  
  public boolean onSingleTap(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  public boolean onUp(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ReportController.b(null, "CliOper", "", "", "0X800A772", "0X800A772", 0, 0, "", "0", "0", "");
      this.jdField_a_of_type_Boolean = false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.2
 * JD-Core Version:    0.7.0.1
 */