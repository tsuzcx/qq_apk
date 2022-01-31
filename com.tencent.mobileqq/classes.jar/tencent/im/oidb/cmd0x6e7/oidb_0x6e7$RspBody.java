package tencent.im.oidb.cmd0x6e7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x6e7$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_is_white", "uint32_interval", "int64_data" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, RspBody.class);
  public final PBInt64Field int64_data = PBField.initInt64(0L);
  public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_white = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6e7.oidb_0x6e7.RspBody
 * JD-Core Version:    0.7.0.1
 */