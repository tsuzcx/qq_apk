package com.tencent.mobileqq.imcore.proxy.business;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;

public class GameMsgBoxRuntimeServiceProxy
{
  private static GameMsgBoxRuntimeServiceProxy.Proxy a;
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface)
  {
    GameMsgBoxRuntimeServiceProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return;
    }
    localProxy.a(paramBaseQQAppInterface);
  }
  
  public static void a(BaseQQAppInterface paramBaseQQAppInterface, RecentUserProxy paramRecentUserProxy, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    GameMsgBoxRuntimeServiceProxy.Proxy localProxy = a;
    if (localProxy == null) {
      return;
    }
    localProxy.a(paramBaseQQAppInterface, paramRecentUserProxy, paramMessageRecord, paramBoolean);
  }
  
  public static void a(GameMsgBoxRuntimeServiceProxy.Proxy paramProxy)
  {
    a = paramProxy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.proxy.business.GameMsgBoxRuntimeServiceProxy
 * JD-Core Version:    0.7.0.1
 */