package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$RspBodySelfPhone
  extends MessageMicro<RspBodySelfPhone>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 98 }, new String[] { "msg_rsp_check_phone", "msg_rsp_get_url", "msg_rsp_get_url_v4" }, new Object[] { null, null, null }, RspBodySelfPhone.class);
  public GatewayVerify.RspBodySelfPhoneCheck msg_rsp_check_phone = new GatewayVerify.RspBodySelfPhoneCheck();
  public GatewayVerify.RspBodySelfPhoneGetUrl msg_rsp_get_url = new GatewayVerify.RspBodySelfPhoneGetUrl();
  public GatewayVerify.RspBodySelfPhoneGetUrlV4 msg_rsp_get_url_v4 = new GatewayVerify.RspBodySelfPhoneGetUrlV4();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspBodySelfPhone
 * JD-Core Version:    0.7.0.1
 */