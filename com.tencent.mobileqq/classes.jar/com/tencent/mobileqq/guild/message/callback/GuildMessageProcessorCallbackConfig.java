package com.tencent.mobileqq.guild.message.callback;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.base.AbsGuildMessageProcessorCallback;
import com.tencent.mobileqq.troop.data.MessageInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildMessageProcessorCallbackConfig
{
  private static ArrayList<AbsGuildMessageProcessorCallback> a = new ArrayList();
  private static GuildMessageProcessorCallbackConfig b;
  
  private GuildMessageProcessorCallbackConfig()
  {
    b();
  }
  
  public static GuildMessageProcessorCallbackConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new GuildMessageProcessorCallbackConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void a(AppInterface paramAppInterface, MessageInfo paramMessageInfo1, MessageInfo paramMessageInfo2, MessageRecord paramMessageRecord)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsGuildMessageProcessorCallback)localIterator.next()).a(paramAppInterface, paramMessageInfo1, paramMessageInfo2, paramMessageRecord);
    }
  }
  
  public static void a(MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsGuildMessageProcessorCallback)localIterator.next()).a(paramMessageRecord1, paramMessageRecord2);
    }
  }
  
  void b()
  {
    if (GuildMessageCallbackRegister.b != null)
    {
      Iterator localIterator = GuildMessageCallbackRegister.b.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsGuildMessageProcessorCallback)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("GuildMessageProcessorCallbackConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.callback.GuildMessageProcessorCallbackConfig
 * JD-Core Version:    0.7.0.1
 */