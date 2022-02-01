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
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onLocationFinish() errCode=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AutoLocationMapView", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a.b.obtainMessage(1);
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      paramSosoLbsInfo = new GeoPoint((int)(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D), (int)(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      ((Message)localObject).arg1 = 0;
      ((Message)localObject).obj = paramSosoLbsInfo;
    }
    else
    {
      ((Message)localObject).arg2 = -1;
    }
    ((Message)localObject).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView.2
 * JD-Core Version:    0.7.0.1
 */