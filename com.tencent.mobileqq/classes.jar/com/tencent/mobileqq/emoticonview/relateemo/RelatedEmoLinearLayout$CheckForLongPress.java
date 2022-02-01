package com.tencent.mobileqq.emoticonview.relateemo;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import asmu;

class RelatedEmoLinearLayout$CheckForLongPress
  implements Runnable
{
  int jdField_a_of_type_Int;
  private MotionEvent jdField_a_of_type_AndroidViewMotionEvent;
  
  public RelatedEmoLinearLayout$CheckForLongPress(RelatedEmoLinearLayout paramRelatedEmoLinearLayout, MotionEvent paramMotionEvent)
  {
    this.jdField_a_of_type_AndroidViewMotionEvent = paramMotionEvent;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Int = RelatedEmoLinearLayout.b(this.this$0);
  }
  
  public void run()
  {
    if ((this.this$0.getParent() != null) && (this.jdField_a_of_type_Int == RelatedEmoLinearLayout.a(this.this$0)) && (RelatedEmoLinearLayout.a(this.this$0) != null) && ((asmu)RelatedEmoLinearLayout.a(this.this$0).getTag() != null))
    {
      RelatedEmoLinearLayout.a(this.this$0, true);
      RelatedEmoLinearLayout.a(this.this$0).performLongClick();
      this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
      this.this$0.sendAccessibilityEvent(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.relateemo.RelatedEmoLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */