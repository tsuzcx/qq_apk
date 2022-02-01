package tencent.im.oidb.cmd0xb86;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xb86$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_client_type", "msg_modify_info", "msg_examine_callback_req", "msg_security_callback_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
  public oidb_cmd0xb86.ExamineCallBackReq msg_examine_callback_req = new oidb_cmd0xb86.ExamineCallBackReq();
  public oidb_cmd0xb86.ModifyInfo msg_modify_info = new oidb_cmd0xb86.ModifyInfo();
  public oidb_cmd0xb86.SecurityCallBackReq msg_security_callback_req = new oidb_cmd0xb86.SecurityCallBackReq();
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb86.oidb_cmd0xb86.ReqBody
 * JD-Core Version:    0.7.0.1
 */