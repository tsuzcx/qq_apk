package com.tencent.mobileqq.guild.message.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract interface IGuildSendMessageHandler
{
  public abstract long a(AppInterface paramAppInterface, IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams);
  
  public abstract List<MessageRecord> a();
  
  public abstract void a(MessageRecord paramMessageRecord);
  
  public abstract void a(MessageRecord paramMessageRecord, BusinessObserver paramBusinessObserver, boolean paramBoolean);
  
  public abstract void a(String paramString, long paramLong1, long paramLong2);
  
  public abstract long b(AppInterface paramAppInterface, IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams);
  
  public abstract void b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler
 * JD-Core Version:    0.7.0.1
 */