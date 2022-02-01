package com.tencent.mobileqq.onlinestatus.music;

import com.tencent.mobileqq.relation.api.IFriendHandlerTempService;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class OnlineStatusHandler$3
  implements Runnable
{
  OnlineStatusHandler$3(OnlineStatusHandler paramOnlineStatusHandler, String paramString) {}
  
  public void run()
  {
    ((IFriendHandlerTempService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFriendHandlerTempService.class, "")).getOnlineInfo(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.music.OnlineStatusHandler.3
 * JD-Core Version:    0.7.0.1
 */