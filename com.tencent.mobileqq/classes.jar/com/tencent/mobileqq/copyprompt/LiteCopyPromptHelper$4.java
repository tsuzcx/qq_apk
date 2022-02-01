package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

class LiteCopyPromptHelper$4
  implements Runnable
{
  LiteCopyPromptHelper$4(LiteCopyPromptHelper paramLiteCopyPromptHelper) {}
  
  public void run()
  {
    if ((LiteCopyPromptHelper.a(this.this$0) != null) && (LiteCopyPromptHelper.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)LiteCopyPromptHelper.a(this.this$0).findViewById(2131364485)).removeView(LiteCopyPromptHelper.a(this.this$0));
      LiteCopyPromptHelper.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */