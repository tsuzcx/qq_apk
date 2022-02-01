package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$SelfPhoneToken
  extends MessageMicro<SelfPhoneToken>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 88 }, new String[] { "str_token", "int32_channel_id" }, new Object[] { "", Integer.valueOf(0) }, SelfPhoneToken.class);
  public final PBInt32Field int32_channel_id = PBField.initInt32(0);
  public final PBStringField str_token = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.SelfPhoneToken
 * JD-Core Version:    0.7.0.1
 */