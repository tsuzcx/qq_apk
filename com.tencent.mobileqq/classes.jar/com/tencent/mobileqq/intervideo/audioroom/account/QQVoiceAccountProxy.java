package com.tencent.mobileqq.intervideo.audioroom.account;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.TicketManager;

public class QQVoiceAccountProxy
{
  public static String getPSkey(String paramString)
  {
    try
    {
      ToolAppRuntime localToolAppRuntime = (ToolAppRuntime)BaseApplicationImpl.getApplication().getRuntime();
      TicketManager localTicketManager = (TicketManager)localToolAppRuntime.getManager(2);
      if (localTicketManager == null) {
        return null;
      }
      paramString = localTicketManager.getPskey(localToolAppRuntime.getAccount(), paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      QLog.w("QQVoiceAccountProxy", 1, "get ticketManager fail:", paramString);
    }
    return null;
  }
  
  public static String getUin()
  {
    try
    {
      String str = ((ToolAppRuntime)BaseApplicationImpl.getApplication().getRuntime()).getAccount();
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.w("QQVoiceAccountProxy", 1, "get getUin fail:", localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.audioroom.account.QQVoiceAccountProxy
 * JD-Core Version:    0.7.0.1
 */