package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class GatewayVerify$RspCmd9
  extends MessageMicro<RspCmd9>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82 }, new String[] { "msg_rsp_phone_sms_extend_login" }, new Object[] { null }, RspCmd9.class);
  public GatewayVerify.RspPhoneSmsExtendLogin msg_rsp_phone_sms_extend_login = new GatewayVerify.RspPhoneSmsExtendLogin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspCmd9
 * JD-Core Version:    0.7.0.1
 */