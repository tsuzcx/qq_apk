package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$WeChatAppInfo
  extends MessageMicro<WeChatAppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 48 }, new String[] { "app_username", "app_path", "app_token", "app_id", "ad_trace_data", "pos_id" }, new Object[] { "", "", "", "", "", Long.valueOf(0L) }, WeChatAppInfo.class);
  public final PBStringField ad_trace_data = PBField.initString("");
  public final PBStringField app_id = PBField.initString("");
  public final PBStringField app_path = PBField.initString("");
  public final PBStringField app_token = PBField.initString("");
  public final PBStringField app_username = PBField.initString("");
  public final PBUInt64Field pos_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.WeChatAppInfo
 * JD-Core Version:    0.7.0.1
 */