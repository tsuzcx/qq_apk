package tencent.im.s2c.msgtype0x210.submsgtype0x54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class submsgtype0x54$MsgBody
  extends MessageMicro<MsgBody>
{
  public static final int TYPE_C2C = 1;
  public static final int TYPE_DISCUSS = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "peer_type", "peer_uin", "task_list" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), null }, MsgBody.class);
  public final PBEnumField peer_type = PBField.initEnum(1);
  public final PBUInt64Field peer_uin = PBField.initUInt64(0L);
  public final PBRepeatMessageField<submsgtype0x54.MsgBody.TaskInfo> task_list = PBField.initRepeatMessage(submsgtype0x54.MsgBody.TaskInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x54.submsgtype0x54.MsgBody
 * JD-Core Version:    0.7.0.1
 */