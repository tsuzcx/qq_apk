package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SubMsgType0x6f$PushLostDevFound
  extends MessageMicro<PushLostDevFound>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 48 }, new String[] { "uint32_msg_type", "uint32_dev_time", "uint64_din" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, PushLostDevFound.class);
  public final PBUInt32Field uint32_dev_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_din = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.PushLostDevFound
 * JD-Core Version:    0.7.0.1
 */