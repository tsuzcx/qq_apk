package com.tencent.mobileqq.mini.widget.media;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;

class CameraSurfaceView$1
  implements Camera.AutoFocusCallback
{
  CameraSurfaceView$1(CameraSurfaceView paramCameraSurfaceView) {}
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    paramCamera = CameraSurfaceView.access$000(this.this$0);
    this.this$0.setParamsFocusMode(paramCamera);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.media.CameraSurfaceView.1
 * JD-Core Version:    0.7.0.1
 */