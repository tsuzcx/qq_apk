package com.tencent.mobileqq.guild.message.base;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.ArrayList;

public abstract class AbsGuildOfflineMessageProcessorCallback
  implements IGuildMessageCallback
{
  public void a(AppInterface paramAppInterface, String paramString, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo) {}
  
  public void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.AbsGuildOfflineMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */