package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;
import avts;

public class RichNodeRootLayout
  extends LinearLayout
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private avts jdField_a_of_type_Avts;
  private boolean jdField_a_of_type_Boolean;
  
  public RichNodeRootLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public RichNodeRootLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public RichNodeRootLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext) {}
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_AndroidViewGestureDetector != null) {
      this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.jdField_a_of_type_Avts != null) {
      this.jdField_a_of_type_Avts.a();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      i = paramMotionEvent.getActionMasked();
      if (i != 0) {
        break label32;
      }
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    for (;;)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
      label32:
      if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  public void setDisableParentReturn(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setEventHandler(avts paramavts)
  {
    this.jdField_a_of_type_Avts = paramavts;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeRootLayout
 * JD-Core Version:    0.7.0.1
 */