package com.tencent.mobileqq.hotchat.app.step;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.hotchat.api.IHotChatApi;
import com.tencent.mobileqq.hotchat.api.IHotChatHandler;
import com.tencent.mobileqq.qroute.QRoute;

public class GetJoinedHotChatListStep
  extends AsyncStep
{
  private HotChatObserver a;
  
  protected int doStep()
  {
    if (!HotChatManager.a(this.mAutomator.k)) {
      return 7;
    }
    IHotChatHandler localIHotChatHandler = (IHotChatHandler)this.mAutomator.k.getBusinessHandler(((IHotChatApi)QRoute.api(IHotChatApi.class)).getHotChatHandlerClassName());
    this.a = new GetJoinedHotChatListStep.GetJoindedHotChatListObserver(this, null);
    this.mAutomator.k.addObserver(this.a);
    localIHotChatHandler.getMyHotChatList();
    return 2;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.mAutomator.k.removeObserver(this.a);
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.step.GetJoinedHotChatListStep
 * JD-Core Version:    0.7.0.1
 */