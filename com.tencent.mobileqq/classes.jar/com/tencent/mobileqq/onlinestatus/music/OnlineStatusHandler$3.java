package com.tencent.mobileqq.onlinestatus.music;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class OnlineStatusHandler$3
  implements Runnable
{
  OnlineStatusHandler$3(OnlineStatusHandler paramOnlineStatusHandler, String paramString) {}
  
  public void run()
  {
    ((FriendListHandler)OnlineStatusHandler.a(this.this$0).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.3
 * JD-Core Version:    0.7.0.1
 */