package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162 }, new String[] { "msg_req_third_login", "msg_req_self_phone" }, new Object[] { null, null }, ReqBody.class);
  public GatewayVerify.ReqBodySelfPhone msg_req_self_phone = new GatewayVerify.ReqBodySelfPhone();
  public GatewayVerify.ReqBodyThirdLogin msg_req_third_login = new GatewayVerify.ReqBodyThirdLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBody
 * JD-Core Version:    0.7.0.1
 */