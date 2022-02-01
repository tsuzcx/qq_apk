package com.tencent.qqmini.map;

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
    if ((this.this$0.mObserver != null) && (!this.this$0.mIsScrolling))
    {
      QQMapView localQQMapView = this.this$0;
      localQQMapView.mIsScrolling = true;
      localQQMapView.mObserver.onMapScrollStart(new GeoPoint((int)(paramCameraPosition.target.getLatitude() * 1000000.0D), (int)(paramCameraPosition.target.getLongitude() * 1000000.0D)));
    }
  }
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    if (this.this$0.mIsScrolling) {
      QQMapView.access$000(this.this$0, paramCameraPosition);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.map.QQMapView.2
 * JD-Core Version:    0.7.0.1
 */