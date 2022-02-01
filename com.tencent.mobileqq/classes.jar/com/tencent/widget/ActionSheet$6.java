package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import blir;
import blje;

public class ActionSheet$6
  implements Runnable
{
  public ActionSheet$6(blir paramblir) {}
  
  public void run()
  {
    if (blir.a(this.this$0) != null) {
      blir.a(this.this$0).a();
    }
    blir.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, blir.a(this.this$0).getHeight(), 0.0F));
    blir.a(this.this$0).setFillEnabled(true);
    blir.a(this.this$0).setStartTime(300L);
    blir.a(this.this$0).setDuration(blir.a(this.this$0));
    blir.a(this.this$0, true);
    blir.a(this.this$0).startAnimation(blir.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.6
 * JD-Core Version:    0.7.0.1
 */