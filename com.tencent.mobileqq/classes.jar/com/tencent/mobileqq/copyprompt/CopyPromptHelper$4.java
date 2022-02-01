package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import arqk;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(arqk paramarqk) {}
  
  public void run()
  {
    if ((arqk.a(this.this$0) != null) && (arqk.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)arqk.a(this.this$0).mAIORootView.findViewById(2131364488)).removeView(arqk.a(this.this$0));
      arqk.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */