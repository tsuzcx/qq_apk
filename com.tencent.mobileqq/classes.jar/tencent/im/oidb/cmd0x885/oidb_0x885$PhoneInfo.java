package tencent.im.oidb.cmd0x885;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x885$PhoneInfo
  extends MessageMicro<PhoneInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_appid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_client_ip = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_device_brand_and_model = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_manufacturer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_muid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_os_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qq_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wx_ver = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField string_androidid = PBField.initString("");
  public final PBStringField string_client_ipv4 = PBField.initString("");
  public final PBStringField string_idfa = PBField.initString("");
  public final PBStringField string_imei = PBField.initString("");
  public final PBStringField string_mac = PBField.initString("");
  public final PBStringField string_oaid = PBField.initString("");
  public final PBStringField string_qadid = PBField.initString("");
  public final PBStringField string_taid = PBField.initString("");
  public final PBUInt32Field uint32_carrier = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conn = PBField.initUInt32(0);
  public final PBUInt32Field uint32_muid_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_os_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_func_flag = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42, 50, 58, 66, 72, 80, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178 }, new String[] { "bytes_muid", "uint32_conn", "uint32_carrier", "uint32_muid_type", "bytes_os_ver", "bytes_qq_ver", "bytes_client_ip", "bytes_appid", "uint32_os_type", "uint64_func_flag", "bytes_cookie", "bytes_manufacturer", "bytes_device_brand_and_model", "string_qadid", "string_oaid", "string_taid", "string_androidid", "string_mac", "string_client_ipv4", "string_imei", "string_idfa", "bytes_wx_ver" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, "", "", "", "", "", "", "", "", localByteStringMicro9 }, PhoneInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x885.oidb_0x885.PhoneInfo
 * JD-Core Version:    0.7.0.1
 */