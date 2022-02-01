package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import aqne;

public class LiteCopyPromptHelper$4
  implements Runnable
{
  public LiteCopyPromptHelper$4(aqne paramaqne) {}
  
  public void run()
  {
    if ((aqne.a(this.this$0) != null) && (aqne.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)aqne.a(this.this$0).findViewById(2131364407)).removeView(aqne.a(this.this$0));
      aqne.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.LiteCopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */