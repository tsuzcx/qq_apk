package com.tencent.mobileqq.hotchat.app;

import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class HotChatHandler$2
  implements Runnable
{
  HotChatHandler$2(HotChatHandler paramHotChatHandler, boolean paramBoolean, List paramList) {}
  
  public void run()
  {
    HotChatInfo localHotChatInfo;
    if ((!((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).getInAIO()) && (!((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).getInvite())) {
      if ((this.a) && (!this.b.isEmpty())) {
        localHotChatInfo = (HotChatInfo)this.b.get(0);
      }
    }
    try
    {
      long l = Long.parseLong(localHotChatInfo.troopUin);
      ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).showFloatView(1, null, l, localHotChatInfo.name);
      return;
    }
    catch (Exception localException)
    {
      label94:
      StringBuilder localStringBuilder;
      break label94;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetMyHostChatListRespError hc.troopUin: ");
      localStringBuilder.append(localHotChatInfo.troopUin);
      QLog.e("HotChatHandler", 2, localStringBuilder.toString());
      return;
      if (((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).getFloatViewState() == 1) {
        ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).hideFloatView();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatHandler.2
 * JD-Core Version:    0.7.0.1
 */