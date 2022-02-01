package com.tencent.qqcamerakit.capture.cameraextend;

import android.graphics.Rect;
import com.tencent.qqcamerakit.capture.CameraProxy.CameraAutoFocusCallBack;

public class FocusOperator$CameraFocusParams
{
  public float a;
  public float b;
  public int c;
  public int d;
  public int e;
  public boolean f = false;
  public CameraProxy.CameraAutoFocusCallBack g;
  public Rect h;
  public Rect i;
  public boolean j;
  
  public FocusOperator$CameraFocusParams() {}
  
  public FocusOperator$CameraFocusParams(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean a()
  {
    return (this.d > 0) && (this.c > 0) && (this.a > 0.01F) && (this.b > 0.01F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqcamerakit.capture.cameraextend.FocusOperator.CameraFocusParams
 * JD-Core Version:    0.7.0.1
 */