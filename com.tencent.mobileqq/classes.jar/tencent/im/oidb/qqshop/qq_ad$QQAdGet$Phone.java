package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad$QQAdGet$Phone
  extends MessageMicro<Phone>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField aid_ticket = PBField.initString("");
  public final PBUInt64Field app_id = PBField.initUInt64(0L);
  public final PBInt32Field app_version_id = PBField.initInt32(0);
  public final PBUInt32Field carrier = PBField.initUInt32(0);
  public final PBStringField client_ipv4 = PBField.initString("");
  public final PBUInt32Field conn = PBField.initUInt32(0);
  public final PBInt32Field coordinates_type = PBField.initInt32(0);
  public final PBBytesField device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField is_googleplay_version = PBField.initBool(false);
  public final PBInt32Field latitude = PBField.initInt32(0);
  public final PBInt32Field longitude = PBField.initInt32(0);
  public final PBBytesField manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField md5_android_id = PBField.initString("");
  public final PBStringField md5_mac = PBField.initString("");
  public final PBStringField muid = PBField.initString("");
  public final PBInt32Field muid_type = PBField.initInt32(0);
  public final PBUInt32Field os_type = PBField.initUInt32(0);
  public final PBStringField os_ver = PBField.initString("");
  public final PBStringField qadid = PBField.initString("");
  public final PBStringField qq_ver = PBField.initString("");
  public final PBStringField taid_ticket = PBField.initString("");
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 48, 56, 64, 72, 82, 90, 98, 104, 114, 120, 130, 136, 146, 154, 160, 170 }, new String[] { "muid", "conn", "carrier", "os_ver", "qq_ver", "os_type", "app_id", "latitude", "longitude", "manufacturer", "device_brand_and_model", "qadid", "is_googleplay_version", "aid_ticket", "app_version_id", "client_ipv4", "coordinates_type", "md5_android_id", "md5_mac", "muid_type", "taid_ticket" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, "", Boolean.valueOf(false), "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", Integer.valueOf(0), "" }, Phone.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qq_ad.QQAdGet.Phone
 * JD-Core Version:    0.7.0.1
 */