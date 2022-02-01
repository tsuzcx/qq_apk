package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb60$ClientInfo
  extends MessageMicro<ClientInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "platform", "sdk_version", "android_package_name", "android_signature", "ios_bundle_id", "pc_sign" }, new Object[] { Integer.valueOf(0), "", "", "", "", "" }, ClientInfo.class);
  public final PBStringField android_package_name = PBField.initString("");
  public final PBStringField android_signature = PBField.initString("");
  public final PBStringField ios_bundle_id = PBField.initString("");
  public final PBStringField pc_sign = PBField.initString("");
  public final PBUInt32Field platform = PBField.initUInt32(0);
  public final PBStringField sdk_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xb60.ClientInfo
 * JD-Core Version:    0.7.0.1
 */