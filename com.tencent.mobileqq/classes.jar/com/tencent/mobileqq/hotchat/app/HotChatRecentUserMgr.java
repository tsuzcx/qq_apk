package com.tencent.mobileqq.hotchat.app;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import mqq.os.MqqHandler;

public class HotChatRecentUserMgr
{
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getHandler(Conversation.class);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.sendMessage(paramQQAppInterface.obtainMessage(1009));
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getProxyManager().a();
    paramString = paramQQAppInterface.b(paramString, 1);
    if (paramString != null) {
      paramQQAppInterface.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatRecentUserMgr
 * JD-Core Version:    0.7.0.1
 */