package com.tencent.mobileqq.troop.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.troop.api.IHotChatService;
import mqq.app.AppRuntime;

public class HotChatServiceImpl
  implements IHotChatService
{
  AppRuntime mApp;
  
  public int getHotChatDrawableID(String paramString, AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      return HotChatManager.a(paramString, (QQAppInterface)paramAppInterface);
    }
    return 2130843601;
  }
  
  public String getHotChatName(String paramString)
  {
    paramString = ((HotChatManager)this.mApp.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramString);
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.name);
      localStringBuilder.append(HardCodeUtil.a(2131900750));
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public boolean isHotChat(String paramString)
  {
    return ((HotChatManager)this.mApp.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).b(paramString);
  }
  
  public boolean isRobotHotChat(String paramString)
  {
    paramString = ((HotChatManager)this.mApp.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).c(paramString);
    if (paramString != null) {
      return paramString.isRobotHotChat;
    }
    return false;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = paramAppRuntime;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.impl.HotChatServiceImpl
 * JD-Core Version:    0.7.0.1
 */