package com.tencent.mobileqq.ocr;

import ayzg;
import bdmc;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;

public class OcrCamera$5
  implements Runnable
{
  public OcrCamera$5(ayzg paramayzg, long paramLong) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("costTime", String.valueOf(this.a));
    bdmc.a(BaseApplicationImpl.getContext()).a("", "ocr_select_pic", true, 0L, 0L, localHashMap, "", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.5
 * JD-Core Version:    0.7.0.1
 */