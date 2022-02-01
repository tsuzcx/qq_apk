package com.tencent.mobileqq.copyprompt;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import artb;
import com.tencent.mobileqq.activity.BaseChatPie;

public class CopyPromptHelper$4
  implements Runnable
{
  public CopyPromptHelper$4(artb paramartb) {}
  
  public void run()
  {
    if ((artb.a(this.this$0) != null) && (artb.a(this.this$0).getParent() != null))
    {
      ((RelativeLayout)artb.a(this.this$0).c.findViewById(2131364389)).removeView(artb.a(this.this$0));
      artb.a(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.copyprompt.CopyPromptHelper.4
 * JD-Core Version:    0.7.0.1
 */