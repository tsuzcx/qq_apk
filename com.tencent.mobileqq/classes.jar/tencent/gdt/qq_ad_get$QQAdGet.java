package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGet
  extends MessageMicro<QQAdGet>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 74, 80, 16010 }, new String[] { "user_info", "position_info", "device_info", "context_info", "debug_info", "gdt_cookie", "support_https", "external_exp_info", "version_info", "dynamic_timeout_in_ms", "busi_cookie" }, new Object[] { null, null, null, null, null, "", Boolean.valueOf(false), null, null, Integer.valueOf(0), "" }, QQAdGet.class);
  public final PBStringField busi_cookie = PBField.initString("");
  public qq_ad_get.QQAdGet.ContextInfo context_info = new qq_ad_get.QQAdGet.ContextInfo();
  public qq_ad_get.QQAdGet.DebugInfo debug_info = new qq_ad_get.QQAdGet.DebugInfo();
  public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
  public final PBUInt32Field dynamic_timeout_in_ms = PBField.initUInt32(0);
  public qq_ad_get.QQAdGet.ExternalExpInfo external_exp_info = new qq_ad_get.QQAdGet.ExternalExpInfo();
  public final PBStringField gdt_cookie = PBField.initString("");
  public final PBRepeatMessageField<qq_ad_get.QQAdGet.PositionInfo> position_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.class);
  public final PBBoolField support_https = PBField.initBool(false);
  public qq_ad_get.QQAdGet.UserInfo user_info = new qq_ad_get.QQAdGet.UserInfo();
  public qq_ad_get.QQAdGet.VersionInfo version_info = new qq_ad_get.QQAdGet.VersionInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet
 * JD-Core Version:    0.7.0.1
 */