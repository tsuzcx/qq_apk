package com.tencent.tencentmap.mapsdk.maps;

import android.location.Location;
import com.tencent.map.sdk.a.lu.a;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

final class TencentMap$1
  implements lu.a
{
  TencentMap$1(TencentMap paramTencentMap) {}
  
  public final void a()
  {
    this.a.setMyLocationEnabled(true);
    Object localObject = this.a.getMyLocation();
    if (localObject != null)
    {
      localObject = new LatLng(((Location)localObject).getLatitude(), ((Location)localObject).getLongitude());
      this.a.animateCamera(CameraUpdateFactory.newLatLng((LatLng)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMap.1
 * JD-Core Version:    0.7.0.1
 */