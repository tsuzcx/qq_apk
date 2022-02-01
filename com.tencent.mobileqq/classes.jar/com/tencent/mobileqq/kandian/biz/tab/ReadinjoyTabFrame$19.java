package com.tencent.mobileqq.kandian.biz.tab;

import android.os.Handler;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.PositionData;
import com.tencent.qphone.base.util.QLog;

class ReadinjoyTabFrame$19
  extends ReadInJoyObserver
{
  ReadinjoyTabFrame$19(ReadinjoyTabFrame paramReadinjoyTabFrame) {}
  
  public void a(int paramInt, PositionData paramPositionData)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationChanged changeType = ");
      localStringBuilder.append(paramInt);
      QLog.d("ReadInJoyTabFrame", 2, localStringBuilder.toString());
    }
    ReadinjoyTabFrame.a(this.a, paramInt, paramPositionData);
  }
  
  public void cI_()
  {
    super.cI_();
    if (ReadinjoyTabFrame.m(this.a) != null) {
      ReadinjoyTabFrame.m(this.a).post(new ReadinjoyTabFrame.19.1(this));
    }
  }
  
  public void cJ_()
  {
    QLog.d("ReadInJoyTabFrame", 2, "onHideChannel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.tab.ReadinjoyTabFrame.19
 * JD-Core Version:    0.7.0.1
 */