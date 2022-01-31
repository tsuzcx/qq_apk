package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.hardware.Camera;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import avvn;
import javax.microedition.khronos.opengles.GL10;

public class IdentifierCameraCaptureView
  extends CameraCaptureView
{
  public avvn a;
  
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
    if (this.a != null) {
      this.a.a(paramArrayOfByte, paramCamera);
    }
  }
  
  public void onDrawFrame(GL10 paramGL10)
  {
    super.onDrawFrame(paramGL10);
  }
  
  public void setPreviewCallback(avvn paramavvn)
  {
    this.a = paramavvn;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.IdentifierCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */