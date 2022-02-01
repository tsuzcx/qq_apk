package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import blir;
import bliw;

public class ActionSheet$7
  implements Runnable
{
  public ActionSheet$7(blir paramblir) {}
  
  public void run()
  {
    blir.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, blir.a(this.this$0).getHeight()));
    blir.a(this.this$0).setDuration(200L);
    blir.a(this.this$0).setFillAfter(true);
    blir.a(this.this$0).startAnimation(blir.a(this.this$0));
    blir.a(this.this$0).setAnimationListener(new bliw(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.7
 * JD-Core Version:    0.7.0.1
 */