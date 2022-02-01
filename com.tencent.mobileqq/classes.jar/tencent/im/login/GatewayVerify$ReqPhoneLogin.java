package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$ReqPhoneLogin
  extends MessageMicro<ReqPhoneLogin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "str_country_code", "str_phone_num" }, new Object[] { "", "" }, ReqPhoneLogin.class);
  public final PBStringField str_country_code = PBField.initString("");
  public final PBStringField str_phone_num = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqPhoneLogin
 * JD-Core Version:    0.7.0.1
 */