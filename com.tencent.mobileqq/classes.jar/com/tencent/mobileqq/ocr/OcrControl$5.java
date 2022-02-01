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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("retCode:");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(",sessionId:");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(",recogResult:");
      ((StringBuilder)localObject).append(paramARCloudRecogResult);
      QLog.d("Q.ocr.control", 2, ((StringBuilder)localObject).toString());
    }
    paramString = OcrControl.a(this.a, paramString);
    long l = 0L;
    if (paramString != null) {
      l = System.currentTimeMillis() - paramString.q;
    }
    int j = -1;
    int i;
    if ((paramString != null) && (paramString.b != null))
    {
      if ((paramInt == 0) && (paramARCloudRecogResult != null) && (paramARCloudRecogResult.g != null))
      {
        paramARCloudRecogResult = paramARCloudRecogResult.g;
        localObject = paramARCloudRecogResult.a();
        if (OcrControl.a(this.a) != null) {
          OcrControl.a(this.a).a(0, (OcrRecogResult)localObject, paramString.b.e, l);
        }
        if ((localObject != null) && ((this.a.f == 1) || (this.a.f == 2))) {
          ThreadManager.postImmediately(new OcrControl.5.1(this, (OcrRecogResult)localObject, paramString), null, false);
        }
        if (paramARCloudRecogResult.a != null)
        {
          j = paramARCloudRecogResult.a.a;
          i = paramARCloudRecogResult.a.c;
          break label278;
        }
      }
      else if (OcrControl.a(this.a) != null)
      {
        OcrControl.a(this.a).a(3, null, paramString.b.e, l);
      }
      i = -1;
      label278:
      ThreadManager.postImmediately(new OcrControl.5.2(this, paramString), null, false);
    }
    else
    {
      i = -1;
    }
    ThreadManager.post(new OcrControl.5.3(this, j, i, paramInt), 5, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5
 * JD-Core Version:    0.7.0.1
 */