package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xd55$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 90, 98, 106 }, new String[] { "appid", "app_type", "src_id", "raw_url", "is_need_appinfo", "check_app_sign_req", "check_user_req", "check_mini_app_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), null, null, null }, ReqBody.class);
  public final PBUInt32Field app_type = PBField.initUInt32(0);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public oidb_0xd55.CheckAppSignReq check_app_sign_req = new oidb_0xd55.CheckAppSignReq();
  public oidb_0xd55.CheckMiniAppReq check_mini_app_req = new oidb_0xd55.CheckMiniAppReq();
  public oidb_0xd55.CheckUserReq check_user_req = new oidb_0xd55.CheckUserReq();
  public final PBUInt32Field is_need_appinfo = PBField.initUInt32(0);
  public final PBStringField raw_url = PBField.initString("");
  public final PBUInt32Field src_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd55.ReqBody
 * JD-Core Version:    0.7.0.1
 */