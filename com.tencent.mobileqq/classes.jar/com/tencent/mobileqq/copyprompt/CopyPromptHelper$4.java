package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import apap;
import com.tencent.mobileqq.activity.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(apap paramapap) {}
  
  public void run()
  {
    if ((apap.a(this.this$0) != null) && (apap.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)apap.a(this.this$0).c.findViewById(2131364139)).removeView(apap.a(this.this$0));
      apap.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */