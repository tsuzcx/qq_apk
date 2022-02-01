package com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;

public class GuildVideoTypeSupplier
  implements GuildMessageTypeSupplier
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    paramQQAppInterface = (MessageForShortVideo)paramChatMessage;
    if (paramQQAppInterface.busiType != 4601) {
      return GuildMsgItemBuildFactory.a;
    }
    if (paramQQAppInterface.subBusiType == 4601) {
      return GuildMsgItemBuildFactory.e;
    }
    if (paramQQAppInterface.subBusiType == 4602) {
      return GuildMsgItemBuildFactory.f;
    }
    return GuildMsgItemBuildFactory.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier.GuildVideoTypeSupplier
 * JD-Core Version:    0.7.0.1
 */