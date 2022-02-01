package com.tencent.mobileqq.reminder.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import java.util.ArrayList;
import mqq.app.api.IRuntimeService;
import mqq.observer.BusinessObserver;

@Service(process={""})
public abstract interface IQQReminderService
  extends IRuntimeService
{
  public abstract void queryNotifyIsSubscribed(String paramString, BusinessObserver paramBusinessObserver);
  
  public abstract void sendAckMsgs(ArrayList<String> paramArrayList, BusinessObserver paramBusinessObserver);
  
  public abstract void sendBatchSubscribeReminder(ArrayList<String> paramArrayList, String paramString, BusinessObserver paramBusinessObserver);
  
  public abstract void sendDelReminderListById(String paramString, long paramLong, int paramInt, BusinessObserver paramBusinessObserver);
  
  public abstract void sendGetMsgs(String paramString1, String paramString2, BusinessObserver paramBusinessObserver);
  
  public abstract void sendReminderList(int paramInt1, int paramInt2, BusinessObserver paramBusinessObserver);
  
  public abstract void sendReminderListByDay(String paramString, BusinessObserver paramBusinessObserver);
  
  public abstract void sendSubscribeReminder(String paramString1, String paramString2, BusinessObserver paramBusinessObserver);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.IQQReminderService
 * JD-Core Version:    0.7.0.1
 */