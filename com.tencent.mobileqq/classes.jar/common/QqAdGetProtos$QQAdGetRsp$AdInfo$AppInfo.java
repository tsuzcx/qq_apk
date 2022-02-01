package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class QqAdGetProtos$QQAdGetRsp$AdInfo$AppInfo
  extends MessageMicro<AppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 112 }, new String[] { "app_name", "app_score", "app_package_name", "app_package_size", "app_package_version", "app_logo_url", "pkg_url", "ios_app_id", "android_app_id", "pkg_download_schema", "customized_invoke_url", "channel_id", "app_score_num", "download_num" }, new Object[] { "", "", "", Long.valueOf(0L), "", "", "", "", "", "", "", "", Integer.valueOf(0), Long.valueOf(0L) }, AppInfo.class);
  public final PBStringField android_app_id = PBField.initString("");
  public final PBStringField app_logo_url = PBField.initString("");
  public final PBStringField app_name = PBField.initString("");
  public final PBStringField app_package_name = PBField.initString("");
  public final PBUInt64Field app_package_size = PBField.initUInt64(0L);
  public final PBStringField app_package_version = PBField.initString("");
  public final PBStringField app_score = PBField.initString("");
  public final PBUInt32Field app_score_num = PBField.initUInt32(0);
  public final PBStringField channel_id = PBField.initString("");
  public final PBStringField customized_invoke_url = PBField.initString("");
  public final PBUInt64Field download_num = PBField.initUInt64(0L);
  public final PBStringField ios_app_id = PBField.initString("");
  public final PBStringField pkg_download_schema = PBField.initString("");
  public final PBStringField pkg_url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGetRsp.AdInfo.AppInfo
 * JD-Core Version:    0.7.0.1
 */