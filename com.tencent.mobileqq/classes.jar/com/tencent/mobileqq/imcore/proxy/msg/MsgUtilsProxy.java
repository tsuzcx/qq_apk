package com.tencent.mobileqq.imcore.proxy.msg;

import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;

public class MsgUtilsProxy
{
  private static MsgUtilsProxy.Proxy a;
  
  public static void a(Context paramContext, BaseQQAppInterface paramBaseQQAppInterface, Message paramMessage, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    MsgUtilsProxy.Proxy localProxy = a;
    if (localProxy != null) {
      localProxy.a(paramContext, paramBaseQQAppInterface, paramMessage, paramInt, paramMsgSummary, paramBoolean1, paramBoolean2);
    }
  }
  
  public static void a(MsgUtilsProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.msg.MsgUtilsProxy
 * JD-Core Version:    0.7.0.1
 */