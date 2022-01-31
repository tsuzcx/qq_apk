package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xb60$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82 }, new String[] { "wording", "get_privilege_rsp" }, new Object[] { "", null }, RspBody.class);
  public oidb_0xb60.GetPrivilegeRsp get_privilege_rsp = new oidb_0xb60.GetPrivilegeRsp();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.RspBody
 * JD-Core Version:    0.7.0.1
 */