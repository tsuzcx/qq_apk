package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$ReqBodySelfPhoneGetUrl
  extends MessageMicro<ReqBodySelfPhoneGetUrl>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80, 90, 98, 104 }, new String[] { "uint32_get_upload_url", "str_mobile_phone", "str_cell_ip", "uint32_isp_type" }, new Object[] { Integer.valueOf(0), "", "", Integer.valueOf(0) }, ReqBodySelfPhoneGetUrl.class);
  public final PBStringField str_cell_ip = PBField.initString("");
  public final PBStringField str_mobile_phone = PBField.initString("");
  public final PBUInt32Field uint32_get_upload_url = PBField.initUInt32(0);
  public final PBUInt32Field uint32_isp_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodySelfPhoneGetUrl
 * JD-Core Version:    0.7.0.1
 */