package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xc05$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "get_create_app_list_req", "get_auth_app_list_req" }, new Object[] { null, null }, ReqBody.class);
  public oidb_0xc05.GetAuthAppListReq get_auth_app_list_req = new oidb_0xc05.GetAuthAppListReq();
  public oidb_0xc05.GetCreateAppListReq get_create_app_list_req = new oidb_0xc05.GetCreateAppListReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc05.ReqBody
 * JD-Core Version:    0.7.0.1
 */