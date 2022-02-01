package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 104, 112, 120, 128, 136, 170 }, new String[] { "rpt_msg_get_qq_uin_rsps", "rpt_msg_get_qcall_uin_rsps", "rpt_uint64_unfilled_qq_uins", "rpt_uint64_unfilled_qcall_uins", "rpt_uint64_not_exist_qq_uins", "rpt_uint64_not_exist_qcall_uins", "uint64_timestamp", "rpt_msg_get_phone_rsps" }, new Object[] { null, null, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0x5e3.GetPhoneRsp> rpt_msg_get_phone_rsps = PBField.initRepeatMessage(oidb_0x5e3.GetPhoneRsp.class);
  public final PBRepeatMessageField<oidb_0x5e3.GetQCallUinRsp> rpt_msg_get_qcall_uin_rsps = PBField.initRepeatMessage(oidb_0x5e3.GetQCallUinRsp.class);
  public final PBRepeatMessageField<oidb_0x5e3.GetQQUinRsp> rpt_msg_get_qq_uin_rsps = PBField.initRepeatMessage(oidb_0x5e3.GetQQUinRsp.class);
  public final PBRepeatField<Long> rpt_uint64_not_exist_qcall_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_not_exist_qq_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_unfilled_qcall_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_unfilled_qq_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.RspBody
 * JD-Core Version:    0.7.0.1
 */