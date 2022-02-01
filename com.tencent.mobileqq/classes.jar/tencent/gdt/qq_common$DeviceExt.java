package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class qq_common$DeviceExt
  extends MessageMicro<DeviceExt>
{
  public static final int MQQ_CONFIG_STATUS_FAIL = 2;
  public static final int MQQ_CONFIG_STATUS_SUCCESS = 1;
  public static final int MQQ_CONFIG_STATUS_UNKNOWN = 0;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "app_status", "attri_info", "qaid_info", "wechat_installed_info", "mqq_config_status" }, new Object[] { null, null, null, null, Integer.valueOf(0) }, DeviceExt.class);
  public qq_common.DeviceExt.AppStatus app_status = new qq_common.DeviceExt.AppStatus();
  public qq_common.DeviceExt.AttriDeviceInfo attri_info = new qq_common.DeviceExt.AttriDeviceInfo();
  public final PBEnumField mqq_config_status = PBField.initEnum(0);
  public qq_common.DeviceExt.IosQaidInfo qaid_info = new qq_common.DeviceExt.IosQaidInfo();
  public qq_common.DeviceExt.WechatInstalledInfo wechat_installed_info = new qq_common.DeviceExt.WechatInstalledInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt
 * JD-Core Version:    0.7.0.1
 */