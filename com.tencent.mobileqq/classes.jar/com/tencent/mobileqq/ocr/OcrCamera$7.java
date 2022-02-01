package com.tencent.mobileqq.ocr;

import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;

class OcrCamera$7
  implements Camera.PictureCallback
{
  OcrCamera$7(OcrCamera paramOcrCamera) {}
  
  public void onPictureTaken(byte[] paramArrayOfByte, Camera paramCamera)
  {
    this.a.a(paramArrayOfByte, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.7
 * JD-Core Version:    0.7.0.1
 */