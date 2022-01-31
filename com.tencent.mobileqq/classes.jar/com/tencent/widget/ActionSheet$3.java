package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bhuf;
import bhuh;

public class ActionSheet$3
  implements Runnable
{
  public ActionSheet$3(bhuf parambhuf) {}
  
  public void run()
  {
    bhuf.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, 0.0F, bhuf.a(this.this$0).getHeight()));
    bhuf.a(this.this$0).setDuration(200L);
    bhuf.a(this.this$0).setFillAfter(true);
    bhuf.a(this.this$0).startAnimation(bhuf.a(this.this$0));
    bhuf.a(this.this$0).setAnimationListener(new bhuh(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.3
 * JD-Core Version:    0.7.0.1
 */