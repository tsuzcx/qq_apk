package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_common$DeviceExt$AttriDeviceInfo
  extends MessageMicro<AttriDeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "id_info", "sid_h", "uuid", "wm_h", "ua", "iv", "app_bundle_id", "wifi_name" }, new Object[] { null, "", null, "", "", "", "", "" }, AttriDeviceInfo.class);
  public final PBStringField app_bundle_id = PBField.initString("");
  public final PBRepeatMessageField<qq_common.DeviceExt.IdInfo> id_info = PBField.initRepeatMessage(qq_common.DeviceExt.IdInfo.class);
  public final PBStringField iv = PBField.initString("");
  public final PBStringField sid_h = PBField.initString("");
  public final PBStringField ua = PBField.initString("");
  public qq_common.DeviceExt.UUID uuid = new qq_common.DeviceExt.UUID();
  public final PBStringField wifi_name = PBField.initString("");
  public final PBStringField wm_h = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.AttriDeviceInfo
 * JD-Core Version:    0.7.0.1
 */