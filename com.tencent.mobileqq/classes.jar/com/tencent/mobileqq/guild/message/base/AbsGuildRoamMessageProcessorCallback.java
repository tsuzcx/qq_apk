package com.tencent.mobileqq.guild.message.base;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.ArrayList;

public abstract class AbsGuildRoamMessageProcessorCallback
  implements IGuildMessageCallback
{
  public abstract void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo);
  
  public abstract void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList1, ArrayList<MessageRecord> paramArrayList2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.AbsGuildRoamMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */