package com.tencent.mobileqq.guild.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildIPCService
  extends QRouteApi
{
  public static final String GUILD_NAME_IPC_NAME = "module_ipc_server_guild";
  
  public abstract QIPCModule onCreateModule(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildIPCService
 * JD-Core Version:    0.7.0.1
 */