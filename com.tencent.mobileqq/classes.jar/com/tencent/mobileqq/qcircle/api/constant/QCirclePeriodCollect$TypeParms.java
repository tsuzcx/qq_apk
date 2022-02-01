package com.tencent.mobileqq.qcircle.api.constant;

import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class QCirclePeriodCollect$TypeParms
{
  private final ArrayList<Pair<String, Long>> mPeriodList = new ArrayList();
  
  public void record(String paramString1, String paramString2)
  {
    if (QCirclePeriodCollect.access$000()) {
      return;
    }
    paramString2 = new Pair(paramString2, Long.valueOf(System.currentTimeMillis()));
    this.mPeriodList.add(paramString2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("record type:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",period:");
    localStringBuilder.append((String)paramString2.first);
    localStringBuilder.append(",start :");
    localStringBuilder.append(paramString2.second);
    QLog.d("QCirclePeriodCollect", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.constant.QCirclePeriodCollect.TypeParms
 * JD-Core Version:    0.7.0.1
 */