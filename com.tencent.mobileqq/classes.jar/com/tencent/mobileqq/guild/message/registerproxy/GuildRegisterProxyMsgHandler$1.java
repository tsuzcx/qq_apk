package com.tencent.mobileqq.guild.message.registerproxy;

import com.tencent.mobileqq.guild.message.registerproxy.observer.GuildRegisterProxyObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import tencent.im.group_pro_proto.synclogic.synclogic.MultiChannelMsgRsp;

class GuildRegisterProxyMsgHandler$1
  extends GuildRegisterProxyObserver
{
  GuildRegisterProxyMsgHandler$1(GuildRegisterProxyMsgHandler paramGuildRegisterProxyMsgHandler) {}
  
  private boolean a(int paramInt)
  {
    if (GuildRegisterProxyMsgHandler.a(this.a).containsKey(Integer.valueOf(paramInt)))
    {
      ((IGuildRegisterProxyProcesser)GuildRegisterProxyMsgHandler.a(this.a).get(Integer.valueOf(paramInt))).a();
      GuildRegisterProxyMsgHandler.a(this.a).remove(Integer.valueOf(paramInt));
      return true;
    }
    return false;
  }
  
  protected void a(boolean paramBoolean, int paramInt)
  {
    if (a(paramInt))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdatePushChannelMsg isSuccess:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" remove seq:");
      localStringBuilder.append(paramInt);
      QLog.i("GuildRegisterProxyMsgHandler", 1, localStringBuilder.toString());
    }
  }
  
  protected void a(boolean paramBoolean, int paramInt, synclogic.MultiChannelMsgRsp paramMultiChannelMsgRsp)
  {
    if ((!paramBoolean) && (a(paramInt)))
    {
      paramMultiChannelMsgRsp = new StringBuilder();
      paramMultiChannelMsgRsp.append("onUpdateGetMultiChannelMsgReq isSuccess:");
      paramMultiChannelMsgRsp.append(paramBoolean);
      paramMultiChannelMsgRsp.append(" remove seq:");
      paramMultiChannelMsgRsp.append(paramInt);
      QLog.i("GuildRegisterProxyMsgHandler", 1, paramMultiChannelMsgRsp.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyMsgHandler.1
 * JD-Core Version:    0.7.0.1
 */