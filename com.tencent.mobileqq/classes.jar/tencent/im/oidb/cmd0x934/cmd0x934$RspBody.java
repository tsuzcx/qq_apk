package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x934$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "version", "lists", "robot_uin" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, RspBody.class);
  public final PBRepeatMessageField<cmd0x934.List> lists = PBField.initRepeatMessage(cmd0x934.List.class);
  public final PBUInt64Field robot_uin = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x934.cmd0x934.RspBody
 * JD-Core Version:    0.7.0.1
 */