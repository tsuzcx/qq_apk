package com.tencent.mobileqq.statistics;

import bdmc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

final class FDStatsHooker$1
  implements Runnable
{
  FDStatsHooker$1(StringBuilder paramStringBuilder, HashMap paramHashMap) {}
  
  public void run()
  {
    if (System.currentTimeMillis() - FDStatsHooker.lastLogTime > 10000L)
    {
      QLog.d("FDStats", 1, this.jdField_a_of_type_JavaLangStringBuilder.toString());
      FDStatsHooker.lastLogTime = System.currentTimeMillis();
    }
    String str1 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("filePath");
    String str2 = (String)this.jdField_a_of_type_JavaUtilHashMap.get("method:");
    str1 = str1 + str2;
    if (!FDStatsHooker.access$000().containsKey(str1)) {
      if (Math.random() > 0.001D) {
        break label146;
      }
    }
    label146:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        bdmc.a(BaseApplicationImpl.getContext()).a(null, "actNotifyFDError", true, 0L, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
      }
      FDNative.a(FDNative.a() + 1);
      FDStatsHooker.access$000().put(str1, Integer.valueOf(1));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.FDStatsHooker.1
 * JD-Core Version:    0.7.0.1
 */