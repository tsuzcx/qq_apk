package com.tencent.mobileqq.transfile;

import bhgy;
import com.tencent.mobileqq.highway.netprobe.WeakNetCallback;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

final class BaseTransProcessorStaticVariable$1
  implements WeakNetCallback
{
  private StatisticCollector reportor = StatisticCollector.getInstance(BaseApplication.getContext());
  
  public void onResultOverflow(HashMap<String, String> paramHashMap)
  {
    this.reportor.collectPerformance(bhgy.a(), "actWeaknetProbe", true, 0L, paramHashMap.size(), paramHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessorStaticVariable.1
 * JD-Core Version:    0.7.0.1
 */