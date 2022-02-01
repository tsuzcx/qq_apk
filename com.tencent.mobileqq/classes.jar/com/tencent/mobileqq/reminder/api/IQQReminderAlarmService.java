package com.tencent.mobileqq.reminder.api;

import Wallet.AcsMsg;
import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

@Service(process={"", "tool"})
public abstract interface IQQReminderAlarmService
  extends IRuntimeService
{
  public abstract void cancelAlarmById(int paramInt);
  
  public abstract void clearAllAlarm();
  
  public abstract void setAlarmTimer(AcsMsg paramAcsMsg);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.IQQReminderAlarmService
 * JD-Core Version:    0.7.0.1
 */