package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 42, 82, 162, 242, 322, 402, 482, 562, 570 }, new String[] { "msg_req_client_info", "msg_req_third_login", "msg_req_self_phone", "msg_req_connect_login", "msg_req_bind_phone_login", "msg_req_mask_qq_login", "msg_req_cmd_9", "msg_req_cmd_17", "msg_req_cmd_18" }, new Object[] { null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public GatewayVerify.ReqBindPhoneLogin msg_req_bind_phone_login = new GatewayVerify.ReqBindPhoneLogin();
  public GatewayVerify.ReqClientInfo msg_req_client_info = new GatewayVerify.ReqClientInfo();
  public GatewayVerify.ReqCmd17 msg_req_cmd_17 = new GatewayVerify.ReqCmd17();
  public GatewayVerify.ReqCmd18 msg_req_cmd_18 = new GatewayVerify.ReqCmd18();
  public GatewayVerify.ReqCmd9 msg_req_cmd_9 = new GatewayVerify.ReqCmd9();
  public GatewayVerify.ReqConnectLogin msg_req_connect_login = new GatewayVerify.ReqConnectLogin();
  public GatewayVerify.ReqMaskQQLogin msg_req_mask_qq_login = new GatewayVerify.ReqMaskQQLogin();
  public GatewayVerify.ReqBodySelfPhone msg_req_self_phone = new GatewayVerify.ReqBodySelfPhone();
  public GatewayVerify.ReqBodyThirdLogin msg_req_third_login = new GatewayVerify.ReqBodyThirdLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBody
 * JD-Core Version:    0.7.0.1
 */