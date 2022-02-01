package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GatewayVerify$ReqBodyFaceBook
  extends MessageMicro<ReqBodyFaceBook>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "str_appid", "str_access_token" }, new Object[] { "", "" }, ReqBodyFaceBook.class);
  public final PBStringField str_access_token = PBField.initString("");
  public final PBStringField str_appid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.login.GatewayVerify.ReqBodyFaceBook
 * JD-Core Version:    0.7.0.1
 */