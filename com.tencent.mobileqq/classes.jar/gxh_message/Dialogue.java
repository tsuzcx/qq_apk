package gxh_message;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class Dialogue
  extends MessageMicro<Dialogue>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field diyfontid = PBField.initInt32(0);
  public final PBInt32Field game_nameplate = PBField.initInt32(0);
  public final PBInt32Field nameplate_pendant_itemid = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "nameplate_pendant_itemid", "diyfontid", "game_nameplate" }, new Object[] { localInteger, localInteger, localInteger }, Dialogue.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     gxh_message.Dialogue
 * JD-Core Version:    0.7.0.1
 */