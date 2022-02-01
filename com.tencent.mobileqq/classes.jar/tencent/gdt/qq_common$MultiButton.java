package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qq_common$MultiButton
  extends MessageMicro<MultiButton>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "button_text", "link_type", "link" }, new Object[] { "", Integer.valueOf(0), "" }, MultiButton.class);
  public final PBStringField button_text = PBField.initString("");
  public final PBStringField link = PBField.initString("");
  public final PBEnumField link_type = PBField.initEnum(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_common.MultiButton
 * JD-Core Version:    0.7.0.1
 */