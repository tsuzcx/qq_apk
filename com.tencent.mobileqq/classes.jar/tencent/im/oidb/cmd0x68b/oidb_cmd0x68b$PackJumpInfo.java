package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0x68b$PackJumpInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "enum_style", "str_wording", "str_url" }, new Object[] { Integer.valueOf(1), "", "" }, PackJumpInfo.class);
  public final PBEnumField enum_style = PBField.initEnum(1);
  public final PBStringField str_url = PBField.initString("");
  public final PBStringField str_wording = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.PackJumpInfo
 * JD-Core Version:    0.7.0.1
 */