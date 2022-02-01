package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$ReqCmd17
  extends MessageMicro<ReqCmd17>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 82 }, new String[] { "uint32_country_code", "str_mobile_phone", "msg_req_phone_sms_extend_login" }, new Object[] { Integer.valueOf(0), "", null }, ReqCmd17.class);
  public GatewayVerify.ReqPhoneSmsExtendLogin msg_req_phone_sms_extend_login = new GatewayVerify.ReqPhoneSmsExtendLogin();
  public final PBStringField str_mobile_phone = PBField.initString("");
  public final PBUInt32Field uint32_country_code = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqCmd17
 * JD-Core Version:    0.7.0.1
 */