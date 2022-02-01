package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_common$DeviceExt
  extends MessageMicro<DeviceExt>
{
  public static final int MQQ_CONFIG_STATUS_FAIL = 2;
  public static final int MQQ_CONFIG_STATUS_SUCCESS = 1;
  public static final int MQQ_CONFIG_STATUS_UNKNOWN = 0;
  public static final int THUMB_PLAYER = 1;
  public static final int UNKNOWN_TYPE = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public qq_common.DeviceExt.AppStatus app_status = new qq_common.DeviceExt.AppStatus();
  public qq_common.DeviceExt.AttriDeviceInfo attri_info = new qq_common.DeviceExt.AttriDeviceInfo();
  public final PBStringField ei = PBField.initString("");
  public qzap_common.HarmonySysInfo harmony_sys_info = new qzap_common.HarmonySysInfo();
  public final PBRepeatMessageField<qq_common.DeviceExt.HevcCompatibilityInfo> hevc_compatibility_info = PBField.initRepeatMessage(qq_common.DeviceExt.HevcCompatibilityInfo.class);
  public final PBEnumField mqq_config_status = PBField.initEnum(0);
  public qq_common.DeviceExt.IosQaidInfo qaid_info = new qq_common.DeviceExt.IosQaidInfo();
  public qq_common.DeviceExt.ExternalExpInfo qqb_external_exp_info = new qq_common.DeviceExt.ExternalExpInfo();
  public final PBUInt32Field sdk_config_ver = PBField.initUInt32(0);
  public qq_common.DeviceExt.WechatInstalledInfo wechat_installed_info = new qq_common.DeviceExt.WechatInstalledInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 58, 64, 74, 82 }, new String[] { "app_status", "attri_info", "qaid_info", "wechat_installed_info", "mqq_config_status", "ei", "qqb_external_exp_info", "sdk_config_ver", "harmony_sys_info", "hevc_compatibility_info" }, new Object[] { null, null, null, null, localInteger, "", null, localInteger, null, null }, DeviceExt.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_common.DeviceExt
 * JD-Core Version:    0.7.0.1
 */