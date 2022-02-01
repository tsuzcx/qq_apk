package com.tencent.mobileqq.pushdialog;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;

class PushDialogHandler$1
  implements Runnable
{
  PushDialogHandler$1(PushDialogHandler paramPushDialogHandler, BaseChatPie paramBaseChatPie, PushDialogTemplate paramPushDialogTemplate) {}
  
  public void run()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (this.b != null)) {
      ((AIOPushDialogHelper)localBaseChatPie.q(42)).a(this.b, 102, 101);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushdialog.PushDialogHandler.1
 * JD-Core Version:    0.7.0.1
 */