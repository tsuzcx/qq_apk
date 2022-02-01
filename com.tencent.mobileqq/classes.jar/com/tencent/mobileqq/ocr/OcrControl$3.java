package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;

class OcrControl$3
  implements Runnable
{
  OcrControl$3(OcrControl paramOcrControl, String paramString, ARCloudReqFileInfo paramARCloudReqFileInfo) {}
  
  public void run()
  {
    ARCloudReqInfo localARCloudReqInfo = OcrControl.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    if ((localARCloudReqInfo != null) && (OcrControl.a(this.this$0) != null))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localARCloudReqInfo.c;
      OcrControl.a(this.this$0).a(4, null, this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqFileInfo.b, l1 - l2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.3
 * JD-Core Version:    0.7.0.1
 */