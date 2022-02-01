package com.tencent.mobileqq.hotchat.app.step;

import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;

class GetJoinedHotChatListStep$GetJoindedHotChatListObserver
  extends HotChatObserver
{
  private GetJoinedHotChatListStep$GetJoindedHotChatListObserver(GetJoinedHotChatListStep paramGetJoinedHotChatListStep) {}
  
  protected void a(int paramInt)
  {
    if (GetJoinedHotChatListStep.a(this.a) != null)
    {
      this.a.mAutomator.a.removeObserver(GetJoinedHotChatListStep.a(this.a));
      GetJoinedHotChatListStep.a(this.a, null);
    }
    if (paramInt == 0)
    {
      this.a.setResult(7);
      return;
    }
    this.a.setResult(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.step.GetJoinedHotChatListStep.GetJoindedHotChatListObserver
 * JD-Core Version:    0.7.0.1
 */