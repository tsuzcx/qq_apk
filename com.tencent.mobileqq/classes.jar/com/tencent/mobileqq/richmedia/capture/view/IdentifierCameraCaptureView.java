package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import javax.microedition.khronos.opengles.GL10;

public class IdentifierCameraCaptureView
  extends CameraCaptureView
{
  public IdentifierCameraCaptureView.OutPreviewCallback a;
  
  public IdentifierCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public IdentifierCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    super.onDrawFrame(paramGL10);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    if (this.a != null) {
      this.a.a(paramArrayOfByte, paramCamera);
    }
  }
  
  public void setPreviewCallback(IdentifierCameraCaptureView.OutPreviewCallback paramOutPreviewCallback)
  {
    this.a = paramOutPreviewCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */