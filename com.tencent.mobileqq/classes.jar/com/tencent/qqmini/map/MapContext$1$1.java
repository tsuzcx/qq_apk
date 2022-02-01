package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import org.json.JSONObject;

class MapContext$1$1
  implements AsyncResult
{
  MapContext$1$1(MapContext.1 param1) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      double d1 = paramJSONObject.optDouble("latitude");
      double d2 = paramJSONObject.optDouble("longitude");
      MapContext.access$102(this.a.this$0, new LatLng(Double.valueOf(d1).doubleValue(), Double.valueOf(d2).doubleValue()));
      if (MapContext.access$200(this.a.this$0) == null)
      {
        paramJSONObject = BitmapDescriptorFactory.fromBitmap(MapContext.access$300(this.a.this$0));
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.icon(paramJSONObject);
        MapContext.access$202(this.a.this$0, MapContext.access$400(this.a.this$0).addMarker(localMarkerOptions));
      }
      MapContext.access$200(this.a.this$0).setPosition(MapContext.access$100(this.a.this$0));
      MapContext.access$200(this.a.this$0).setVisible(MapContext.access$500(this.a.this$0));
      if (MapContext.access$600(this.a.this$0)) {
        MapContext.access$700(this.a.this$0, MapContext.access$100(this.a.this$0).getLatitude(), MapContext.access$100(this.a.this$0).getLongitude());
      }
    }
    else
    {
      QMLog.w(MapContext.TAG, "handleNativeRequest locate failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.map.MapContext.1.1
 * JD-Core Version:    0.7.0.1
 */