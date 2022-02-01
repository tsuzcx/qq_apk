package com.tencent.mobileqq.imcore;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.imcore.proxy.business.TempMsgBoxManagerProxy.Proxy;

final class IMCoreProxyRegister$20
  implements TempMsgBoxManagerProxy.Proxy
{
  public void a(BaseQQAppInterface paramBaseQQAppInterface, boolean paramBoolean)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return;
    }
    ((ITempMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).setMsgBoxRead(paramBoolean);
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    return ((ITempMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).msgBoxSwitch();
  }
  
  public boolean a(BaseQQAppInterface paramBaseQQAppInterface, String paramString, int paramInt)
  {
    if (!(paramBaseQQAppInterface instanceof QQAppInterface)) {
      return false;
    }
    return ((ITempMsgBoxManager)paramBaseQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).isBelongToMsgBox(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.20
 * JD-Core Version:    0.7.0.1
 */