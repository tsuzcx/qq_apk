package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e3$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 104, 112, 122, 170 }, new String[] { "rpt_msg_get_qq_uin_req", "rpt_msg_get_qcall_uin_req", "uint64_timestamp", "uint32_max_rsp_len", "msg_qq_login_sig", "msg_get_phone_req" }, new Object[] { null, null, Long.valueOf(0L), Integer.valueOf(0), null, null }, ReqBody.class);
  public oidb_0x5e3.GetPhoneReq msg_get_phone_req = new oidb_0x5e3.GetPhoneReq();
  public oidb_0x5e3.QQLoginSig msg_qq_login_sig = new oidb_0x5e3.QQLoginSig();
  public oidb_0x5e3.GetQCallUinReq rpt_msg_get_qcall_uin_req = new oidb_0x5e3.GetQCallUinReq();
  public oidb_0x5e3.GetQQUinReq rpt_msg_get_qq_uin_req = new oidb_0x5e3.GetQQUinReq();
  public final PBUInt32Field uint32_max_rsp_len = PBField.initUInt32(0);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e3.oidb_0x5e3.ReqBody
 * JD-Core Version:    0.7.0.1
 */