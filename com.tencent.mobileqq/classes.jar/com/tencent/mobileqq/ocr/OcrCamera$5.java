package com.tencent.mobileqq.ocr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

class OcrCamera$5
  implements Runnable
{
  OcrCamera$5(OcrCamera paramOcrCamera, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("costTime", String.valueOf(this.a));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_select_pic", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.5
 * JD-Core Version:    0.7.0.1
 */