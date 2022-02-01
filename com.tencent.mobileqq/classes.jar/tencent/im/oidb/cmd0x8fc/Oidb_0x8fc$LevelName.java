package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class Oidb_0x8fc$LevelName
  extends MessageMicro<LevelName>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_level", "str_name" }, new Object[] { Integer.valueOf(0), "" }, LevelName.class);
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8fc.Oidb_0x8fc.LevelName
 * JD-Core Version:    0.7.0.1
 */