package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class subcmd0x111$SubCmd0x111ReqBody
  extends MessageMicro<SubCmd0x111ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint32_start_time", "rpt_uint32_fieldlist", "rpt_uint64_uinlist" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, SubCmd0x111ReqBody.class);
  public final PBRepeatField<Integer> rpt_uint32_fieldlist = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_uinlist = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x111.SubCmd0x111ReqBody
 * JD-Core Version:    0.7.0.1
 */