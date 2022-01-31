package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class SubMsgType0x6f$BirthdayReminderPush
  extends MessageMicro<BirthdayReminderPush>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_reminder_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 16034 }, new String[] { "bytes_reminder_wording" }, new Object[] { localByteStringMicro }, BirthdayReminderPush.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.BirthdayReminderPush
 * JD-Core Version:    0.7.0.1
 */