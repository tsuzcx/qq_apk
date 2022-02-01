package com.tencent.mobileqq.reminder.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.reminder.biz.entity.CalendarEntity;
import java.util.List;
import mqq.app.AppActivity;
import mqq.app.api.IRuntimeService;

@Service(needUin=false, process={"", "tool"})
public abstract interface IQQReminderCalendarService
  extends IRuntimeService
{
  public abstract void addCalendarEntity(CalendarEntity paramCalendarEntity);
  
  public abstract void deleteCalendarAlarm(AppActivity paramAppActivity, CalendarEntity paramCalendarEntity);
  
  public abstract void deleteCalendarEntity(CalendarEntity paramCalendarEntity);
  
  public abstract boolean isCalendarOpen(Context paramContext);
  
  public abstract List<CalendarEntity> queryCalendarEntity(String paramString);
  
  public abstract void setCalendarAlarm(AppActivity paramAppActivity, CalendarEntity paramCalendarEntity);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.api.IQQReminderCalendarService
 * JD-Core Version:    0.7.0.1
 */