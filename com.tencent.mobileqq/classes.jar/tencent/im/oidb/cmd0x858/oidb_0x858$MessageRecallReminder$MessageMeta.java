package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x858$MessageRecallReminder$MessageMeta
  extends MessageMicro<MessageMeta>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_seq", "uint32_time", "uint32_msg_random" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, MessageMeta.class);
  public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x858.oidb_0x858.MessageRecallReminder.MessageMeta
 * JD-Core Version:    0.7.0.1
 */