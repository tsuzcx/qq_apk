package com.tencent.mobileqq.ocr.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.qphone.base.util.QLog;

class OCRServiceImpl$3
  implements Runnable
{
  OCRServiceImpl$3(OCRServiceImpl paramOCRServiceImpl, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRServiceImpl", 2, "onGetOCRConfig ,excute runnable");
    }
    if ((this.a) && (this.this$0.mOcrConfig != null)) {
      synchronized (OCRServiceImpl.access$000(this.this$0))
      {
        if ((this.this$0.mOcrConfig != null) && (this.this$0.mApp != null)) {
          this.this$0.mOcrConfig.saveToFile(this.this$0.mApp.getCurrentAccountUin());
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */