package com.tencent.mobileqq.guild.message.callback;

import com.tencent.mobileqq.activity.guild.GuildMsgProcessorTextMsgCallback;
import com.tencent.mobileqq.activity.guild.GuildMsgUtilsCallback;
import com.tencent.mobileqq.activity.guild.GuildSendTextMsgCallback;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageProcessorCallback;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageUtilsCallback;
import com.tencent.mobileqq.guild.message.base.AbsGuildSendMessageHandlerCallback;
import com.tencent.mobileqq.qroute.annotation.ConfigInject;
import java.util.ArrayList;

public class GuildMessageCallbackRegister
{
  @ConfigInject(configPath="Business/qqguild-impl/src/main/resources/Inject_GuildCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsGuildSendMessageHandlerCallback>> a = new ArrayList();
  @ConfigInject(configPath="Business/qqguild-impl/src/main/resources/Inject_GuildCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsGuildMessageProcessorCallback>> b;
  @ConfigInject(configPath="Business/qqguild-impl/src/main/resources/Inject_GuildCustomizedConfig.yml", version=1)
  public static ArrayList<Class<? extends AbsGuildMessageUtilsCallback>> c;
  
  static
  {
    a.add(GuildSendTextMsgCallback.class);
    b = new ArrayList();
    b.add(GuildMsgProcessorTextMsgCallback.class);
    c = new ArrayList();
    c.add(GuildMsgUtilsCallback.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.callback.GuildMessageCallbackRegister
 * JD-Core Version:    0.7.0.1
 */