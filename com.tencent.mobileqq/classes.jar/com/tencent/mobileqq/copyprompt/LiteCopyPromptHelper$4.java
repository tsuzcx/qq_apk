package com.tencent.mobileqq.copyprompt;

import amos;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(amos paramamos) {}
  
  public void run()
  {
    if ((amos.a(this.this$0) != null) && (amos.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)amos.a(this.this$0).findViewById(2131298518)).removeView(amos.a(this.this$0));
      amos.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */