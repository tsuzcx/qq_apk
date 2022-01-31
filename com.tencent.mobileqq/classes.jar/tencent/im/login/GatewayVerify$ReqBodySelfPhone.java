package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$ReqBodySelfPhone
  extends MessageMicro<ReqBodySelfPhone>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "msg_req_check_phone", "msg_req_get_url" }, new Object[] { null, null }, ReqBodySelfPhone.class);
  public GatewayVerify.ReqBodySelfPhoneCheck msg_req_check_phone = new GatewayVerify.ReqBodySelfPhoneCheck();
  public GatewayVerify.ReqBodySelfPhoneGetUrl msg_req_get_url = new GatewayVerify.ReqBodySelfPhoneGetUrl();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodySelfPhone
 * JD-Core Version:    0.7.0.1
 */