package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GatewayVerify$RspBodyThirdLogin
  extends MessageMicro<RspBodyThirdLogin>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 88, 96, 162, 170, 178, 186 }, new String[] { "uint32_service_type", "uint64_qq_uin", "uint32_register_flag", "msg_rsp_google", "msg_rsp_facebook", "msg_rsp_phone", "msg_rsp_apple" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), null, null, null, null }, RspBodyThirdLogin.class);
  public GatewayVerify.RspBodyApple msg_rsp_apple = new GatewayVerify.RspBodyApple();
  public GatewayVerify.RspBodyFaceBook msg_rsp_facebook = new GatewayVerify.RspBodyFaceBook();
  public GatewayVerify.RspBodyGoogle msg_rsp_google = new GatewayVerify.RspBodyGoogle();
  public GatewayVerify.RspPhoneLogin msg_rsp_phone = new GatewayVerify.RspPhoneLogin();
  public final PBUInt32Field uint32_register_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_qq_uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspBodyThirdLogin
 * JD-Core Version:    0.7.0.1
 */