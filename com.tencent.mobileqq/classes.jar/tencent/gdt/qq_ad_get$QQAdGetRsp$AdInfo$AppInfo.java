package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$AppInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 64, 72, 82, 90 }, new String[] { "app_name", "app_score", "app_package_name", "app_package_size", "app_package_version", "app_logo_url", "pkg_url", "ios_app_id", "android_app_id", "pkg_download_schema", "customized_invoke_url" }, new Object[] { "", "", "", Long.valueOf(0L), "", "", "", Long.valueOf(0L), Long.valueOf(0L), "", "" }, AppInfo.class);
  public final PBUInt64Field android_app_id = PBField.initUInt64(0L);
  public final PBStringField app_logo_url = PBField.initString("");
  public final PBStringField app_name = PBField.initString("");
  public final PBStringField app_package_name = PBField.initString("");
  public final PBUInt64Field app_package_size = PBField.initUInt64(0L);
  public final PBStringField app_package_version = PBField.initString("");
  public final PBStringField app_score = PBField.initString("");
  public final PBStringField customized_invoke_url = PBField.initString("");
  public final PBUInt64Field ios_app_id = PBField.initUInt64(0L);
  public final PBStringField pkg_download_schema = PBField.initString("");
  public final PBStringField pkg_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.AppInfo
 * JD-Core Version:    0.7.0.1
 */