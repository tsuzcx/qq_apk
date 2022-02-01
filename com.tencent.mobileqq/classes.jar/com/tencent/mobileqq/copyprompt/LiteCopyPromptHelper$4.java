package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import ardr;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(ardr paramardr) {}
  
  public void run()
  {
    if ((ardr.a(this.this$0) != null) && (ardr.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)ardr.a(this.this$0).findViewById(2131364345)).removeView(ardr.a(this.this$0));
      ardr.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */