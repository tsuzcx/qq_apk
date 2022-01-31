package com.tencent.mobileqq.mini.widget;

import akgd;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;

class MapContext$1
  extends akgd
{
  MapContext$1(MapContext paramMapContext, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, SensorEventListener paramSensorEventListener)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    QLog.w(MapContext.TAG, 1, "onConsecutiveFailure locate failed errCode：" + paramInt1 + " failCount:" + paramInt2);
    if (paramInt2 < 3) {
      return;
    }
    MapContext.access$002(this.this$0, null);
    SosoInterface.b(MapContext.access$700(this.this$0));
    MapContext.access$800(this.this$0).unregisterListener(this.val$sensorEventListener);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(MapContext.TAG, 2, "onLocationFinish errCode=" + paramInt);
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.a;
      MapContext.access$002(this.this$0, new LatLng(paramSosoLbsInfo.a, paramSosoLbsInfo.b));
      if (MapContext.access$100(this.this$0) == null)
      {
        paramSosoLbsInfo = BitmapDescriptorFactory.fromBitmap(MapContext.access$200(this.this$0));
        MarkerOptions localMarkerOptions = new MarkerOptions();
        localMarkerOptions.icon(paramSosoLbsInfo);
        MapContext.access$102(this.this$0, MapContext.access$300(this.this$0).addMarker(localMarkerOptions));
      }
      MapContext.access$100(this.this$0).setPosition(MapContext.access$000(this.this$0));
      MapContext.access$100(this.this$0).setVisible(MapContext.access$400(this.this$0));
      if (MapContext.access$500(this.this$0)) {
        MapContext.access$600(this.this$0, MapContext.access$000(this.this$0).getLatitude(), MapContext.access$000(this.this$0).getLongitude());
      }
      return;
    }
    QLog.w(MapContext.TAG, 1, "handleNativeRequest locate failed errCode：" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MapContext.1
 * JD-Core Version:    0.7.0.1
 */