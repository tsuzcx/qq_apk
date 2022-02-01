package com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;

public class NewIdentifierCameraCaptureView
  extends QIdentifierCaptureView
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
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = ScreenUtil.getInstantScreenWidth(getContext());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.NewIdentifierCameraCaptureView
 * JD-Core Version:    0.7.0.1
 */