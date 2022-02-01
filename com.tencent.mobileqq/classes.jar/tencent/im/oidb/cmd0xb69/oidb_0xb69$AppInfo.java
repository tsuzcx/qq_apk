package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xb69$AppInfo
  extends MessageMicro<AppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField app_name = PBField.initString("");
  public final PBRepeatMessageField<oidb_0xb69.AppPermission> app_permission = PBField.initRepeatMessage(oidb_0xb69.AppPermission.class);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBUInt32Field order = PBField.initUInt32(0);
  public final PBUInt32Field switch_on = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42 }, new String[] { "appid", "app_name", "switch_on", "order", "app_permission" }, new Object[] { Long.valueOf(0L), "", localInteger, localInteger, null }, AppInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb69.oidb_0xb69.AppInfo
 * JD-Core Version:    0.7.0.1
 */