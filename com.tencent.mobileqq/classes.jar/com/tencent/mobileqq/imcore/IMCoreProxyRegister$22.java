package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxRuntimeService;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.imcore.proxy.business.GameMsgBoxRuntimeServiceProxy.Proxy;
import com.tencent.qphone.base.util.QLog;

final class IMCoreProxyRegister$22
  implements GameMsgBoxRuntimeServiceProxy.Proxy
{
  public void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    ((IGameMsgBoxRuntimeService)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "")).setDataReady();
  }
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserProxy paramRecentUserProxy, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    paramBaseQQAppInterface = (IGameMsgBoxRuntimeService)paramBaseQQAppInterface.getRuntimeService(IGameMsgBoxRuntimeService.class, "");
    paramBaseQQAppInterface.processGameMsg(paramRecentUserProxy, paramMessageRecord);
    if (paramBaseQQAppInterface.isCurMsgNeedShowRed(paramMessageRecord))
    {
      if (QLog.isColorLevel()) {
        QLog.d("IMCoreProxyRegister", 1, "game msg rec, need change box read status");
      }
      paramBaseQQAppInterface.setBoxRead(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.22
 * JD-Core Version:    0.7.0.1
 */