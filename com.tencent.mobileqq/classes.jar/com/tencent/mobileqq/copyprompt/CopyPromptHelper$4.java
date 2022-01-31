package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import aowg;
import com.tencent.mobileqq.activity.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(aowg paramaowg) {}
  
  public void run()
  {
    if ((aowg.a(this.this$0) != null) && (aowg.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)aowg.a(this.this$0).c.findViewById(2131364137)).removeView(aowg.a(this.this$0));
      aowg.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */