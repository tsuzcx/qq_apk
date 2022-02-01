package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bjnw;
import bjoj;

public class ActionSheet$6
  implements Runnable
{
  public ActionSheet$6(bjnw parambjnw) {}
  
  public void run()
  {
    if (bjnw.a(this.this$0) != null) {
      bjnw.a(this.this$0).a();
    }
    bjnw.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bjnw.a(this.this$0).getHeight(), 0.0F));
    bjnw.a(this.this$0).setFillEnabled(true);
    bjnw.a(this.this$0).setStartTime(300L);
    bjnw.a(this.this$0).setDuration(bjnw.a(this.this$0));
    bjnw.a(this.this$0, true);
    bjnw.a(this.this$0).startAnimation(bjnw.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.6
 * JD-Core Version:    0.7.0.1
 */