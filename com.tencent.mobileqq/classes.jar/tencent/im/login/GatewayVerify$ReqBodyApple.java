package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$ReqBodyApple
  extends MessageMicro<ReqBodyApple>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98, 106, 114, 242, 250 }, new String[] { "str_appid", "str_user_id", "str_identity_token", "str_authorization_code", "str_nick_name", "str_gender" }, new Object[] { "", "", "", "", "", "" }, ReqBodyApple.class);
  public final PBStringField str_appid = PBField.initString("");
  public final PBStringField str_authorization_code = PBField.initString("");
  public final PBStringField str_gender = PBField.initString("");
  public final PBStringField str_identity_token = PBField.initString("");
  public final PBStringField str_nick_name = PBField.initString("");
  public final PBStringField str_user_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodyApple
 * JD-Core Version:    0.7.0.1
 */