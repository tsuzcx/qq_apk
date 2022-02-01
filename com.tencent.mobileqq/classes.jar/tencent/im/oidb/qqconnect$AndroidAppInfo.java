package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqconnect$AndroidAppInfo
  extends MessageMicro<AndroidAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "pack_name", "pack_sign", "apk_down_url", "url_scheme" }, new Object[] { "", "", "", "" }, AndroidAppInfo.class);
  public final PBStringField apk_down_url = PBField.initString("");
  public final PBStringField pack_name = PBField.initString("");
  public final PBStringField pack_sign = PBField.initString("");
  public final PBStringField url_scheme = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.AndroidAppInfo
 * JD-Core Version:    0.7.0.1
 */