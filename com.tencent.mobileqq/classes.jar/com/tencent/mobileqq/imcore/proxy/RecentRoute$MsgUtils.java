package com.tencent.mobileqq.imcore.proxy;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;

public class RecentRoute$MsgUtils
{
  private static RecentRoute.MsgUtils.Proxy proxy;
  
  public static void buildMsgSummaryForMsg(Context paramContext, IMCoreAppRuntime paramIMCoreAppRuntime, IMCoreMessageStub paramIMCoreMessageStub, int paramInt, MsgSummary paramMsgSummary, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (proxy != null) {
      proxy.buildMsgSummaryForMsg(paramContext, paramIMCoreAppRuntime, paramIMCoreMessageStub, paramInt, paramMsgSummary, paramBoolean1, paramBoolean2);
    }
  }
  
  public static void registerProxy(RecentRoute.MsgUtils.Proxy paramProxy)
  {
    proxy = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.RecentRoute.MsgUtils
 * JD-Core Version:    0.7.0.1
 */