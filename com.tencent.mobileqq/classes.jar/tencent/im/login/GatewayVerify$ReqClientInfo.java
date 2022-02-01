package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GatewayVerify$ReqClientInfo
  extends MessageMicro<ReqClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "str_client_qua", "uint32_client_platform" }, new Object[] { "", Integer.valueOf(0) }, ReqClientInfo.class);
  public final PBStringField str_client_qua = PBField.initString("");
  public final PBUInt32Field uint32_client_platform = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqClientInfo
 * JD-Core Version:    0.7.0.1
 */