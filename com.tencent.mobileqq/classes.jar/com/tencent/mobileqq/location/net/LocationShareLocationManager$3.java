package com.tencent.mobileqq.location.net;

import com.tencent.map.geolocation.TencentDirectionListener;

class LocationShareLocationManager$3
  implements TencentDirectionListener
{
  LocationShareLocationManager$3(LocationShareLocationManager paramLocationShareLocationManager) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (LocationShareLocationManager.b(this.a) != null)
    {
      LocationShareLocationManager.a(this.a, paramDouble + 180.0D);
      LocationShareLocationManager.a().a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationShareLocationManager.3
 * JD-Core Version:    0.7.0.1
 */