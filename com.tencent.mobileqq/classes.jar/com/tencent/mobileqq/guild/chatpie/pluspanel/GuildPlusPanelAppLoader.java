package com.tencent.mobileqq.guild.chatpie.pluspanel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.pluspanel.loader.CommonPlusPanelAppLoader;
import com.tencent.mobileqq.guild.file.config.api.IGuildFileEntryApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.qroute.QRoute;

public class GuildPlusPanelAppLoader
  extends CommonPlusPanelAppLoader
{
  private void d(int paramInt)
  {
    a(10014, paramInt);
  }
  
  private void e()
  {
    d(1104864054);
    d(1200000003);
    d(1104864062);
    d();
    d(2000000001);
  }
  
  private void f()
  {
    d(1104864062);
  }
  
  protected void b(BaseChatPie paramBaseChatPie)
  {
    if (!((IGuildFeatureAdapterApi)QRoute.api(IGuildFeatureAdapterApi.class)).judgeIsGuildLiveChannelChatPie(paramBaseChatPie))
    {
      e();
      return;
    }
    f();
  }
  
  void d()
  {
    if (((IGuildFileEntryApi)QRoute.api(IGuildFileEntryApi.class)).isShowEntry()) {
      d(1104864066);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.pluspanel.GuildPlusPanelAppLoader
 * JD-Core Version:    0.7.0.1
 */