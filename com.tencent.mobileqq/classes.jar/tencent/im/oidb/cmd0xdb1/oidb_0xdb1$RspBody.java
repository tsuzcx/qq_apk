package tencent.im.oidb.cmd0xdb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdb1$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "uint64_allow_kuolie", "uint32_match_count", "str_func_name", "uint64_expire_time", "uint32_left_chat_time" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", Long.valueOf(0L), Integer.valueOf(0) }, RspBody.class);
  public final PBStringField str_func_name = PBField.initString("");
  public final PBUInt32Field uint32_left_chat_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_match_count = PBField.initUInt32(0);
  public final PBUInt64Field uint64_allow_kuolie = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdb1.oidb_0xdb1.RspBody
 * JD-Core Version:    0.7.0.1
 */