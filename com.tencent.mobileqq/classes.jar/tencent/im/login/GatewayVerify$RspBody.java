package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 162 }, new String[] { "msg_rsp_third_login", "msg_rsp_self_phone" }, new Object[] { null, null }, RspBody.class);
  public GatewayVerify.RspBodySelfPhone msg_rsp_self_phone = new GatewayVerify.RspBodySelfPhone();
  public GatewayVerify.RspBodyThirdLogin msg_rsp_third_login = new GatewayVerify.RspBodyThirdLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspBody
 * JD-Core Version:    0.7.0.1
 */