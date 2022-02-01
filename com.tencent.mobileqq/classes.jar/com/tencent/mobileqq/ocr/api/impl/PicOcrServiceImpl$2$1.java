package com.tencent.mobileqq.ocr.api.impl;

import com.tencent.mobileqq.ocr.req.OCRReqContext;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;

class PicOcrServiceImpl$2$1
  implements Runnable
{
  PicOcrServiceImpl$2$1(PicOcrServiceImpl.2 param2) {}
  
  public void run()
  {
    FileUtils.deleteFile(this.a.b.d);
    if (QLog.isColorLevel()) {
      QLog.d("PicOcrServiceImpl", 2, "clear path!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.PicOcrServiceImpl.2.1
 * JD-Core Version:    0.7.0.1
 */