package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import aqmz;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(aqmz paramaqmz) {}
  
  public void run()
  {
    if ((aqmz.a(this.this$0) != null) && (aqmz.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)aqmz.a(this.this$0).mAIORootView.findViewById(2131364407)).removeView(aqmz.a(this.this$0));
      aqmz.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */