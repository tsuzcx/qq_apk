package com.tencent.mobileqq.location.net;

import com.tencent.map.geolocation.TencentDirectionListener;

class LocationHandler$5
  implements TencentDirectionListener
{
  LocationHandler$5(LocationHandler paramLocationHandler) {}
  
  public void onDirectionChanged(double paramDouble, int paramInt)
  {
    if (LocationHandler.a(this.a) != null)
    {
      LocationHandler.a(this.a, 180.0D + paramDouble);
      LocationHandler.a(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.net.LocationHandler.5
 * JD-Core Version:    0.7.0.1
 */