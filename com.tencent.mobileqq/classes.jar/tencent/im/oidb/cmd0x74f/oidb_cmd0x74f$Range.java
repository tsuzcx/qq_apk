package tencent.im.oidb.cmd0x74f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x74f$Range
  extends MessageMicro<Range>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "string_name", "uint32_days" }, new Object[] { "", Long.valueOf(0L) }, Range.class);
  public final PBStringField string_name = PBField.initString("");
  public final PBUInt64Field uint32_days = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x74f.oidb_cmd0x74f.Range
 * JD-Core Version:    0.7.0.1
 */