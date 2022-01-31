package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class GroupAppPb$AppInfo
  extends MessageMicro<AppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58 }, new String[] { "appid", "icon", "name", "url", "is_gray", "icon_simple_day", "icon_simple_night" }, new Object[] { Integer.valueOf(0), "", "", "", Integer.valueOf(0), "", "" }, AppInfo.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBStringField icon = PBField.initString("");
  public final PBStringField icon_simple_day = PBField.initString("");
  public final PBStringField icon_simple_night = PBField.initString("");
  public final PBUInt32Field is_gray = PBField.initUInt32(0);
  public final PBStringField name = PBField.initString("");
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.GroupAppPb.AppInfo
 * JD-Core Version:    0.7.0.1
 */