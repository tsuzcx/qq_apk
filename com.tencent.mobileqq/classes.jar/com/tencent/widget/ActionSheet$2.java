package com.tencent.widget;

import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import bhuf;
import bhuo;

public class ActionSheet$2
  implements Runnable
{
  public ActionSheet$2(bhuf parambhuf) {}
  
  public void run()
  {
    if (bhuf.a(this.this$0) != null) {
      bhuf.a(this.this$0).a();
    }
    bhuf.a(this.this$0, new TranslateAnimation(0.0F, 0.0F, bhuf.a(this.this$0).getHeight(), 0.0F));
    bhuf.a(this.this$0).setFillEnabled(true);
    bhuf.a(this.this$0).setStartTime(300L);
    bhuf.a(this.this$0).setDuration(bhuf.a(this.this$0));
    bhuf.a(this.this$0, true);
    bhuf.a(this.this$0).startAnimation(bhuf.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.widget.ActionSheet.2
 * JD-Core Version:    0.7.0.1
 */