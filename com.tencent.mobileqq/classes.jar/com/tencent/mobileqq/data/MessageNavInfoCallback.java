package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.data.MessageNavInfo.Callback;
import mqq.app.AppRuntime;

public class MessageNavInfoCallback
  implements MessageNavInfo.Callback
{
  public int a(AppRuntime paramAppRuntime, String paramString, int paramInt)
  {
    paramAppRuntime = ((TroopManager)paramAppRuntime.getManager(QQManagerFactory.TROOP_MANAGER)).c(paramString);
    int i = paramInt;
    if (paramAppRuntime != null)
    {
      i = paramInt;
      if (paramAppRuntime.hasOrgs()) {
        i = 14;
      }
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageNavInfoCallback
 * JD-Core Version:    0.7.0.1
 */