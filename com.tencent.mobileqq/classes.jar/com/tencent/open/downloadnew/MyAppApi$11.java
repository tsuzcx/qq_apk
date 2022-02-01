package com.tencent.open.downloadnew;

import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.open.base.LogUtility;
import com.tencent.open.base.TicketUtils;
import com.tencent.open.base.TicketUtils.TicketCallback;
import com.tencent.tmassistantsdk.TMAssistantCallYYBParamStruct;
import mqq.os.MqqHandler;

class MyAppApi$11
  implements TicketUtils.TicketCallback
{
  MyAppApi$11(MyAppApi paramMyAppApi, TicketUtils paramTicketUtils, TMAssistantCallYYBParamStruct paramTMAssistantCallYYBParamStruct, Bundle paramBundle, long paramLong, Context paramContext, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a()
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1Fail");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.11.2(this));
  }
  
  public void a(String paramString, byte[] paramArrayOfByte)
  {
    LogUtility.c("TIME-STATISTIC", "onGetA1");
    ThreadManager.getSubThreadHandler().post(new MyAppApi.11.1(this, paramArrayOfByte, paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.11
 * JD-Core Version:    0.7.0.1
 */