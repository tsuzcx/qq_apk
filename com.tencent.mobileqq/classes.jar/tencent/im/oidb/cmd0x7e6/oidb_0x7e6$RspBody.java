package tencent.im.oidb.cmd0x7e6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x7e6$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "opt_uint32_switch_on", "opt_uint32_num", "rpt_string_pics", "opt_uint64_group_id", "opt_string_url" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", Long.valueOf(0L), "" }, RspBody.class);
  public final PBStringField opt_string_url = PBField.initString("");
  public final PBUInt32Field opt_uint32_num = PBField.initUInt32(0);
  public final PBUInt32Field opt_uint32_switch_on = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_group_id = PBField.initUInt64(0L);
  public final PBRepeatField<String> rpt_string_pics = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7e6.oidb_0x7e6.RspBody
 * JD-Core Version:    0.7.0.1
 */