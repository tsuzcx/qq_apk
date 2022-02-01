package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;

class OcrControl$5$1
  implements Runnable
{
  OcrControl$5$1(OcrControl.5 param5, OcrRecogResult paramOcrRecogResult, ARCloudReqInfo paramARCloudReqInfo) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqOcrOcrControl$5.a.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqOcrDataOcrRecogResult.filename = this.jdField_a_of_type_ComTencentMobileqqArArengineARCloudReqInfo.a.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.1
 * JD-Core Version:    0.7.0.1
 */