package com.tencent.mobileqq.ocr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class OcrControl$5$3
  implements Runnable
{
  OcrControl$5$3(OcrControl.5 param5, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ocr_sso_code", String.valueOf(this.a));
    localHashMap.put("ocr_code", String.valueOf(this.b));
    localHashMap.put("ret_code", String.valueOf(this.c));
    try
    {
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_server_fail", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("collectPerformance exception: ");
      localStringBuilder.append(localException.getMessage());
      QLog.d("Q.ocr.control", 1, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.3
 * JD-Core Version:    0.7.0.1
 */