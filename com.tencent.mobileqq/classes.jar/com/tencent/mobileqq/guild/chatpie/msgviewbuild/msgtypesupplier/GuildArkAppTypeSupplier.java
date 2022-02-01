package com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ArkAppMessage.Config;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;

public class GuildArkAppTypeSupplier
  implements GuildMessageTypeSupplier
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForArkApp)paramChatMessage;
    paramChatMessage = new ArkAppMessage.Config();
    paramChatMessage.fromString(paramQQAppInterface.ark_app_message.config);
    if ((paramChatMessage.type != null) && (paramChatMessage.type.equals("multiple"))) {
      return GuildMsgItemBuildFactory.a;
    }
    if ((paramChatMessage.type != null) && (paramChatMessage.type.equals("card"))) {
      return GuildMsgItemBuildFactory.a;
    }
    return GuildMsgItemBuildFactory.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier.GuildArkAppTypeSupplier
 * JD-Core Version:    0.7.0.1
 */