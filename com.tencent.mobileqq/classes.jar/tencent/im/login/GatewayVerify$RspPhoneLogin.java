package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$RspPhoneLogin
  extends MessageMicro<RspPhoneLogin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90 }, new String[] { "str_user_profile" }, new Object[] { "" }, RspPhoneLogin.class);
  public final PBStringField str_user_profile = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspPhoneLogin
 * JD-Core Version:    0.7.0.1
 */