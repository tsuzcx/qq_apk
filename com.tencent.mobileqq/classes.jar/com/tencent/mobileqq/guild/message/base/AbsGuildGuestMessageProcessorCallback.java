package com.tencent.mobileqq.guild.message.base;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.ArrayList;

public abstract class AbsGuildGuestMessageProcessorCallback
  implements IGuildMessageCallback
{
  public abstract void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.AbsGuildGuestMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */