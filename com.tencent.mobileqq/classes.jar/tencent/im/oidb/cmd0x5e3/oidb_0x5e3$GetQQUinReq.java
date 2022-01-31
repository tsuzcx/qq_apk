package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3$GetQQUinReq
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 160016, 160072, 160248, 560000, 560008, 560016, 560024, 560032, 800160 }, new String[] { "rpt_uint64_uins", "uint32_req_nick", "uint32_req_gender", "uint32_req_birthday", "uint32_req_remark", "uint32_req_netstatus", "uint32_req_qcall_id", "uint32_req_is_call_free", "uint32_req_auto_remark", "uint32_req_qcall_nick" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GetQQUinReq.class);
  public final PBRepeatField rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_req_auto_remark = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_is_call_free = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_netstatus = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_qcall_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_qcall_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_remark = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.GetQQUinReq
 * JD-Core Version:    0.7.0.1
 */