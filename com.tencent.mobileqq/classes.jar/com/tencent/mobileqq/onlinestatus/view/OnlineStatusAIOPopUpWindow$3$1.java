package com.tencent.mobileqq.onlinestatus.view;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;

class OnlineStatusAIOPopUpWindow$3$1
  implements Runnable
{
  OnlineStatusAIOPopUpWindow$3$1(OnlineStatusAIOPopUpWindow.3 param3) {}
  
  public void run()
  {
    ((IFriendHandlerTempService)OnlineStatusAIOPopUpWindow.a(this.a.a).getRuntimeService(IFriendHandlerTempService.class, "")).getOnlineInfo(OnlineStatusAIOPopUpWindow.a(this.a.a).uin, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OnlineStatusAIOPopUpWindow.3.1
 * JD-Core Version:    0.7.0.1
 */