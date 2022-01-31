package tencent.im.oidb.cmd0x487;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x487$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_channel", "uint64_group", "uint64_subscribe_code" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReqBody.class);
  public final PBUInt32Field uint32_channel = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_subscribe_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x487.oidb_0x487.ReqBody
 * JD-Core Version:    0.7.0.1
 */