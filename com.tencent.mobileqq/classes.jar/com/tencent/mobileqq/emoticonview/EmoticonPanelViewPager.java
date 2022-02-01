package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.QQViewPager;

public class EmoticonPanelViewPager
  extends QQViewPager
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean;
  
  public EmoticonPanelViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public EmoticonPanelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
      this.jdField_c_of_type_Boolean = true;
      this.jdField_c_of_type_Int = 0;
      continue;
      this.jdField_c_of_type_Int = 0;
      this.jdField_c_of_type_Boolean = false;
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
    {
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        for (;;)
        {
          return super.onInterceptTouchEvent(paramMotionEvent);
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
        }
        this.jdField_b_of_type_Float = (paramMotionEvent.getX() - this.jdField_a_of_type_Float);
        this.jdField_a_of_type_Float = paramMotionEvent.getX();
      } while (((!this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Float <= 0.0F)) && ((!this.jdField_b_of_type_Boolean) || (this.jdField_b_of_type_Float >= 0.0F)));
      return false;
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    if ((!this.jdField_c_of_type_Boolean) || ((this.jdField_a_of_type_Int == 0) && (this.jdField_b_of_type_Int == 0)))
    {
      super.scrollTo(paramInt1, paramInt2);
      return;
    }
    int i = paramInt1;
    int j;
    if (getCurrentItem() == this.jdField_a_of_type_Int)
    {
      i = paramInt1;
      if (this.jdField_a_of_type_Int != 0)
      {
        i = paramInt1;
        if (this.jdField_a_of_type_Boolean)
        {
          j = getScrollX();
          this.jdField_c_of_type_Int = (paramInt1 - j + this.jdField_c_of_type_Int);
          i = paramInt1;
          if (this.jdField_c_of_type_Int < 0) {
            i = j;
          }
        }
      }
    }
    paramInt1 = i;
    if (getCurrentItem() == this.jdField_b_of_type_Int)
    {
      paramInt1 = i;
      if (this.jdField_b_of_type_Int != 0)
      {
        paramInt1 = i;
        if (this.jdField_b_of_type_Boolean)
        {
          j = getScrollX();
          this.jdField_c_of_type_Int = (i - j + this.jdField_c_of_type_Int);
          paramInt1 = i;
          if (this.jdField_c_of_type_Int > 0) {
            paramInt1 = j;
          }
        }
      }
    }
    super.scrollTo(paramInt1, paramInt2);
  }
  
  public void setLeftScrollDisEnable(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public void setNoScrollItem(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void setRightScrollDisEnable(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewPager
 * JD-Core Version:    0.7.0.1
 */