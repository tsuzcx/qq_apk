package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

public class NewIdentifierCameraCaptureView
  extends QIdentifierCaptureView
{
  private float A = 0.75F;
  private float B = 0.55F;
  
  public NewIdentifierCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public NewIdentifierCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getPreviewHeight()
  {
    return this.d;
  }
  
  public int getPreviewWidth()
  {
    return this.c;
  }
  
  public void setAspectRatio(float paramFloat)
  {
    this.A = paramFloat;
    requestLayout();
  }
  
  public void setSurfaceScale(float paramFloat)
  {
    this.B = paramFloat;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.NewIdentifierCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */