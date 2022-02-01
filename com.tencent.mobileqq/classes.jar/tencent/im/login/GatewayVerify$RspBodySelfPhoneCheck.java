package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$RspBodySelfPhoneCheck
  extends MessageMicro<RspBodySelfPhoneCheck>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field int32_channel_carrier_type = PBField.initInt32(0);
  public final PBInt32Field int32_channel_id = PBField.initInt32(0);
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_upload_redirect_url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 96, 104 }, new String[] { "str_upload_redirect_url", "str_msg_id", "int32_channel_id", "int32_channel_carrier_type" }, new Object[] { "", "", localInteger, localInteger }, RspBodySelfPhoneCheck.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspBodySelfPhoneCheck
 * JD-Core Version:    0.7.0.1
 */