package com.tencent.mobileqq.guild.message.base;

import com.tencent.mobileqq.data.MessageRecord;
import java.util.Comparator;

class BaseGuildMessageProcessor$1
  implements Comparator<MessageRecord>
{
  BaseGuildMessageProcessor$1(BaseGuildMessageProcessor paramBaseGuildMessageProcessor) {}
  
  public int a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    return (int)((paramMessageRecord1.shmsgseq - paramMessageRecord2.shmsgseq) % 2L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.BaseGuildMessageProcessor.1
 * JD-Core Version:    0.7.0.1
 */