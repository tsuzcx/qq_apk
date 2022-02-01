package com.tencent.mobileqq.location.window;

import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import java.util.List;

class FloatMapWidget$1
  implements TencentMap.OnMapLoadedCallback
{
  FloatMapWidget$1(FloatMapWidget paramFloatMapWidget) {}
  
  public void onMapLoaded()
  {
    Object localObject = FloatMapWidget.a(this.a).f();
    if (QLog.isColorLevel()) {
      QLog.d("FloatMapWidget", 2, new Object[] { "[map][init]onMapLoaded invoked. selfItem: ", ((LocationItem)localObject).a() });
    }
    if (((LocationItem)localObject).a() != null)
    {
      localObject = FloatMapWidget.b(this.a).a();
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapWidget", 2, new Object[] { "onMapLoaded: invoked. ", " venue: ", localObject });
      }
      if ((FloatMapWidget.c(this.a).j().size() == 1) && (localObject == null)) {
        this.a.a(false, null);
      } else {
        this.a.b();
      }
    }
    FloatMapWidget.a(this.a, true);
    FloatMapWidget.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.FloatMapWidget.1
 * JD-Core Version:    0.7.0.1
 */