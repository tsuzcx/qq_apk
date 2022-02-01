package gxh_message;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class Dialogue
  extends MessageMicro<Dialogue>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "short_nameplate_itemid", "diyfontid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, Dialogue.class);
  public final PBInt32Field diyfontid = PBField.initInt32(0);
  public final PBInt32Field short_nameplate_itemid = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     gxh_message.Dialogue
 * JD-Core Version:    0.7.0.1
 */