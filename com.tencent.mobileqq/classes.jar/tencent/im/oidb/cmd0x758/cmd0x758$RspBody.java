package tencent.im.oidb.cmd0x758;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x758$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_group_code", "uint64_current_max_msgseq", "string_verify_url", "uint32_verify_type" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), "", Integer.valueOf(0) }, RspBody.class);
  public final PBStringField string_verify_url = PBField.initString("");
  public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_current_max_msgseq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x758.cmd0x758.RspBody
 * JD-Core Version:    0.7.0.1
 */