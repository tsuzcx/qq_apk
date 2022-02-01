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
      this.a.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D)));
      this.a.getMap().moveCamera(CameraUpdateFactory.zoomTo(this.a.getMap().getMaxZoomLevel()));
      Bitmap localBitmap = BitmapManager.a(this.a.getContext().getResources(), 2130842683);
      QQMapActivity.a(this.a.getMap().addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromBitmap(localBitmap)).snippet("").position(new LatLng(localGeoPoint.getLatitudeE6() / 1000000.0D, localGeoPoint.getLongitudeE6() / 1000000.0D))));
    }
    if (this.a.a != null) {
      this.a.a.a(paramMessage.arg1, localGeoPoint);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView.1
 * JD-Core Version:    0.7.0.1
 */