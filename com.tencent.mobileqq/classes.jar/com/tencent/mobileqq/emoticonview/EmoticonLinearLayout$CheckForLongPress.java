package com.tencent.mobileqq.emoticonview;

import android.view.View;
import android.view.ViewParent;
import apuc;
import apuf;

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
    apuf localapuf;
    if ((this.this$0.getParent() != null) && (this.a == EmoticonLinearLayout.a(this.this$0)) && (this.this$0.jdField_a_of_type_AndroidViewView != null))
    {
      localapuf = (apuf)this.this$0.jdField_a_of_type_AndroidViewView.getTag();
      if (localapuf != null)
      {
        if ((this.this$0.jdField_a_of_type_Apuc != null) && (this.this$0.jdField_a_of_type_Apuc.a(localapuf))) {
          break label172;
        }
        this.this$0.jdField_a_of_type_Boolean = true;
        this.this$0.getParent().requestDisallowInterceptTouchEvent(true);
        this.this$0.sendAccessibilityEvent(2);
        if (!"delete".equals(localapuf.i)) {
          break label132;
        }
        this.this$0.jdField_a_of_type_JavaLangRunnable.run();
      }
    }
    label132:
    while (("setting".equals(localapuf.i)) || ("add".equals(localapuf.i))) {
      return;
    }
    this.this$0.a(this.this$0.jdField_a_of_type_AndroidViewView, localapuf);
    return;
    label172:
    this.this$0.jdField_a_of_type_AndroidViewView = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */