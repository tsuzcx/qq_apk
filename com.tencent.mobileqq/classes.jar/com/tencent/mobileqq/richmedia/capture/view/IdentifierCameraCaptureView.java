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
  public IdentifierCameraCaptureView.OutPreviewCallback ae;
  
  public IdentifierCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public IdentifierCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(byte[] paramArrayOfByte, Camera paramCamera)
  {
    super.a(paramArrayOfByte, paramCamera);
    IdentifierCameraCaptureView.OutPreviewCallback localOutPreviewCallback = this.ae;
    if (localOutPreviewCallback != null) {
      localOutPreviewCallback.a(paramArrayOfByte, paramCamera);
    }
  }
  
  public int getPreviewHeight()
  {
    return this.f;
  }
  
  public int getPreviewWidth()
  {
    return this.e;
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    super.onDrawFrame(paramGL10);
  }
  
  public void setPreviewCallback(IdentifierCameraCaptureView.OutPreviewCallback paramOutPreviewCallback)
  {
    this.ae = paramOutPreviewCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */