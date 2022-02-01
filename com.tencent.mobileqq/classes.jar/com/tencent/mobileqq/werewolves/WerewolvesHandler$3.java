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
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback;
    if (localObject != null) {
      ((WerewolvesHandler.Callback)localObject).a(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)WerewolvesHandler.a(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = paramRspBody.a();
    if (localObject != null) {
      ((List)localObject).remove(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo);
    }
    paramRspBody.a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
    ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).exitRoom(this.jdField_a_of_type_Long);
    ((INearbySPUtil)QRoute.api(INearbySPUtil.class)).setValue(WerewolvesHandler.a(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler).getCurrentAccountUin(), "game_room_last_time", Long.valueOf(MessageCache.a()));
    if ((this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin != null) && (!this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin.equals("0"))) {
      WerewolvesHandler.a(this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler).getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo.troopUin, 1);
    }
    this.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler.b(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_ComTencentMobileqqWerewolvesWerewolvesHandler$Callback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler.3
 * JD-Core Version:    0.7.0.1
 */