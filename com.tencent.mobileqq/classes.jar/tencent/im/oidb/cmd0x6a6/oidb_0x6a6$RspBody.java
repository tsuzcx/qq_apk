package tencent.im.oidb.cmd0x6a6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6a6$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_read_count", "uint64_read_count", "uint32_ret_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
  public final PBUInt32Field uint32_read_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
  public final PBUInt64Field uint64_read_count = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6a6.oidb_0x6a6.RspBody
 * JD-Core Version:    0.7.0.1
 */