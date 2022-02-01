package tencent.im.oidb.cmd0xf8c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_cmd0xf8c$MapDynamicFields
  extends MessageMicro<MapDynamicFields>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "DynamicFieldkey", "DynamicFieldvalue" }, new Object[] { "", "" }, MapDynamicFields.class);
  public final PBStringField DynamicFieldkey = PBField.initString("");
  public final PBStringField DynamicFieldvalue = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf8c.oidb_cmd0xf8c.MapDynamicFields
 * JD-Core Version:    0.7.0.1
 */