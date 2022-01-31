package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import anez;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(anez paramanez) {}
  
  public void run()
  {
    if ((anez.a(this.this$0) != null) && (anez.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)anez.a(this.this$0).findViewById(2131364076)).removeView(anez.a(this.this$0));
      anez.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */