package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import bewc;

public class UpScrollHideView
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private bewc jdField_a_of_type_Bewc;
  private int b;
  
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
    switch (paramMotionEvent.getAction() & 0xFF)
    {
    default: 
    case 0: 
    case 2: 
      for (;;)
      {
        return true;
        this.jdField_a_of_type_Float = paramMotionEvent.getY();
        this.jdField_a_of_type_Int = paramMotionEvent.getPointerId(0);
        continue;
        int i = paramMotionEvent.findPointerIndex(this.jdField_a_of_type_Int);
        if (i != -1)
        {
          float f = paramMotionEvent.getY(i);
          this.b = ((int)(this.jdField_a_of_type_Float - f));
          if (this.b > 0) {
            scrollTo(0, this.b);
          }
        }
      }
    }
    if (this.b > getHeight())
    {
      setVisibility(8);
      if (this.jdField_a_of_type_Bewc != null) {
        this.jdField_a_of_type_Bewc.a();
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      break;
      scrollTo(0, 0);
    }
  }
  
  public void setOnViewHideListener(bewc parambewc)
  {
    this.jdField_a_of_type_Bewc = parambewc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.UpScrollHideView
 * JD-Core Version:    0.7.0.1
 */