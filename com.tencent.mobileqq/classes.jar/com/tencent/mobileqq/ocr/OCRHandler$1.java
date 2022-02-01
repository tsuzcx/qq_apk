package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.qphone.base.util.QLog;

class OCRHandler$1
  implements ARCloudFileUpload.ARCloudFileUploadCallback
{
  public void a(int paramInt, String paramString, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.OCRHandler", 2, "picTranslate, retCode:" + paramInt + "sessionId:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.1
 * JD-Core Version:    0.7.0.1
 */