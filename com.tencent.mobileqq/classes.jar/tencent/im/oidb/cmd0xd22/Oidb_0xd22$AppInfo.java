package tencent.im.oidb.cmd0xd22;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0xd22$AppInfo
  extends MessageMicro<AppInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "appid", "organization_id" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, AppInfo.class);
  public final PBUInt32Field appid = PBField.initUInt32(0);
  public final PBUInt32Field organization_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xd22.Oidb_0xd22.AppInfo
 * JD-Core Version:    0.7.0.1
 */