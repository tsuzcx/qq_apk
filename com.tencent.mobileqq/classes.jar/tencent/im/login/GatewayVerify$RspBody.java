package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162, 242, 322, 402 }, new String[] { "msg_rsp_third_login", "msg_rsp_self_phone", "msg_rsp_connect_login", "msg_rsp_bind_phone_login", "msg_rsp_lft_info" }, new Object[] { null, null, null, null, null }, RspBody.class);
  public GatewayVerify.RspBindPhoneLogin msg_rsp_bind_phone_login = new GatewayVerify.RspBindPhoneLogin();
  public GatewayVerify.RspConnectLogin msg_rsp_connect_login = new GatewayVerify.RspConnectLogin();
  public GatewayVerify.RspLftInfo msg_rsp_lft_info = new GatewayVerify.RspLftInfo();
  public GatewayVerify.RspBodySelfPhone msg_rsp_self_phone = new GatewayVerify.RspBodySelfPhone();
  public GatewayVerify.RspBodyThirdLogin msg_rsp_third_login = new GatewayVerify.RspBodyThirdLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspBody
 * JD-Core Version:    0.7.0.1
 */