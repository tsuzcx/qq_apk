package com.tencent.mobileqq.guild.message.base;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.troop.data.MessageInfo;
import java.util.ArrayList;

public abstract class AbsGuildPushMessageProcessorCallback
  implements IGuildMessageCallback
{
  public void a(AppInterface paramAppInterface, int paramInt) {}
  
  public void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList) {}
  
  public void a(AppInterface paramAppInterface, ArrayList<MessageRecord> paramArrayList, MessageInfo paramMessageInfo) {}
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(AppInterface paramAppInterface)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.base.AbsGuildPushMessageProcessorCallback
 * JD-Core Version:    0.7.0.1
 */