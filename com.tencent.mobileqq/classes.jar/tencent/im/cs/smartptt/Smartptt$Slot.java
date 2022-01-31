package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class Smartptt$Slot
  extends MessageMicro<Slot>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_slot_name", "str_slot_value", "str_confirm_status" }, new Object[] { "", "", "" }, Slot.class);
  public final PBStringField str_confirm_status = PBField.initString("");
  public final PBStringField str_slot_name = PBField.initString("");
  public final PBStringField str_slot_value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.smartptt.Smartptt.Slot
 * JD-Core Version:    0.7.0.1
 */