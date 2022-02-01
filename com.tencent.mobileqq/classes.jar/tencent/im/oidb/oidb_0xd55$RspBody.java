package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xd55$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 90, 98, 106 }, new String[] { "wording", "appinfo", "check_app_sign_rsp", "check_user_rsp", "check_mini_app_rsp" }, new Object[] { "", null, null, null, null }, RspBody.class);
  public qqconnect.Appinfo appinfo = new qqconnect.Appinfo();
  public oidb_0xd55.CheckAppSignRsp check_app_sign_rsp = new oidb_0xd55.CheckAppSignRsp();
  public oidb_0xd55.CheckMiniAppRsp check_mini_app_rsp = new oidb_0xd55.CheckMiniAppRsp();
  public oidb_0xd55.CheckUserRsp check_user_rsp = new oidb_0xd55.CheckUserRsp();
  public final PBStringField wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55.RspBody
 * JD-Core Version:    0.7.0.1
 */