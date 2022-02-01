package com.tencent.mobileqq.reminder.api;

import Wallet.AcsMsg;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.reminder.OnDeleteReminderFailListener;
import com.tencent.mobileqq.reminder.OnGetReminderFromDBFinishListener;
import com.tencent.mobileqq.reminder.OnGetReminderListByDayListener;
import com.tencent.mobileqq.reminder.QQNotifyListener;
import com.tencent.mobileqq.reminder.biz.entity.IReminderEntity;
import java.util.List;
import mqq.app.api.IRuntimeService;

@Service(process={"", "tool"})
public abstract interface IQQReminderDataService
  extends IRuntimeService
{
  public abstract void checkTodayReminder();
  
  public abstract void deleteReminderByMsgId(String paramString, OnDeleteReminderFailListener paramOnDeleteReminderFailListener);
  
  public abstract void doNotifaction(String paramString1, String paramString2);
  
  public abstract void doNotifyByPush(AcsMsg paramAcsMsg);
  
  public abstract List<String> getCacheKeyList();
  
  public abstract IReminderEntity getEntityByKey(String paramString);
  
  public abstract void getReminderListByday(String paramString, OnGetReminderListByDayListener paramOnGetReminderListByDayListener);
  
  public abstract void getTodayReminderMsgAsync(OnGetReminderFromDBFinishListener paramOnGetReminderFromDBFinishListener, boolean paramBoolean);
  
  public abstract void saveReminderMsg(AcsMsg paramAcsMsg);
  
  public abstract void setQQNotifyListener(QQNotifyListener paramQQNotifyListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.IQQReminderDataService
 * JD-Core Version:    0.7.0.1
 */