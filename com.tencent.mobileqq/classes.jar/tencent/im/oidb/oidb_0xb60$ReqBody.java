package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xb60$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90 }, new String[] { "client_info", "get_privilege_req", "check_url_req" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_0xb60.CheckUrlReq check_url_req = new oidb_0xb60.CheckUrlReq();
  public oidb_0xb60.ClientInfo client_info = new oidb_0xb60.ClientInfo();
  public oidb_0xb60.GetPrivilegeReq get_privilege_req = new oidb_0xb60.GetPrivilegeReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.ReqBody
 * JD-Core Version:    0.7.0.1
 */