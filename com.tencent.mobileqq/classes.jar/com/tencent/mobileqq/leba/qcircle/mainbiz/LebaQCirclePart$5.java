package com.tencent.mobileqq.leba.qcircle.mainbiz;

import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
import com.tencent.qphone.base.util.QLog;

class LebaQCirclePart$5
  extends QCircleObserver
{
  LebaQCirclePart$5(LebaQCirclePart paramLebaQCirclePart) {}
  
  protected void onUpdateRedPoint(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleObserver onUpdateRedPoint ");
    localStringBuilder.append(paramInt);
    QLog.e("LebaQCirclePartImpl", 1, localStringBuilder.toString());
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.qcircle.mainbiz.LebaQCirclePart.5
 * JD-Core Version:    0.7.0.1
 */