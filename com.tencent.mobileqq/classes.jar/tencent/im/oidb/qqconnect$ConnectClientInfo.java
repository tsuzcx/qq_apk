package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqconnect$ConnectClientInfo
  extends MessageMicro<ConnectClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 170, 178, 250, 258, 266, 330 }, new String[] { "platform", "sdk_version", "system_name", "system_version", "android_package_name", "android_signature", "ios_bundle_id", "ios_device_id", "ios_app_token", "pc_sign" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", "", "", "", "" }, ConnectClientInfo.class);
  public final PBStringField android_package_name = PBField.initString("");
  public final PBStringField android_signature = PBField.initString("");
  public final PBStringField ios_app_token = PBField.initString("");
  public final PBStringField ios_bundle_id = PBField.initString("");
  public final PBStringField ios_device_id = PBField.initString("");
  public final PBStringField pc_sign = PBField.initString("");
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBStringField sdk_version = PBField.initString("");
  public final PBStringField system_name = PBField.initString("");
  public final PBStringField system_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.qqconnect.ConnectClientInfo
 * JD-Core Version:    0.7.0.1
 */