package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

class AutoLocationMapView$1
  extends Handler
{
  AutoLocationMapView$1(AutoLocationMapView paramAutoLocationMapView) {}
  
  public void handleMessage(Message paramMessage)
  {
    GeoPoint localGeoPoint = (GeoPoint)paramMessage.obj;
    this.a.getMap().clear();
    if (paramMessage.arg1 == 0)
    {
      TencentMap localTencentMap = this.a.getMap();
      double d1 = localGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      double d2 = localGeoPoint.getLongitudeE6();
      Double.isNaN(d2);
      localTencentMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(d1, d2 / 1000000.0D)));
      this.a.getMap().moveCamera(CameraUpdateFactory.zoomTo(this.a.getMap().getMaxZoomLevel()));
      Object localObject = BitmapManager.a(this.a.getContext().getResources(), 2130843535);
      localTencentMap = this.a.getMap();
      localObject = new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap((Bitmap)localObject)).snippet("");
      d1 = localGeoPoint.getLatitudeE6();
      Double.isNaN(d1);
      d1 /= 1000000.0D;
      d2 = localGeoPoint.getLongitudeE6();
      Double.isNaN(d2);
      QQMapActivity.showInfoWindow(localTencentMap.addMarker(((MarkerOptions)localObject).position(new LatLng(d1, d2 / 1000000.0D))));
    }
    if (this.a.a != null) {
      this.a.a.a(paramMessage.arg1, localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView.1
 * JD-Core Version:    0.7.0.1
 */