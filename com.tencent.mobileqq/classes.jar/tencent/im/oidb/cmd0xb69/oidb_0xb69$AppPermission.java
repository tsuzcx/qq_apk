package tencent.im.oidb.cmd0xb69;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xb69$AppPermission
  extends MessageMicro<AppPermission>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32 }, new String[] { "permission_name", "permission_cn", "permission_desc", "switch_on" }, new Object[] { "", "", "", Integer.valueOf(0) }, AppPermission.class);
  public final PBStringField permission_cn = PBField.initString("");
  public final PBStringField permission_desc = PBField.initString("");
  public final PBStringField permission_name = PBField.initString("");
  public final PBUInt32Field switch_on = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb69.oidb_0xb69.AppPermission
 * JD-Core Version:    0.7.0.1
 */