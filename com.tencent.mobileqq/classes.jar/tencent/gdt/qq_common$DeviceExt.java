package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qq_common$DeviceExt
  extends MessageMicro<DeviceExt>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "app_status", "attri_info" }, new Object[] { null, null }, DeviceExt.class);
  public qq_common.DeviceExt.AppStatus app_status = new qq_common.DeviceExt.AppStatus();
  public qq_common.DeviceExt.AttriDeviceInfo attri_info = new qq_common.DeviceExt.AttriDeviceInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt
 * JD-Core Version:    0.7.0.1
 */