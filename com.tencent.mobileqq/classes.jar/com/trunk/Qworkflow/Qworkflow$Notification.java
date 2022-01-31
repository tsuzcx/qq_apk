package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class Qworkflow$Notification
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "msg_appid", "msg_workflow_change", "msg_schedule_change", "msg_todoitem_change" }, new Object[] { null, null, null, null }, Notification.class);
  public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
  public Qworkflow.ScheduleChangeNotification msg_schedule_change = new Qworkflow.ScheduleChangeNotification();
  public Qworkflow.TodoChangeNotification msg_todoitem_change = new Qworkflow.TodoChangeNotification();
  public Qworkflow.WorkflowChangeNotification msg_workflow_change = new Qworkflow.WorkflowChangeNotification();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\c222.jar
 * Qualified Name:     com.trunk.Qworkflow.Qworkflow.Notification
 * JD-Core Version:    0.7.0.1
 */