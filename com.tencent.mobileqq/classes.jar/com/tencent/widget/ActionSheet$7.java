package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bjnw;
import bjob;

public class ActionSheet$7
  implements Runnable
{
  public ActionSheet$7(bjnw parambjnw) {}
  
  public void run()
  {
    bjnw.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bjnw.a(this.this$0).getHeight()));
    bjnw.a(this.this$0).setDuration(200L);
    bjnw.a(this.this$0).setFillAfter(true);
    bjnw.a(this.this$0).startAnimation(bjnw.a(this.this$0));
    bjnw.a(this.this$0).setAnimationListener(new bjob(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.7
 * JD-Core Version:    0.7.0.1
 */