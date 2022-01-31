package tencent.im.reminder;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class im_reminder$Request$CheckEnable
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "reminder" }, new Object[] { null }, CheckEnable.class);
  public im_reminder.Reminder reminder = new im_reminder.Reminder();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.Request.CheckEnable
 * JD-Core Version:    0.7.0.1
 */