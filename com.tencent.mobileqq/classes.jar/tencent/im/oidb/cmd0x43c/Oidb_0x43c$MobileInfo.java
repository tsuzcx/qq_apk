package tencent.im.oidb.cmd0x43c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0x43c$MobileInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42 }, new String[] { "mobile", "isFriend", "bind_uin", "nick_name", "format_mobile" }, new Object[] { "", Boolean.valueOf(false), Long.valueOf(0L), "", "" }, MobileInfo.class);
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public final PBStringField format_mobile = PBField.initString("");
  public final PBBoolField isFriend = PBField.initBool(false);
  public final PBStringField mobile = PBField.initString("");
  public final PBStringField nick_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x43c.Oidb_0x43c.MobileInfo
 * JD-Core Version:    0.7.0.1
 */