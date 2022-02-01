package com.tencent.mobileqq.imcore;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.imcore.proxy.msg.MsgUtilsProxy.Proxy;
import com.tencent.mobileqq.utils.MsgUtils;

final class IMCoreProxyRegister$2
  implements MsgUtilsProxy.Proxy
{
  public void a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    MsgUtils.a(paramContext, paramBaseQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramBoolean1, paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.2
 * JD-Core Version:    0.7.0.1
 */