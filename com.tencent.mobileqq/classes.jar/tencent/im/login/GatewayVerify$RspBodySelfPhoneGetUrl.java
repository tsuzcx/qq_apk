package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$RspBodySelfPhoneGetUrl
  extends MessageMicro<RspBodySelfPhoneGetUrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 82, 90, 96 }, new String[] { "str_upload_url", "str_msg_id", "int32_channel_id" }, new Object[] { "", "", Integer.valueOf(0) }, RspBodySelfPhoneGetUrl.class);
  public final PBInt32Field int32_channel_id = PBField.initInt32(0);
  public final PBStringField str_msg_id = PBField.initString("");
  public final PBStringField str_upload_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.RspBodySelfPhoneGetUrl
 * JD-Core Version:    0.7.0.1
 */