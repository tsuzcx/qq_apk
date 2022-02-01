package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import artg;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(artg paramartg) {}
  
  public void run()
  {
    if ((artg.a(this.this$0) != null) && (artg.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)artg.a(this.this$0).findViewById(2131364389)).removeView(artg.a(this.this$0));
      artg.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */