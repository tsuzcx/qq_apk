package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet$DeviceInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66, 74, 82 }, new String[] { "muid", "muid_type", "conn", "carrier_code", "os_ver", "qq_ver", "os_type", "client_ip", "ios_qidfa", "location" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null }, DeviceInfo.class);
  public final PBUInt32Field carrier_code = PBField.initUInt32(0);
  public final PBStringField client_ip = PBField.initString("");
  public final PBUInt32Field conn = PBField.initUInt32(0);
  public final PBStringField ios_qidfa = PBField.initString("");
  public qq_ad_get.QQAdGet.DeviceInfo.Location location = new qq_ad_get.QQAdGet.DeviceInfo.Location();
  public final PBStringField muid = PBField.initString("");
  public final PBUInt32Field muid_type = PBField.initUInt32(0);
  public final PBUInt32Field os_type = PBField.initUInt32(0);
  public final PBStringField os_ver = PBField.initString("");
  public final PBStringField qq_ver = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\aad.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */