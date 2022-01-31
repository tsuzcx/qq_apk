package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewParent;
import anyb;
import anyc;

class EmoticonLinearLayout$CheckForLongPress
  implements Runnable
{
  private int a;
  
  EmoticonLinearLayout$CheckForLongPress(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void a()
  {
    this.a = EmoticonLinearLayout.b(this.this$0);
  }
  
  public void run()
  {
    anyc localanyc;
    if ((this.this$0.getParent() != null) && (this.a == EmoticonLinearLayout.a(this.this$0)) && (this.this$0.jdField_a_of_type_AndroidViewView != null))
    {
      localanyc = (anyc)this.this$0.jdField_a_of_type_AndroidViewView.getTag();
      if (localanyc != null)
      {
        if ((this.this$0.jdField_a_of_type_Anyb != null) && (this.this$0.jdField_a_of_type_Anyb.a(localanyc))) {
          break label172;
        }
        this.this$0.jdField_a_of_type_Boolean = true;
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        this.this$0.sendAccessibilityEvent(2);
        if (!"delete".equals(localanyc.h)) {
          break label132;
        }
        this.this$0.jdField_a_of_type_JavaLangRunnable.run();
      }
    }
    label132:
    while (("setting".equals(localanyc.h)) || ("add".equals(localanyc.h))) {
      return;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView, localanyc);
    return;
    label172:
    this.this$0.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */