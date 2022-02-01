package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R.styleable;

public class VideoViewGroup
  extends FrameLayout
{
  private boolean a = true;
  private float b = 0.0F;
  private float c = 0.0F;
  
  public VideoViewGroup(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoViewGroup(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoViewGroup(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramAttributeSet);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.VideoViewGroup);
    this.b = paramAttributeSet.getFloat(1, 0.0F);
    this.c = paramAttributeSet.getFloat(0, 0.0F);
    paramAttributeSet.recycle();
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    requestLayout();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    View.MeasureSpec.getMode(paramInt1);
    View.MeasureSpec.getMode(paramInt2);
    if (this.a)
    {
      if (this.b == 1.0F)
      {
        f = this.c;
        if (f != 1.0F)
        {
          paramInt2 = (int)(i * f);
          super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
          setMeasuredDimension(i, paramInt2);
          return;
        }
      }
      float f = this.b;
      if ((f != 1.0F) && (this.c == 1.0F))
      {
        i = (int)(j * f);
        super.onMeasure(paramInt1, paramInt2);
        setMeasuredDimension(i, j);
        return;
      }
      if (this.b == 1.0F)
      {
        f = this.c;
        if (f == 1.0F)
        {
          paramInt2 = (int)(i * f);
          super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(paramInt2, 1073741824));
          setMeasuredDimension(i, paramInt2);
          return;
        }
      }
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void setCustomSize(float paramFloat1, float paramFloat2)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
    requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.VideoViewGroup
 * JD-Core Version:    0.7.0.1
 */