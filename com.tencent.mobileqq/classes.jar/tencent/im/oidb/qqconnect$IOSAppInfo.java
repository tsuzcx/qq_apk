package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqconnect$IOSAppInfo
  extends MessageMicro<IOSAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bundle_id", "url_scheme", "store_id" }, new Object[] { "", "", "" }, IOSAppInfo.class);
  public final PBStringField bundle_id = PBField.initString("");
  public final PBStringField store_id = PBField.initString("");
  public final PBStringField url_scheme = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.IOSAppInfo
 * JD-Core Version:    0.7.0.1
 */