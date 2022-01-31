package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import aowl;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(aowl paramaowl) {}
  
  public void run()
  {
    if ((aowl.a(this.this$0) != null) && (aowl.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)aowl.a(this.this$0).findViewById(2131364137)).removeView(aowl.a(this.this$0));
      aowl.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */