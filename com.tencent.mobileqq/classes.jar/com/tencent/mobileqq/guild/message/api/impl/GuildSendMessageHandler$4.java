package com.tencent.mobileqq.guild.message.api.impl;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.utils.SendMessageHandler.SendMessageRunnable;
import com.tencent.qphone.base.util.QLog;

class GuildSendMessageHandler$4
  extends SendMessageHandler.SendMessageRunnable
{
  GuildSendMessageHandler$4(GuildSendMessageHandler paramGuildSendMessageHandler, MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("GuildSendMessageHandler", 2, "--->sendRichTextMessageWith_MR : resend message");
    }
    GuildSendMessageHandler.a(this.this$0, this.a, this.g, this.m, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.impl.GuildSendMessageHandler.4
 * JD-Core Version:    0.7.0.1
 */