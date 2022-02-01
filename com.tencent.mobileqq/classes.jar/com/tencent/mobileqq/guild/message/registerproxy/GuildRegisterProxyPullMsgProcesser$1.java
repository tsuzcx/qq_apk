package com.tencent.mobileqq.guild.message.registerproxy;

import java.util.Comparator;

class GuildRegisterProxyPullMsgProcesser$1
  implements Comparator
{
  GuildRegisterProxyPullMsgProcesser$1(GuildRegisterProxyPullMsgProcesser paramGuildRegisterProxyPullMsgProcesser) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      paramObject1 = (GuildRegisterProxyPullMsgProcesser.ChannelParamEx)paramObject1;
      paramObject2 = (GuildRegisterProxyPullMsgProcesser.ChannelParamEx)paramObject2;
      if (paramObject1.a == paramObject2.a) {
        return 0;
      }
      if (paramObject1.a > paramObject2.a) {
        return -1;
      }
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.registerproxy.GuildRegisterProxyPullMsgProcesser.1
 * JD-Core Version:    0.7.0.1
 */