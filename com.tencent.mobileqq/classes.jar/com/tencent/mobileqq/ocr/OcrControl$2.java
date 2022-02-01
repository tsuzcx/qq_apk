package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import java.util.HashMap;

class OcrControl$2
  implements Runnable
{
  OcrControl$2(OcrControl paramOcrControl, String paramString) {}
  
  public void run()
  {
    if (((ARCloudReqInfo)this.this$0.a.get(this.a) != null) && (OcrControl.a(this.this$0) != null)) {
      OcrControl.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.2
 * JD-Core Version:    0.7.0.1
 */