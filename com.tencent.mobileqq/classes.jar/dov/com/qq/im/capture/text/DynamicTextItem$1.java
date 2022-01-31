package dov.com.qq.im.capture.text;

import android.view.View;
import bjhn;

class DynamicTextItem$1
  implements Runnable
{
  DynamicTextItem$1(DynamicTextItem paramDynamicTextItem, View paramView) {}
  
  public void run()
  {
    bjhn localbjhn = DynamicTextItem.a(this.this$0);
    if (!((Boolean)DynamicTextItem.a(this.this$0).b).booleanValue()) {}
    for (boolean bool = true;; bool = false)
    {
      localbjhn.b = Boolean.valueOf(bool);
      this.a.invalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.DynamicTextItem.1
 * JD-Core Version:    0.7.0.1
 */