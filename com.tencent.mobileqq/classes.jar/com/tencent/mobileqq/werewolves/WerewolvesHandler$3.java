package com.tencent.mobileqq.werewolves;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.nearby.api.INearbySPUtil;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class WerewolvesHandler$3
  implements WerewolvesHandler.Callback<oidb_0x8ed.RspBody>
{
  WerewolvesHandler$3(WerewolvesHandler paramWerewolvesHandler, WerewolvesHandler.Callback paramCallback1, HotChatInfo paramHotChatInfo, long paramLong, int paramInt1, int paramInt2, WerewolvesHandler.Callback paramCallback2) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((WerewolvesHandler.Callback)localObject).a(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)WerewolvesHandler.a(this.g).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = paramRspBody.c();
    if (localObject != null) {
      ((List)localObject).remove(this.b);
    }
    paramRspBody.a(this.b, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).exitRoom(this.c);
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(WerewolvesHandler.a(this.g).getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.c()));
    if ((this.b.troopUin != null) && (!this.b.troopUin.equals("0"))) {
      WerewolvesHandler.a(this.g).getMessageFacade().c(this.b.troopUin, 1);
    }
    this.g.b(this.d, this.e, this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler.3
 * JD-Core Version:    0.7.0.1
 */