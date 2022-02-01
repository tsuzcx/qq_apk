package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$DeviceInfo
  extends MessageMicro<DeviceInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 56, 66, 74, 82, 88, 98, 106, 114, 120, 130, 138, 146, 154, 160, 168, 176, 186, 194, 202, 210, 218, 226, 232, 240, 248, 256, 266, 274 }, new String[] { "muid", "muid_type", "conn", "carrier_code", "os_ver", "qq_ver", "os_type", "client_ip", "ios_qidfa", "location", "is_wk_webview", "manufacturer", "device_brand_and_model", "qadid", "app_version_id", "imei", "idfa", "android_id", "mac", "is_googleplay_version", "device_orientation", "is_ios_review_state", "oaid", "taid_ticket", "md5_mac", "md5_android_id", "client_ipv4", "aid_ticket", "wx_api_ver", "wx_installed", "wx_ul", "origin_network_type", "brand", "device_ext" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", null, Boolean.valueOf(false), "", "", "", Integer.valueOf(0), "", "", "", "", Boolean.valueOf(false), Integer.valueOf(0), Boolean.valueOf(false), "", "", "", "", "", "", Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), "", "" }, DeviceInfo.class);
  public final PBStringField aid_ticket = PBField.initString("");
  public final PBStringField android_id = PBField.initString("");
  public final PBUInt32Field app_version_id = PBField.initUInt32(0);
  public final PBStringField brand = PBField.initString("");
  public final PBUInt32Field carrier_code = PBField.initUInt32(0);
  public final PBStringField client_ip = PBField.initString("");
  public final PBStringField client_ipv4 = PBField.initString("");
  public final PBUInt32Field conn = PBField.initUInt32(0);
  public final PBStringField device_brand_and_model = PBField.initString("");
  public final PBStringField device_ext = PBField.initString("");
  public final PBUInt32Field device_orientation = PBField.initUInt32(0);
  public final PBStringField idfa = PBField.initString("");
  public final PBStringField imei = PBField.initString("");
  public final PBStringField ios_qidfa = PBField.initString("");
  public final PBBoolField is_googleplay_version = PBField.initBool(false);
  public final PBBoolField is_ios_review_state = PBField.initBool(false);
  public final PBBoolField is_wk_webview = PBField.initBool(false);
  public qq_ad_get.QQAdGet.DeviceInfo.Location location = new qq_ad_get.QQAdGet.DeviceInfo.Location();
  public final PBStringField mac = PBField.initString("");
  public final PBStringField manufacturer = PBField.initString("");
  public final PBStringField md5_android_id = PBField.initString("");
  public final PBStringField md5_mac = PBField.initString("");
  public final PBStringField muid = PBField.initString("");
  public final PBUInt32Field muid_type = PBField.initUInt32(0);
  public final PBStringField oaid = PBField.initString("");
  public final PBUInt32Field origin_network_type = PBField.initUInt32(0);
  public final PBUInt32Field os_type = PBField.initUInt32(0);
  public final PBStringField os_ver = PBField.initString("");
  public final PBStringField qadid = PBField.initString("");
  public final PBStringField qq_ver = PBField.initString("");
  public final PBStringField taid_ticket = PBField.initString("");
  public final PBUInt64Field wx_api_ver = PBField.initUInt64(0L);
  public final PBBoolField wx_installed = PBField.initBool(false);
  public final PBBoolField wx_ul = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo
 * JD-Core Version:    0.7.0.1
 */