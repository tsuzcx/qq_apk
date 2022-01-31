package tencent.im.s2c.msgtype0x210.submsgtype0xe5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Submsgtype0xe5$MsgBody$S2CCcAgentStatusChangePush
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_ready_device", "uint64_update_time", "uint32_device_sub_state" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, S2CCcAgentStatusChangePush.class);
  public final PBUInt32Field uint32_device_sub_state = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ready_device = PBField.initUInt32(0);
  public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xe5.Submsgtype0xe5.MsgBody.S2CCcAgentStatusChangePush
 * JD-Core Version:    0.7.0.1
 */