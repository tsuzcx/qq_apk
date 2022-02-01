package com.tencent.mobileqq.ocr;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.arcloud.ARCloudFileUpload.ARCloudFileUploadCallback;
import com.tencent.mobileqq.ar.arengine.ARCloudRecogResult;
import com.tencent.mobileqq.ar.arengine.ARCloudReqFileInfo;
import com.tencent.mobileqq.ar.arengine.ARCloudReqInfo;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult;
import com.tencent.mobileqq.ocr.data.ARCloudOcrResult.YoutuOcrResult;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.qphone.base.util.QLog;

class OcrControl$5
  implements ARCloudFileUpload.ARCloudFileUploadCallback
{
  OcrControl$5(OcrControl paramOcrControl) {}
  
  public void a(int paramInt, String paramString, ARCloudRecogResult paramARCloudRecogResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.control", 2, "retCode:" + paramInt + ",sessionId:" + paramString + ",recogResult:" + paramARCloudRecogResult);
    }
    paramString = OcrControl.a(this.a, paramString);
    long l = 0L;
    if (paramString != null) {
      l = System.currentTimeMillis() - paramString.c;
    }
    int k = -1;
    int m = -1;
    int i = m;
    int j = k;
    if (paramString != null)
    {
      i = m;
      j = k;
      if (paramString.a != null)
      {
        if ((paramInt != 0) || (paramARCloudRecogResult == null) || (paramARCloudRecogResult.a == null)) {
          break label282;
        }
        paramARCloudRecogResult = paramARCloudRecogResult.a;
        OcrRecogResult localOcrRecogResult = paramARCloudRecogResult.a();
        if (OcrControl.a(this.a) != null) {
          OcrControl.a(this.a).a(0, localOcrRecogResult, paramString.a.b, l);
        }
        if ((localOcrRecogResult != null) && ((this.a.a == 1) || (this.a.a == 2))) {
          ThreadManager.postImmediately(new OcrControl.5.1(this, localOcrRecogResult, paramString), null, false);
        }
        if (paramARCloudRecogResult.a == null) {
          break label334;
        }
        i = paramARCloudRecogResult.a.a;
        j = paramARCloudRecogResult.a.b;
      }
    }
    for (;;)
    {
      k = j;
      j = i;
      i = k;
      for (;;)
      {
        ThreadManager.postImmediately(new OcrControl.5.2(this, paramString), null, false);
        ThreadManager.post(new OcrControl.5.3(this, j, i, paramInt), 5, null, false);
        return;
        label282:
        i = m;
        j = k;
        if (OcrControl.a(this.a) != null)
        {
          OcrControl.a(this.a).a(3, null, paramString.a.b, l);
          i = m;
          j = k;
        }
      }
      label334:
      j = -1;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5
 * JD-Core Version:    0.7.0.1
 */