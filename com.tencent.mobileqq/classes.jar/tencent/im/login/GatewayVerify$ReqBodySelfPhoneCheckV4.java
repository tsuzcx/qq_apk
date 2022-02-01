package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$ReqBodySelfPhoneCheckV4
  extends MessageMicro<ReqBodySelfPhoneCheckV4>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 98 }, new String[] { "str_msg_id", "str_cell_ip", "rpt_self_phone_token" }, new Object[] { "", "", null }, ReqBodySelfPhoneCheckV4.class);
  public final PBRepeatMessageField<GatewayVerify.SelfPhoneToken> rpt_self_phone_token = PBField.initRepeatMessage(GatewayVerify.SelfPhoneToken.class);
  public final PBStringField str_cell_ip = PBField.initString("");
  public final PBStringField str_msg_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodySelfPhoneCheckV4
 * JD-Core Version:    0.7.0.1
 */