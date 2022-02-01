package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$ReqBodySelfPhoneCheck
  extends MessageMicro<ReqBodySelfPhoneCheck>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 98, 104, 114 }, new String[] { "str_upurl", "str_token", "str_msg_id", "int32_channel_id", "str_cell_ip" }, new Object[] { "", "", "", Integer.valueOf(0), "" }, ReqBodySelfPhoneCheck.class);
  public final PBInt32Field int32_channel_id = PBField.initInt32(0);
  public final PBStringField str_cell_ip = PBField.initString("");
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_token = PBField.initString("");
  public final PBStringField str_upurl = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodySelfPhoneCheck
 * JD-Core Version:    0.7.0.1
 */