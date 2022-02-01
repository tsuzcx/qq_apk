package com.tencent.mobileqq.widget;

import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class QQMapView$2
  implements TencentMap.OnCameraChangeListener
{
  QQMapView$2(QQMapView paramQQMapView) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    if ((this.a.a != null) && (!this.a.c))
    {
      QQMapView localQQMapView = this.a;
      localQQMapView.c = true;
      localQQMapView.a.onMapScrollStart(new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D)));
    }
  }
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if (this.a.c) {
      QQMapView.a(this.a, paramCameraPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQMapView.2
 * JD-Core Version:    0.7.0.1
 */