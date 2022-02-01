package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qq_ad_get$QQAdGet$UserInfo
  extends MessageMicro<UserInfo>
{
  public static final int USER_GROUP_COMMON = 2;
  public static final int USER_GROUP_DEFAULT = 0;
  public static final int USER_GROUP_WELFARE = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBEnumField group = PBField.initEnum(0);
  public final PBBoolField is_study_mode = PBField.initBool(false);
  public final PBStringField media_specified_id = PBField.initString("");
  public final PBUInt64Field qq = PBField.initUInt64(0L);
  public final PBUInt64Field qq_appid = PBField.initUInt64(0L);
  public final PBStringField qq_openid = PBField.initString("");
  public final PBStringField wuid = PBField.initString("");
  public final PBStringField wx_appid = PBField.initString("");
  public final PBStringField wx_openid = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 64, 72 }, new String[] { "qq", "wx_appid", "wx_openid", "media_specified_id", "qq_appid", "qq_openid", "wuid", "is_study_mode", "group" }, new Object[] { localLong, "", "", "", localLong, "", "", Boolean.valueOf(false), Integer.valueOf(0) }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGet.UserInfo
 * JD-Core Version:    0.7.0.1
 */