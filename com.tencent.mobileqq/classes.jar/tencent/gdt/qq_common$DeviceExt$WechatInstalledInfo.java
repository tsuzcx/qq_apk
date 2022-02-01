package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_common$DeviceExt$WechatInstalledInfo
  extends MessageMicro<WechatInstalledInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "api_ver", "installed", "has_universal_link" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), Boolean.valueOf(false) }, WechatInstalledInfo.class);
  public final PBUInt64Field api_ver = PBField.initUInt64(0L);
  public final PBBoolField has_universal_link = PBField.initBool(false);
  public final PBBoolField installed = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt.WechatInstalledInfo
 * JD-Core Version:    0.7.0.1
 */