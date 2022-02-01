package com.tencent.mobileqq.multicard;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import axgd;

public class MultiCardCustomLayout
  extends RelativeLayout
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private View.OnLongClickListener jdField_a_of_type_AndroidViewView$OnLongClickListener;
  private boolean jdField_a_of_type_Boolean;
  
  public MultiCardCustomLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public MultiCardCustomLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewGestureDetector == null)) {
      this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(getContext(), new axgd(this), new Handler(Looper.getMainLooper()));
    }
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidViewView$OnLongClickListener != null) && (this.jdField_a_of_type_AndroidViewGestureDetector != null))
    {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
      switch (paramMotionEvent.getActionMasked())
      {
      default: 
        return true;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
      return true;
    }
    return bool;
  }
  
  public void setDispatchTouchEventOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = paramOnLongClickListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardCustomLayout
 * JD-Core Version:    0.7.0.1
 */