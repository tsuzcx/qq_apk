package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_ad_get$QQAdGet
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 16010 }, new String[] { "user_info", "position_info", "device_info", "context_info", "debug_info", "gdt_cookie", "busi_cookie" }, new Object[] { null, null, null, null, null, "", "" }, QQAdGet.class);
  public final PBStringField busi_cookie = PBField.initString("");
  public qq_ad_get.QQAdGet.ContextInfo context_info = new qq_ad_get.QQAdGet.ContextInfo();
  public qq_ad_get.QQAdGet.DebugInfo debug_info = new qq_ad_get.QQAdGet.DebugInfo();
  public qq_ad_get.QQAdGet.DeviceInfo device_info = new qq_ad_get.QQAdGet.DeviceInfo();
  public final PBStringField gdt_cookie = PBField.initString("");
  public final PBRepeatMessageField position_info = PBField.initRepeatMessage(qq_ad_get.QQAdGet.PositionInfo.class);
  public qq_ad_get.QQAdGet.UserInfo user_info = new qq_ad_get.QQAdGet.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet
 * JD-Core Version:    0.7.0.1
 */