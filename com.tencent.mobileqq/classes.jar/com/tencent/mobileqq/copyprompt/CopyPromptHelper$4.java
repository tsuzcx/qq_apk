package com.tencent.mobileqq.copyprompt;

import amon;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(amon paramamon) {}
  
  public void run()
  {
    if ((amon.a(this.this$0) != null) && (amon.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)amon.a(this.this$0).c.findViewById(2131298518)).removeView(amon.a(this.this$0));
      amon.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */