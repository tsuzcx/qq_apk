package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class CopyPromptHelper$4
  implements Runnable
{
  CopyPromptHelper$4(CopyPromptHelper paramCopyPromptHelper) {}
  
  public void run()
  {
    if ((CopyPromptHelper.e(this.this$0) != null) && (CopyPromptHelper.e(this.this$0).getParent() != null))
    {
      ((RelativeLayout)CopyPromptHelper.d(this.this$0).aZ.findViewById(2131430542)).removeView(CopyPromptHelper.e(this.this$0));
      CopyPromptHelper.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */