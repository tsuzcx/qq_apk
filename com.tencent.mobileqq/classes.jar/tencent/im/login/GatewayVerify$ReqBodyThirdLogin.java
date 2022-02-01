package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$ReqBodyThirdLogin
  extends MessageMicro<ReqBodyThirdLogin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88, 162, 170, 178, 186 }, new String[] { "uint32_service_type", "uin_account_type", "msg_req_google", "msg_req_facebook", "msg_req_phone", "msg_req_apple" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, ReqBodyThirdLogin.class);
  public GatewayVerify.ReqBodyApple msg_req_apple = new GatewayVerify.ReqBodyApple();
  public GatewayVerify.ReqBodyFaceBook msg_req_facebook = new GatewayVerify.ReqBodyFaceBook();
  public GatewayVerify.ReqBodyGoogle msg_req_google = new GatewayVerify.ReqBodyGoogle();
  public GatewayVerify.ReqPhoneLogin msg_req_phone = new GatewayVerify.ReqPhoneLogin();
  public final PBUInt32Field uin_account_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodyThirdLogin
 * JD-Core Version:    0.7.0.1
 */