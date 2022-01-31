package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import anfe;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(anfe paramanfe) {}
  
  public void run()
  {
    if ((anfe.a(this.this$0) != null) && (anfe.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)anfe.a(this.this$0).findViewById(2131364075)).removeView(anfe.a(this.this$0));
      anfe.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */