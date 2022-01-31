package tencent.im.oidb.cmd0xd82;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xd82$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_entrance", "uint32_redpoint", "uint64_blocked_uin" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
  public final PBUInt32Field uint32_entrance = PBField.initUInt32(0);
  public final PBUInt32Field uint32_redpoint = PBField.initUInt32(0);
  public final PBUInt64Field uint64_blocked_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd82.oidb_cmd0xd82.RspBody
 * JD-Core Version:    0.7.0.1
 */