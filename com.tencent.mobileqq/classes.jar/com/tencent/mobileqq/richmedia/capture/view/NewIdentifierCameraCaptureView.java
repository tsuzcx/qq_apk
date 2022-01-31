package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import azgq;

public class NewIdentifierCameraCaptureView
  extends IdentifierCameraCaptureView
{
  private float a = 0.75F;
  private float b = 0.55F;
  
  public NewIdentifierCameraCaptureView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public NewIdentifierCameraCaptureView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = azgq.b(getContext());
    paramInt2 = (int)(paramInt1 / this.a);
    setMeasuredDimension((int)(paramInt1 * this.b), (int)(paramInt2 * this.b));
  }
  
  public void setAspectRatio(float paramFloat)
  {
    this.a = paramFloat;
    requestLayout();
  }
  
  public void setSurfaceScale(float paramFloat)
  {
    this.b = paramFloat;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.NewIdentifierCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */