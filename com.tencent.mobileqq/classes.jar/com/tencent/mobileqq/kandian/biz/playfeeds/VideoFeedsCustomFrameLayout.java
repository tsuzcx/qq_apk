package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class VideoFeedsCustomFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float;
  private boolean jdField_b_of_type_Boolean = false;
  
  public VideoFeedsCustomFrameLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public VideoFeedsCustomFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public VideoFeedsCustomFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Float = paramMotionEvent.getX();
    }
    else if ((paramMotionEvent.getAction() == 2) && (!this.jdField_a_of_type_Boolean) && (paramMotionEvent.getY() - this.jdField_a_of_type_Float > 300.0F) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_b_of_type_Boolean = true;
      return true;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsCustomFrameLayout
 * JD-Core Version:    0.7.0.1
 */