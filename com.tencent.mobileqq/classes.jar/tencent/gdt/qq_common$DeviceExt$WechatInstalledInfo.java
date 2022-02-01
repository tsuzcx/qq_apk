package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_common$DeviceExt$WechatInstalledInfo
  extends MessageMicro<WechatInstalledInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field adr_opensdk_ver = PBField.initUInt64(0L);
  public final PBUInt64Field api_ver = PBField.initUInt64(0L);
  public final PBBoolField has_universal_link = PBField.initBool(false);
  public final PBBoolField installed = PBField.initBool(false);
  public final PBStringField ios_opensdk_ver = PBField.initString("");
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40 }, new String[] { "api_ver", "installed", "has_universal_link", "ios_opensdk_ver", "adr_opensdk_ver" }, new Object[] { localLong, localBoolean, localBoolean, "", localLong }, WechatInstalledInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.WechatInstalledInfo
 * JD-Core Version:    0.7.0.1
 */