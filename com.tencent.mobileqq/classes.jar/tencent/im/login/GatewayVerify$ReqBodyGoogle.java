package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$ReqBodyGoogle
  extends MessageMicro<ReqBodyGoogle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "str_appid", "str_id_token" }, new Object[] { "", "" }, ReqBodyGoogle.class);
  public final PBStringField str_appid = PBField.initString("");
  public final PBStringField str_id_token = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodyGoogle
 * JD-Core Version:    0.7.0.1
 */