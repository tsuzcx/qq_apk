package com.tencent.mobileqq.imcore.proxy.msg;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;

public class MsgUtilsProxy
{
  private static MsgUtilsProxy.Proxy a;
  
  public static void a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, IMCoreMessageStub paramIMCoreMessageStub, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (a != null) {
      a.a(paramContext, paramBaseQQAppInterface, paramIMCoreMessageStub, paramInt, paramMsgSummary, paramBoolean1, paramBoolean2);
    }
  }
  
  public static void a(MsgUtilsProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.msg.MsgUtilsProxy
 * JD-Core Version:    0.7.0.1
 */