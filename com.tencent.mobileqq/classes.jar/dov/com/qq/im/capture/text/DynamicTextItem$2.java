package dov.com.qq.im.capture.text;

import android.view.View;
import blxk;

class DynamicTextItem$2
  implements Runnable
{
  DynamicTextItem$2(DynamicTextItem paramDynamicTextItem, boolean paramBoolean, View paramView, Runnable paramRunnable) {}
  
  public void run()
  {
    blxk localblxk;
    if (((Boolean)DynamicTextItem.a(this.this$0).b).booleanValue() != this.jdField_a_of_type_Boolean)
    {
      localblxk = DynamicTextItem.a(this.this$0);
      if (((Boolean)DynamicTextItem.a(this.this$0).b).booleanValue()) {
        break label93;
      }
    }
    label93:
    for (boolean bool = true;; bool = false)
    {
      localblxk.b = Boolean.valueOf(bool);
      this.jdField_a_of_type_AndroidViewView.invalidate();
      if (this.jdField_a_of_type_JavaLangRunnable != null) {
        this.jdField_a_of_type_JavaLangRunnable.run();
      }
      DynamicTextItem.a(this.this$0, false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextItem.2
 * JD-Core Version:    0.7.0.1
 */