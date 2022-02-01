package tencent.im.oidb.cmd0x8a1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class cmd0x8a1$TypeValues
  extends MessageMicro<TypeValues>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "type_value" }, new Object[] { null }, TypeValues.class);
  public final PBRepeatMessageField<cmd0x8a1.StructTypeValue> type_value = PBField.initRepeatMessage(cmd0x8a1.StructTypeValue.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8a1.cmd0x8a1.TypeValues
 * JD-Core Version:    0.7.0.1
 */