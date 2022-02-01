package com.tencent.mobileqq.onlinestatus.music;

import azff;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

public class OnlineStatusHandler$2
  implements Runnable
{
  public OnlineStatusHandler$2(azff paramazff, String paramString) {}
  
  public void run()
  {
    ((FriendListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getOnlineInfo(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.2
 * JD-Core Version:    0.7.0.1
 */