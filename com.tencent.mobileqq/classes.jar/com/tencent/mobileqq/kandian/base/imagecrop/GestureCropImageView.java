package com.tencent.mobileqq.kandian.base.imagecrop;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

public class GestureCropImageView
  extends CropImageView
{
  private ScaleGestureDetector k;
  private GestureDetector l;
  private float m;
  private float n;
  private boolean o = true;
  private boolean p = true;
  private boolean q = true;
  private int r = 5;
  
  public GestureCropImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GestureCropImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void e()
  {
    this.l = new GestureDetector(getContext(), new GestureCropImageView.GestureListener(this, null), null, true);
    this.k = new ScaleGestureDetector(getContext(), new GestureCropImageView.ScaleListener(this, null));
  }
  
  protected void d()
  {
    super.d();
    e();
  }
  
  public int getDoubleTapScaleSteps()
  {
    return this.r;
  }
  
  protected float getDoubleTapTargetScale()
  {
    return getCurrentScale() * (float)Math.pow(getMaxScale() / getMinScale(), 1.0F / this.r);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() & 0xFF) == 0) {
      a();
    }
    if (paramMotionEvent.getPointerCount() > 1)
    {
      this.m = ((paramMotionEvent.getX(0) + paramMotionEvent.getX(1)) / 2.0F);
      this.n = ((paramMotionEvent.getY(0) + paramMotionEvent.getY(1)) / 2.0F);
    }
    this.l.onTouchEvent(paramMotionEvent);
    if (this.p) {
      this.k.onTouchEvent(paramMotionEvent);
    }
    if ((paramMotionEvent.getAction() & 0xFF) == 1)
    {
      setImageToWrapCropBounds();
      setImageToLowerMaxScale();
    }
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setDoubleTapScaleSteps(int paramInt)
  {
    this.r = paramInt;
  }
  
  public void setIsDoubleTapEnabled(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setRotateEnabled(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setScaleEnabled(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.imagecrop.GestureCropImageView
 * JD-Core Version:    0.7.0.1
 */