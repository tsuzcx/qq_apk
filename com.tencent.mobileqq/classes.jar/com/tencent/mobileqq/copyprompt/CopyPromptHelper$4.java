package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import aneu;
import com.tencent.mobileqq.activity.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(aneu paramaneu) {}
  
  public void run()
  {
    if ((aneu.a(this.this$0) != null) && (aneu.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)aneu.a(this.this$0).c.findViewById(2131364076)).removeView(aneu.a(this.this$0));
      aneu.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */