package com.tencent.mobileqq.mini.out.activity;

import android.graphics.Color;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

class MapActivity$2
  extends SosoInterfaceOnLocationListener
{
  MapActivity$2(MapActivity paramMapActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString, boolean paramBoolean5)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish errCode=");
      localStringBuilder.append(paramInt);
      QLog.d("MapActivity", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null))
    {
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation;
      this.this$0.fromLatLng = new LatLng(paramSosoLbsInfo.mLat02, paramSosoLbsInfo.mLon02);
      if (this.val$bMove) {
        this.this$0.map.moveCamera(CameraUpdateFactory.newLatLng(this.this$0.fromLatLng));
      }
      if (this.this$0.type == 2)
      {
        this.this$0.poiAdapter.reset();
        paramSosoLbsInfo = this.this$0;
        MapActivity.access$002(paramSosoLbsInfo, (int)(paramSosoLbsInfo.fromLatLng.getLatitude() * 1000000.0D));
        paramSosoLbsInfo = this.this$0;
        MapActivity.access$102(paramSosoLbsInfo, (int)(paramSosoLbsInfo.fromLatLng.getLongitude() * 1000000.0D));
        paramSosoLbsInfo = this.this$0;
        MapActivity.access$200(paramSosoLbsInfo, MapActivity.access$000(paramSosoLbsInfo), MapActivity.access$100(this.this$0));
      }
    }
    else
    {
      if (this.this$0.isFinishing()) {
        return;
      }
      this.this$0.dialog.setTitle(HardCodeUtil.a(2131904365)).setMessage(HardCodeUtil.a(2131904362)).setPositiveButton(HardCodeUtil.a(2131904363), Color.parseColor("#000000"), new MapActivity.2.2(this)).setNegativeButton(HardCodeUtil.a(2131901576), Color.parseColor("#000000"), new MapActivity.2.1(this));
      this.this$0.dialog.show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity.2
 * JD-Core Version:    0.7.0.1
 */