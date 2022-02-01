package tencent.im.oidb.cmd0x95a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x95a$ArCountItem
  extends MessageMicro<ArCountItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "uint32_count_type", "uint32_count_value", "str_count_name" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "" }, ArCountItem.class);
  public final PBStringField str_count_name = PBField.initString("");
  public final PBUInt32Field uint32_count_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_count_value = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x95a.cmd0x95a.ArCountItem
 * JD-Core Version:    0.7.0.1
 */