package tencent.im.oidb.cmd0x72d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x72d$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "opt_uint32_ret_code", "rpt_uint64_groupcode", "opt_uint64_timestamp" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, RspBody.class);
  public final PBUInt32Field opt_uint32_ret_code = PBField.initUInt32(0);
  public final PBUInt64Field opt_uint64_timestamp = PBField.initUInt64(0L);
  public final PBRepeatField<Long> rpt_uint64_groupcode = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x72d.cmd0x72d.RspBody
 * JD-Core Version:    0.7.0.1
 */