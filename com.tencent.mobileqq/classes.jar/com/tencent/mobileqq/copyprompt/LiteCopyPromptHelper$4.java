package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import arqp;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(arqp paramarqp) {}
  
  public void run()
  {
    if ((arqp.a(this.this$0) != null) && (arqp.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)arqp.a(this.this$0).findViewById(2131364488)).removeView(arqp.a(this.this$0));
      arqp.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */