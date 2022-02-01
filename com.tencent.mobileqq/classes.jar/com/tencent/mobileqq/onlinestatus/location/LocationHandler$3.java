package com.tencent.mobileqq.onlinestatus.location;

import com.tencent.map.geolocation.TencentDirectionListener;

class LocationHandler$3
  implements TencentDirectionListener
{
  LocationHandler$3(LocationHandler paramLocationHandler) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (LocationHandler.a(this.a) != null)
    {
      LocationHandler.a(this.a, paramDouble + 180.0D);
      LocationHandler.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.location.LocationHandler.3
 * JD-Core Version:    0.7.0.1
 */