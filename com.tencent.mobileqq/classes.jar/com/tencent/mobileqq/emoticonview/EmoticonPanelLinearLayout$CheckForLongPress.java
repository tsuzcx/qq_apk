package com.tencent.mobileqq.emoticonview;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import appt;
import appw;

class EmoticonPanelLinearLayout$CheckForLongPress
  implements Runnable
{
  int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  
  public EmoticonPanelLinearLayout$CheckForLongPress(EmoticonPanelLinearLayout paramEmoticonPanelLinearLayout, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = EmoticonPanelLinearLayout.b(this.this$0);
  }
  
  public void run()
  {
    if ((this.this$0.getParent() != null) && (this.jdField_a_of_type_Int == EmoticonPanelLinearLayout.a(this.this$0)) && (this.this$0.jdField_a_of_type_AndroidViewView != null))
    {
      appw localappw = (appw)this.this$0.jdField_a_of_type_AndroidViewView.getTag();
      if (localappw != null)
      {
        if ((this.this$0.jdField_a_of_type_Appt != null) && (this.this$0.jdField_a_of_type_Appt.a(localappw))) {
          break label134;
        }
        this.this$0.d = true;
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        this.this$0.sendAccessibilityEvent(2);
        if (EmoticonPanelLinearLayout.a(this.this$0, localappw)) {
          this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView, localappw);
        }
      }
    }
    return;
    label134:
    this.this$0.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */