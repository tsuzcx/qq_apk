package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

public class UpScrollHideView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private UpScrollHideView.onViewHideListener jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener = null;
  private int b = 0;
  
  public UpScrollHideView(Context paramContext)
  {
    super(paramContext, null);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842880);
  }
  
  public UpScrollHideView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i != 0)
    {
      if (i != 1) {
        if (i != 2)
        {
          if (i != 3) {
            return true;
          }
        }
        else
        {
          i = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
          if (i == -1) {
            return true;
          }
          float f = paramMotionEvent.getY(i);
          this.b = ((int)(this.jdField_a_of_type_Float - f));
          i = this.b;
          if (i <= 0) {
            break label145;
          }
          scrollTo(0, i);
          return true;
        }
      }
      if (this.b > getHeight())
      {
        setVisibility(8);
        paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener;
        if (paramMotionEvent != null) {
          paramMotionEvent.a();
        }
      }
      else
      {
        scrollTo(0, 0);
      }
      this.jdField_a_of_type_Int = -1;
      return true;
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getY();
      this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
    }
    label145:
    return true;
  }
  
  public void setOnViewHideListener(UpScrollHideView.onViewHideListener paramonViewHideListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetUpScrollHideView$onViewHideListener = paramonViewHideListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UpScrollHideView
 * JD-Core Version:    0.7.0.1
 */