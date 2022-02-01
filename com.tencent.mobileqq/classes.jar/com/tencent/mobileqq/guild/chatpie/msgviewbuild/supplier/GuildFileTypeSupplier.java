package com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.filemanager.util.QQFileManagerUtil;
import com.tencent.mobileqq.guild.chatpie.GuildMsgItemBuildFactory;
import com.tencent.mobileqq.guild.chatpie.msgviewbuild.msgtypesupplier.GuildMessageTypeSupplier;

public class GuildFileTypeSupplier
  implements GuildMessageTypeSupplier
{
  public int a(QQAppInterface paramQQAppInterface, ChatMessage paramChatMessage)
  {
    int i = QQFileManagerUtil.k(((MessageForFile)paramChatMessage).fileName);
    if (i == 0) {
      return GuildMsgItemBuildFactory.n;
    }
    if (i == 2) {
      return GuildMsgItemBuildFactory.o;
    }
    return GuildMsgItemBuildFactory.m;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.msgviewbuild.supplier.GuildFileTypeSupplier
 * JD-Core Version:    0.7.0.1
 */