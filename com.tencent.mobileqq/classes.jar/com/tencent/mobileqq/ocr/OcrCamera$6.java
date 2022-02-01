package com.tencent.mobileqq.ocr;

import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;

class OcrCamera$6
  implements Camera.PreviewCallback
{
  OcrCamera$6(OcrCamera paramOcrCamera) {}
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if (((this.a.h) || (this.a.o == 1)) && (!OcrCamera.a(this.a)))
    {
      paramCamera = this.a;
      paramCamera.k = paramArrayOfByte;
      if ((paramCamera.o != 1) && (System.currentTimeMillis() - OcrCamera.b(this.a) > this.a.l))
      {
        OcrCamera.a(this.a, System.currentTimeMillis());
        OcrCamera.a(this.a, paramArrayOfByte);
      }
    }
    OcrCamera.c(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.6
 * JD-Core Version:    0.7.0.1
 */