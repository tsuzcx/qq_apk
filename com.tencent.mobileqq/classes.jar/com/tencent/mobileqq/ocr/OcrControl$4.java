package com.tencent.mobileqq.ocr;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.io.File;
import java.util.HashMap;

class OcrControl$4
  implements Runnable
{
  OcrControl$4(OcrControl paramOcrControl, ARCloudReqFileInfo paramARCloudReqFileInfo) {}
  
  public void run()
  {
    long l1 = new File(this.a.a).length() / 1024L;
    long l2 = new File(this.a.e).length() / 1024L;
    HashMap localHashMap = new HashMap();
    localHashMap.put("ocrFilesize", String.valueOf(l1));
    localHashMap.put("previewFilesize", String.valueOf(l2));
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "ocr_pic_size", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.4
 * JD-Core Version:    0.7.0.1
 */