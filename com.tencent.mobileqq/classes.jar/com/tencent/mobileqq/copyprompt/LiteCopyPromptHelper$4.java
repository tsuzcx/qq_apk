package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import apau;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(apau paramapau) {}
  
  public void run()
  {
    if ((apau.a(this.this$0) != null) && (apau.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)apau.a(this.this$0).findViewById(2131364139)).removeView(apau.a(this.this$0));
      apau.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */