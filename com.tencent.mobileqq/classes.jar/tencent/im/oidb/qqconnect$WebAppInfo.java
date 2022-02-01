package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqconnect$WebAppInfo
  extends MessageMicro<WebAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "website_url", "provider", "icp", "callback_url" }, new Object[] { "", "", "", "" }, WebAppInfo.class);
  public final PBStringField callback_url = PBField.initString("");
  public final PBStringField icp = PBField.initString("");
  public final PBStringField provider = PBField.initString("");
  public final PBStringField website_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.WebAppInfo
 * JD-Core Version:    0.7.0.1
 */