package tencent.im.oidb.cmd0xdcc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0xdcc$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_group_id", "em_entry", "rpt_uint64_filter_uin" }, new Object[] { Long.valueOf(0L), Integer.valueOf(11), Long.valueOf(0L) }, ReqBody.class);
  public final PBEnumField em_entry = PBField.initEnum(11);
  public final PBRepeatField<Long> rpt_uint64_filter_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_group_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcc.oidb_cmd0xdcc.ReqBody
 * JD-Core Version:    0.7.0.1
 */