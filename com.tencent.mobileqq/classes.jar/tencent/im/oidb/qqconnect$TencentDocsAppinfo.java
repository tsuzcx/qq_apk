package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqconnect$TencentDocsAppinfo
  extends MessageMicro<TencentDocsAppinfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "open_types", "opts", "ejs", "callback_url_test", "callback_url", "domain", "userinfo_callback", "userinfo_callback_test" }, new Object[] { "", "", "", "", "", "", "", "" }, TencentDocsAppinfo.class);
  public final PBStringField callback_url = PBField.initString("");
  public final PBStringField callback_url_test = PBField.initString("");
  public final PBStringField domain = PBField.initString("");
  public final PBStringField ejs = PBField.initString("");
  public final PBStringField open_types = PBField.initString("");
  public final PBStringField opts = PBField.initString("");
  public final PBStringField userinfo_callback = PBField.initString("");
  public final PBStringField userinfo_callback_test = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.TencentDocsAppinfo
 * JD-Core Version:    0.7.0.1
 */