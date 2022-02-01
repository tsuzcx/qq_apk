package com.tencent.mobileqq.guild.message.pbsendhandler;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BeforeSendGuildMsgPbHandlerImpl
{
  private static List<Class<? extends IBeforeSendGuildMsgPbHandler>> a = new ArrayList();
  
  static
  {
    a.add(GeneralFlagSendHandler.class);
  }
  
  private static <T> T a(Class<? extends T> paramClass)
  {
    try
    {
      paramClass = paramClass.newInstance();
      return paramClass;
    }
    catch (Exception paramClass)
    {
      QLog.e("BeforeSendGuildMsgPbHandlerImpl", 1, paramClass, new Object[0]);
    }
    return null;
  }
  
  public static ArrayList<IBeforeSendGuildMsgPbHandler> a()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      IBeforeSendGuildMsgPbHandler localIBeforeSendGuildMsgPbHandler = (IBeforeSendGuildMsgPbHandler)a((Class)localIterator.next());
      if (localIBeforeSendGuildMsgPbHandler != null) {
        localArrayList.add(localIBeforeSendGuildMsgPbHandler);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.message.pbsendhandler.BeforeSendGuildMsgPbHandlerImpl
 * JD-Core Version:    0.7.0.1
 */