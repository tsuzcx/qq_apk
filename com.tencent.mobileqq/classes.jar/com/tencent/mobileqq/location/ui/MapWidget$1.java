package com.tencent.mobileqq.location.ui;

import android.view.ViewTreeObserver;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;

class MapWidget$1
  implements TencentMap.OnMapLoadedCallback
{
  MapWidget$1(MapWidget paramMapWidget) {}
  
  public void onMapLoaded()
  {
    LocationItem localLocationItem = this.a.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
    if (QLog.isColorLevel()) {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. selfItem: ", localLocationItem.a() });
    }
    if ((localLocationItem.a() != null) && (!MapUtils.a(this.a.getContext(), this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap, localLocationItem.a())))
    {
      this.a.a(false);
      this.a.setTag(-2147483648, null);
      if (QLog.isColorLevel()) {
        QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. success moveMapToSelfCenter selfItem: ", localLocationItem.a() });
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("MapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. failed moveMapToSelfCenter selfItem: ", localLocationItem.a() });
    }
    if (MapWidget.a(this.a) != null)
    {
      if (this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition() == null)
      {
        this.a.getViewTreeObserver().addOnGlobalLayoutListener(new MapWidget.1.1(this));
        return;
      }
      MapWidget.a(this.a).a(this.a.jdField_a_of_type_ComTencentTencentmapMapsdkMapsTencentMap.getCameraPosition().target);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.MapWidget.1
 * JD-Core Version:    0.7.0.1
 */