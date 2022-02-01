package com.tencent.mobileqq.qassistant.view;

import bakl;

class AssistantBackView$2
  implements Runnable
{
  public void run()
  {
    if (AssistantBackView.a(this.this$0))
    {
      bakl.a("AssistantBackView", "loadLottieAnimation isDestroyed");
      return;
    }
    try
    {
      AssistantBackView.c(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      AssistantBackView.a(this.this$0, null);
      synchronized (AssistantBackView.a(this.this$0))
      {
        AssistantBackView.a(this.this$0, null);
        AssistantBackView.a(this.this$0, null);
        bakl.a("AssistantBackView", "loadVoiceAnimation failed:" + localThrowable.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.AssistantBackView.2
 * JD-Core Version:    0.7.0.1
 */