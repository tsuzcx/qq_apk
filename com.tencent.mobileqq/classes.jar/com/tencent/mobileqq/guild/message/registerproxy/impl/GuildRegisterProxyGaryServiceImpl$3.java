package com.tencent.mobileqq.guild.message.registerproxy.impl;

import com.tencent.mobileqq.guild.handler.QQGuildObserver;
import com.tencent.qphone.base.util.QLog;

class GuildRegisterProxyGaryServiceImpl$3
  extends QQGuildObserver
{
  GuildRegisterProxyGaryServiceImpl$3(GuildRegisterProxyGaryServiceImpl paramGuildRegisterProxyGaryServiceImpl) {}
  
  public void a()
  {
    QLog.i("GuildRegisterProxyGaryServiceImpl", 1, "onDebugShowTabUpdate");
    GuildRegisterProxyGaryServiceImpl.access$000(this.a, false);
  }
  
  public void a(Object paramObject, int paramInt)
  {
    paramObject = new StringBuilder();
    paramObject.append("onUserTypeUpdate from:");
    paramObject.append(paramInt);
    paramObject = paramObject.toString();
    boolean bool = true;
    QLog.i("GuildRegisterProxyGaryServiceImpl", 1, paramObject);
    paramObject = this.a;
    if (paramInt != 3) {
      bool = false;
    }
    GuildRegisterProxyGaryServiceImpl.access$000(paramObject, bool);
  }
  
  public void b()
  {
    QLog.i("GuildRegisterProxyGaryServiceImpl", 1, "onMemoryShowTabUpdate");
    GuildRegisterProxyGaryServiceImpl.access$000(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.impl.GuildRegisterProxyGaryServiceImpl.3
 * JD-Core Version:    0.7.0.1
 */