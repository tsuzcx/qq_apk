package com.tencent.mobileqq.kandian.repo.feeds;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class SelectPositionModule$1
  extends SosoInterfaceOnLocationListener
{
  SelectPositionModule$1(SelectPositionModule paramSelectPositionModule, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationFinish() errCode=");
      localStringBuilder.append(paramInt);
      QLog.d("SelectPositionModule", 2, localStringBuilder.toString());
    }
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null) && (!TextUtils.isEmpty(paramSosoLbsInfo.mLocation.city)))
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("onLocationFinish() info.mLocation =");
        localStringBuilder.append(paramSosoLbsInfo.mLocation);
        QLog.d("SelectPositionModule", 2, localStringBuilder.toString());
      }
      SelectPositionModule.a(this.a, new PositionData(paramSosoLbsInfo.mLocation));
      paramSosoLbsInfo = this.a;
      SelectPositionModule.b(paramSosoLbsInfo, SelectPositionModule.a(paramSosoLbsInfo));
      paramSosoLbsInfo = this.a;
      SelectPositionModule.c(paramSosoLbsInfo, SelectPositionModule.a(paramSosoLbsInfo));
      if (SelectPositionModule.b(this.a) != null) {
        SelectPositionModule.b(this.a).a(SelectPositionModule.a(this.a));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.SelectPositionModule.1
 * JD-Core Version:    0.7.0.1
 */