package com.tencent.mobileqq.qqlive.prepare;

import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class QQLivePrepareFragment$2
  extends LbsManagerServiceOnLocationChangeListener
{
  QQLivePrepareFragment$2(QQLivePrepareFragment paramQQLivePrepareFragment, String paramString, boolean paramBoolean)
  {
    super(paramString, paramBoolean);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      if (!((LocationData)QQLivePrepareFragment.b(this.a).i.getValue()).equals(paramSosoLbsInfo.mLocation.city))
      {
        LocationData localLocationData = new LocationData();
        localLocationData.b = paramSosoLbsInfo.mLocation.city;
        localLocationData.c = String.valueOf(paramSosoLbsInfo.mLocation.mLat02);
        localLocationData.d = String.valueOf(paramSosoLbsInfo.mLocation.mLon02);
        localLocationData.a = true;
        QQLivePrepareFragment.b(this.a).i.setValue(localLocationData);
        QQLivePrepareFragment.b(this.a).a(localLocationData);
      }
    }
    else {
      QLog.d("QQLivePrepareFragment", 1, "the location is empty");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.QQLivePrepareFragment.2
 * JD-Core Version:    0.7.0.1
 */