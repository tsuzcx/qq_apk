package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildIPCService;
import com.tencent.mobileqq.guild.ipc.QQGuildSvrIPCModule;
import com.tencent.mobileqq.qipc.QIPCModule;

public class GuildIPCServiceImpl
  implements IGuildIPCService
{
  public QIPCModule onCreateModule(String paramString)
  {
    return QQGuildSvrIPCModule.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.impl.GuildIPCServiceImpl
 * JD-Core Version:    0.7.0.1
 */