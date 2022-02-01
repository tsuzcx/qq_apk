package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xc05$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 82, 90 }, new String[] { "wording", "get_create_app_list_rsp", "get_auth_app_list_rsp" }, new Object[] { "", null, null }, RspBody.class);
  public oidb_0xc05.GetAuthAppListRsp get_auth_app_list_rsp = new oidb_0xc05.GetAuthAppListRsp();
  public oidb_0xc05.GetCreateAppListRsp get_create_app_list_rsp = new oidb_0xc05.GetCreateAppListRsp();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc05.RspBody
 * JD-Core Version:    0.7.0.1
 */