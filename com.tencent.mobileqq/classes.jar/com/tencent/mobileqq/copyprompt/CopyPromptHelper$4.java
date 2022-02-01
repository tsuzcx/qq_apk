package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import ardm;
import com.tencent.mobileqq.activity.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(ardm paramardm) {}
  
  public void run()
  {
    if ((ardm.a(this.this$0) != null) && (ardm.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)ardm.a(this.this$0).c.findViewById(2131364345)).removeView(ardm.a(this.this$0));
      ardm.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */