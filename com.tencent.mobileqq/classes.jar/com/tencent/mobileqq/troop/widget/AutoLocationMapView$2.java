package com.tencent.mobileqq.troop.widget;

import android.os.Handler;
import android.os.Message;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class AutoLocationMapView$2
  extends SosoInterfaceOnLocationListener
{
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AutoLocationMapView", 2, "onLocationFinish() errCode=" + paramInt);
    }
    Message localMessage = this.a.a.obtainMessage(1);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramSosoLbsInfo = new GeoPoint((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      localMessage.arg1 = 0;
      localMessage.obj = paramSosoLbsInfo;
    }
    for (;;)
    {
      localMessage.sendToTarget();
      return;
      localMessage.arg2 = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView.2
 * JD-Core Version:    0.7.0.1
 */