package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$RspBodySelfPhoneGetUrlV4
  extends MessageMicro<RspBodySelfPhoneGetUrlV4>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90 }, new String[] { "str_msg_id", "rpt_self_phone_url" }, new Object[] { "", null }, RspBodySelfPhoneGetUrlV4.class);
  public final PBRepeatMessageField<GatewayVerify.SelfPhoneUrl> rpt_self_phone_url = PBField.initRepeatMessage(GatewayVerify.SelfPhoneUrl.class);
  public final PBStringField str_msg_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspBodySelfPhoneGetUrlV4
 * JD-Core Version:    0.7.0.1
 */