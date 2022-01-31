package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xb60$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90 }, new String[] { "wording", "get_privilege_rsp", "check_url_rsp" }, new Object[] { "", null, null }, RspBody.class);
  public oidb_0xb60.CheckUrlRsp check_url_rsp = new oidb_0xb60.CheckUrlRsp();
  public oidb_0xb60.GetPrivilegeRsp get_privilege_rsp = new oidb_0xb60.GetPrivilegeRsp();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.RspBody
 * JD-Core Version:    0.7.0.1
 */