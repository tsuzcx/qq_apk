package common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class QqAdGetProtos$QQAdGet
  extends MessageMicro<QQAdGet>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 56, 66, 16010 }, new String[] { "user_info", "position_info", "device_info", "context_info", "debug_info", "gdt_cookie", "support_https", "external_exp_info", "busi_cookie" }, new Object[] { null, null, null, null, null, "", Boolean.valueOf(false), null, "" }, QQAdGet.class);
  public final PBStringField busi_cookie = PBField.initString("");
  public QqAdGetProtos.QQAdGet.ContextInfo context_info = new QqAdGetProtos.QQAdGet.ContextInfo();
  public QqAdGetProtos.QQAdGet.DebugInfo debug_info = new QqAdGetProtos.QQAdGet.DebugInfo();
  public QqAdGetProtos.QQAdGet.DeviceInfo device_info = new QqAdGetProtos.QQAdGet.DeviceInfo();
  public QqAdGetProtos.QQAdGet.ExternalExpInfo external_exp_info = new QqAdGetProtos.QQAdGet.ExternalExpInfo();
  public final PBStringField gdt_cookie = PBField.initString("");
  public final PBRepeatMessageField<QqAdGetProtos.QQAdGet.PositionInfo> position_info = PBField.initRepeatMessage(QqAdGetProtos.QQAdGet.PositionInfo.class);
  public final PBBoolField support_https = PBField.initBool(false);
  public QqAdGetProtos.QQAdGet.UserInfo user_info = new QqAdGetProtos.QQAdGet.UserInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     common.QqAdGetProtos.QQAdGet
 * JD-Core Version:    0.7.0.1
 */