package tencent.im.oidb.cmd0x94d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x94d$TCollege
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98 }, new String[] { "uint64_id", "str_name", "str_desc" }, new Object[] { Long.valueOf(0L), "", "" }, TCollege.class);
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_name = PBField.initString("");
  public final PBUInt64Field uint64_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x94d.cmd0x94d.TCollege
 * JD-Core Version:    0.7.0.1
 */