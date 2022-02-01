package com.tencent.mobileqq.qassistant.view;

import com.tencent.mobileqq.qassistant.core.AssistantUtils;

class AssistantBackView$1
  implements Runnable
{
  AssistantBackView$1(AssistantBackView paramAssistantBackView) {}
  
  public void run()
  {
    AssistantUtils.a("AssistantBackView", "mUpdateRunnable isEnabled:" + this.this$0.isEnabled() + "  mLottieDrawable:" + AssistantBackView.a(this.this$0) + " mIsDestroyed:" + AssistantBackView.a(this.this$0));
    if (AssistantBackView.a(this.this$0)) {
      return;
    }
    if (this.this$0.isEnabled())
    {
      if (AssistantBackView.a(this.this$0) != null)
      {
        AssistantBackView.a(this.this$0, true);
        AssistantBackView.b(this.this$0, true);
        this.this$0.setBackgroundDrawable(AssistantBackView.a(this.this$0));
        AssistantBackView.a(this.this$0);
        return;
      }
      AssistantBackView.b(this.this$0, false);
      this.this$0.setBackgroundColor(AssistantBackView.a(this.this$0));
      return;
    }
    AssistantBackView.b(this.this$0, false);
    this.this$0.setBackgroundColor(AssistantBackView.b(this.this$0));
    AssistantBackView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.AssistantBackView.1
 * JD-Core Version:    0.7.0.1
 */