package com.tencent.mobileqq.werewolves;

import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.HotChatManager.HotChatStateWrapper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import java.util.List;
import tencent.im.oidb.cmd0x8ed.oidb_0x8ed.RspBody;

class WerewolvesHandler$1
  implements WerewolvesHandler.Callback<oidb_0x8ed.RspBody>
{
  WerewolvesHandler$1(WerewolvesHandler paramWerewolvesHandler, WerewolvesHandler.Callback paramCallback, HotChatInfo paramHotChatInfo) {}
  
  public void a(int paramInt, oidb_0x8ed.RspBody paramRspBody)
  {
    Object localObject = this.a;
    if (localObject != null) {
      ((WerewolvesHandler.Callback)localObject).a(paramInt, paramRspBody);
    }
    paramRspBody = (HotChatManager)WerewolvesHandler.a(this.c).getManager(QQManagerFactory.HOT_CHAT_MANAGER);
    localObject = paramRspBody.c();
    if (localObject != null) {
      ((List)localObject).remove(this.b);
    }
    paramRspBody.a(this.b, HotChatManager.HotChatStateWrapper.STATE_HOT_CHAT_IS_DISBANDED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.werewolves.WerewolvesHandler.1
 * JD-Core Version:    0.7.0.1
 */