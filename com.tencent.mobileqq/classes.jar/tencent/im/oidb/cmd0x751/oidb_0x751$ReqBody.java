package tencent.im.oidb.cmd0x751;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x751$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_sub_cmd", "msg_req_check_is_conf_member" }, new Object[] { Integer.valueOf(0), null }, ReqBody.class);
  public oidb_0x751.ReqCheckIsConfMember msg_req_check_is_conf_member = new oidb_0x751.ReqCheckIsConfMember();
  public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x751.oidb_0x751.ReqBody
 * JD-Core Version:    0.7.0.1
 */