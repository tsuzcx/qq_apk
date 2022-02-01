package tencent.im.oidb.oidb_0xcf4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xcf4$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_from_uin", "uint64_to_uin", "eDateType", "bool_qzone_dna", "rpt_msg_common_reqbody" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(1), Boolean.valueOf(false), null }, ReqBody.class);
  public final PBBoolField bool_qzone_dna = PBField.initBool(false);
  public final PBEnumField eDateType = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_0xcf4.CommonBody> rpt_msg_common_reqbody = PBField.initRepeatMessage(oidb_0xcf4.CommonBody.class);
  public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xcf4.oidb_0xcf4.ReqBody
 * JD-Core Version:    0.7.0.1
 */