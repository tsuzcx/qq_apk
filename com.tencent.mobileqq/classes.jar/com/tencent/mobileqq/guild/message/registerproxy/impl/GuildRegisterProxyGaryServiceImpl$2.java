package com.tencent.mobileqq.guild.message.registerproxy.impl;

import com.tencent.mobileqq.activity.home.OnTabFrameAddCallback;
import com.tencent.mobileqq.activity.home.TabData;
import com.tencent.qphone.base.util.QLog;

class GuildRegisterProxyGaryServiceImpl$2
  implements OnTabFrameAddCallback
{
  GuildRegisterProxyGaryServiceImpl$2(GuildRegisterProxyGaryServiceImpl paramGuildRegisterProxyGaryServiceImpl) {}
  
  public void a(TabData paramTabData)
  {
    if (paramTabData == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onTabFrameAdd. tabId: ");
      localStringBuilder.append(paramTabData.a);
      localStringBuilder.append(", tabStatus: ");
      localStringBuilder.append(paramTabData.b);
      QLog.d("GuildRegisterProxyGaryServiceImpl", 2, localStringBuilder.toString());
    }
    if (paramTabData.a == 2) {
      GuildRegisterProxyGaryServiceImpl.access$000(this.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.impl.GuildRegisterProxyGaryServiceImpl.2
 * JD-Core Version:    0.7.0.1
 */