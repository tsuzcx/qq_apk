package com.tencent.mobileqq.kandian.biz.publisher;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class TroopBarPublishLocationSelectActivity$4
  extends SosoInterfaceOnLocationListener
{
  TroopBarPublishLocationSelectActivity$4(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish() errCode=");
      localStringBuilder.append(paramInt);
      QLog.d("TroopBarPublishLocationSelectActivity", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      double d1 = paramSosoLbsInfo.mLocation.mLat02;
      double d2 = paramSosoLbsInfo.mLocation.mLon02;
      paramSosoLbsInfo = this.a;
      paramSosoLbsInfo.a((int)(d1 * 1000000.0D), (int)(d2 * 1000000.0D), paramSosoLbsInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.publisher.TroopBarPublishLocationSelectActivity.4
 * JD-Core Version:    0.7.0.1
 */