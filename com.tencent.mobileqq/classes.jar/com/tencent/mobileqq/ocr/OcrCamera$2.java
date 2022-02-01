package com.tencent.mobileqq.ocr;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import com.hiar.sdk.camera.CameraParameters;

class OcrCamera$2
  implements Camera.AutoFocusCallback
{
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    this.a.c = false;
    if (paramBoolean) {}
    try
    {
      Camera.Parameters localParameters = paramCamera.getParameters();
      CameraParameters.a(localParameters);
      paramCamera.setParameters(localParameters);
      return;
    }
    catch (Exception paramCamera)
    {
      paramCamera.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrCamera.2
 * JD-Core Version:    0.7.0.1
 */