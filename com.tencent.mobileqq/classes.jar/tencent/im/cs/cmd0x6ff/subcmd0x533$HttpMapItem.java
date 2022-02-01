package tencent.im.cs.cmd0x6ff;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class subcmd0x533$HttpMapItem
  extends MessageMicro<HttpMapItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "string_key", "string_value", "rpt_string_key_list" }, new Object[] { "", "", "" }, HttpMapItem.class);
  public final PBRepeatField<String> rpt_string_key_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField string_key = PBField.initString("");
  public final PBStringField string_value = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.cs.cmd0x6ff.subcmd0x533.HttpMapItem
 * JD-Core Version:    0.7.0.1
 */