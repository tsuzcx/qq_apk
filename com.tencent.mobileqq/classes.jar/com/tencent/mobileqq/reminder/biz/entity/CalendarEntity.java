package com.tencent.mobileqq.reminder.biz.entity;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class CalendarEntity
  extends Entity
{
  public static final String TAG = "CalendarEntity.class";
  public String content;
  public String jump_url;
  @unique
  public String msg_id;
  public long notice_time;
  public String title;
  
  protected void postRead()
  {
    super.postRead();
  }
  
  protected void prewrite()
  {
    super.prewrite();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.reminder.biz.entity.CalendarEntity
 * JD-Core Version:    0.7.0.1
 */