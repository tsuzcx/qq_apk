package tencent.im.oidb.cmd0x74f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x74f$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "uint32_ret_code", "range", "uint64_next_pull_time", "bool_display_entrance" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L), Boolean.valueOf(false) }, RspBody.class);
  public final PBBoolField bool_display_entrance = PBField.initBool(false);
  public final PBRepeatMessageField<oidb_cmd0x74f.Range> range = PBField.initRepeatMessage(oidb_cmd0x74f.Range.class);
  public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
  public final PBUInt64Field uint64_next_pull_time = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.RspBody
 * JD-Core Version:    0.7.0.1
 */