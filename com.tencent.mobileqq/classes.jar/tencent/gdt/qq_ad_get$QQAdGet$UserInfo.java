package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50 }, new String[] { "qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid" }, new Object[] { Long.valueOf(0L), "", "", "", Long.valueOf(0L), "" }, UserInfo.class);
  public final PBStringField media_specified_id = PBField.initString("");
  public final PBUInt64Field qq = PBField.initUInt64(0L);
  public final PBUInt64Field qq_appid = PBField.initUInt64(0L);
  public final PBStringField qq_openid = PBField.initString("");
  public final PBStringField wx_appid = PBField.initString("");
  public final PBStringField wx_openid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.UserInfo
 * JD-Core Version:    0.7.0.1
 */