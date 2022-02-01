package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$ReqBodySelfPhone
  extends MessageMicro<ReqBodySelfPhone>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 98, 106, 114 }, new String[] { "msg_req_check_phone", "msg_req_get_url", "msg_req_check_phone_v4", "msg_req_get_url_v4", "msg_req_phone_login" }, new Object[] { null, null, null, null, null }, ReqBodySelfPhone.class);
  public GatewayVerify.ReqBodySelfPhoneCheck msg_req_check_phone = new GatewayVerify.ReqBodySelfPhoneCheck();
  public GatewayVerify.ReqBodySelfPhoneCheckV4 msg_req_check_phone_v4 = new GatewayVerify.ReqBodySelfPhoneCheckV4();
  public GatewayVerify.ReqBodySelfPhoneGetUrl msg_req_get_url = new GatewayVerify.ReqBodySelfPhoneGetUrl();
  public GatewayVerify.ReqBodySelfPhoneGetUrlV4 msg_req_get_url_v4 = new GatewayVerify.ReqBodySelfPhoneGetUrlV4();
  public GatewayVerify.ReqBodySelfPhoneLogin msg_req_phone_login = new GatewayVerify.ReqBodySelfPhoneLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodySelfPhone
 * JD-Core Version:    0.7.0.1
 */