package com.tencent.mobileqq.guild.message.callback;

import androidx.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler.SendTextMsgParams;
import com.tencent.mobileqq.guild.message.base.AbsGuildSendMessageHandlerCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class GuildSendMessageCallbackConfig
{
  private static ArrayList<AbsGuildSendMessageHandlerCallback> a = new ArrayList();
  private static GuildSendMessageCallbackConfig b;
  
  private GuildSendMessageCallbackConfig()
  {
    b();
  }
  
  public static GuildSendMessageCallbackConfig a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new GuildSendMessageCallbackConfig();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void a(@NonNull AppInterface paramAppInterface, MessageRecord paramMessageRecord, IGuildSendMessageHandler.SendTextMsgParams paramSendTextMsgParams)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsGuildSendMessageHandlerCallback)localIterator.next()).a(paramAppInterface, paramMessageRecord, paramSendTextMsgParams);
    }
  }
  
  public static void a(MessageRecord paramMessageRecord)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext()) {
      ((AbsGuildSendMessageHandlerCallback)localIterator.next()).a(paramMessageRecord);
    }
  }
  
  void b()
  {
    if (GuildMessageCallbackRegister.a != null)
    {
      Iterator localIterator = GuildMessageCallbackRegister.a.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (Class)localIterator.next();
        try
        {
          localObject = (AbsGuildSendMessageHandlerCallback)((Class)localObject).newInstance();
          a.add(localObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.i("GuildSendMessageCallbackConfig", 1, "Init Fail", localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.callback.GuildSendMessageCallbackConfig
 * JD-Core Version:    0.7.0.1
 */