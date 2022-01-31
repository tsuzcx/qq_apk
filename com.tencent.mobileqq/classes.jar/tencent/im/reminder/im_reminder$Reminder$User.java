package tencent.im.reminder;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class im_reminder$Reminder$User
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uin", "group_code", "discuss_uin" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, User.class);
  public final PBUInt64Field discuss_uin = PBField.initUInt64(0L);
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.reminder.im_reminder.Reminder.User
 * JD-Core Version:    0.7.0.1
 */