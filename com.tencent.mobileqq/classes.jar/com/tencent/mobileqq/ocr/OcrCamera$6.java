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
    if (((this.a.jdField_a_of_type_Boolean) || (this.a.e == 1)) && (!OcrCamera.a(this.a)))
    {
      this.a.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
      if ((this.a.e != 1) && (System.currentTimeMillis() - OcrCamera.a(this.a) > this.a.c))
      {
        OcrCamera.a(this.a, System.currentTimeMillis());
        OcrCamera.a(this.a, paramArrayOfByte);
      }
    }
    OcrCamera.a(this.a).addCallbackBuffer(paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.6
 * JD-Core Version:    0.7.0.1
 */