package tencent.im.oidb.inner.cmdGroupAdGetAdInfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class GetTroopAioTopAD$AppInfo
  extends MessageMicro<AppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "plat_type", "str_app_version" }, new Object[] { Integer.valueOf(1), "" }, AppInfo.class);
  public final PBEnumField plat_type = PBField.initEnum(1);
  public final PBStringField str_app_version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.inner.cmdGroupAdGetAdInfo.GetTroopAioTopAD.AppInfo
 * JD-Core Version:    0.7.0.1
 */