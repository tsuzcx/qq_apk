package com.tencent.qqmini.map;

import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptor;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import org.json.JSONObject;

class MapContext$1
  implements AsyncResult
{
  MapContext$1(MapContext paramMapContext) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      double d1 = paramJSONObject.optDouble("latitude");
      double d2 = paramJSONObject.optDouble("longitude");
      MapContext.access$002(this.this$0, new LatLng(Double.valueOf(d1).doubleValue(), Double.valueOf(d2).doubleValue()));
      if (MapContext.access$100(this.this$0) == null)
      {
        Object localObject = BitmapDescriptorFactory.fromBitmap(MapContext.access$200(this.this$0));
        paramJSONObject = new MarkerOptions();
        paramJSONObject.icon((BitmapDescriptor)localObject);
        localObject = this.this$0;
        MapContext.access$102((MapContext)localObject, MapContext.access$300((MapContext)localObject).addMarker(paramJSONObject));
      }
      MapContext.access$100(this.this$0).setPosition(MapContext.access$000(this.this$0));
      MapContext.access$100(this.this$0).setVisible(MapContext.access$400(this.this$0));
      if (MapContext.access$500(this.this$0))
      {
        paramJSONObject = this.this$0;
        MapContext.access$600(paramJSONObject, MapContext.access$000(paramJSONObject).getLatitude(), MapContext.access$000(this.this$0).getLongitude());
      }
    }
    else
    {
      QMLog.w(MapContext.TAG, "handleNativeRequest locate failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.map.MapContext.1
 * JD-Core Version:    0.7.0.1
 */