package tencent.im.oidb.cmd0x80a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0x80a$IdlePushWakeParam
  extends MessageMicro<IdlePushWakeParam>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "package_name" }, new Object[] { "" }, IdlePushWakeParam.class);
  public final PBStringField package_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.IdlePushWakeParam
 * JD-Core Version:    0.7.0.1
 */