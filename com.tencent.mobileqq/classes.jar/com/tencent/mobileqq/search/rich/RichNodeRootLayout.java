package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.LinearLayout;

public class RichNodeRootLayout
  extends LinearLayout
{
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private RichNodeRootLayout.RichNodeRootLayoutEvent jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout$RichNodeRootLayoutEvent;
  private boolean jdField_a_of_type_Boolean = false;
  
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
    GestureDetector localGestureDetector = this.jdField_a_of_type_AndroidViewGestureDetector;
    if (localGestureDetector != null) {
      localGestureDetector.onTouchEvent(paramMotionEvent);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    RichNodeRootLayout.RichNodeRootLayoutEvent localRichNodeRootLayoutEvent = this.jdField_a_of_type_ComTencentMobileqqSearchRichRichNodeRootLayout$RichNodeRootLayoutEvent;
    if (localRichNodeRootLayoutEvent != null) {
      localRichNodeRootLayoutEvent.a();
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      int i = paramMotionEvent.getActionMasked();
      if (i == 0) {
        getParent().requestDisallowInterceptTouchEvent(true);
      } else if ((i == 1) || (i == 3)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.RichNodeRootLayout
 * JD-Core Version:    0.7.0.1
 */