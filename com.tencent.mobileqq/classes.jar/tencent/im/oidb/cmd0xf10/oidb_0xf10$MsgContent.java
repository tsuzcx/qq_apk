package tencent.im.oidb.cmd0xf10;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xf10$MsgContent
  extends MessageMicro<MsgContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 88, 98, 170, 178, 250, 258, 266, 274, 282, 290, 298, 330, 354, 360 }, new String[] { "msg_type", "text", "face_index", "face_text", "image_url", "image_thumbnail_url", "share_title", "share_summary", "share_brief", "share_url", "share_action", "share_source", "share_image_url", "file_name", "file_thumbnail_url", "file_size" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), "", "", "", "", "", "", "", "", "", "", "", "", Long.valueOf(0L) }, MsgContent.class);
  public final PBUInt32Field face_index = PBField.initUInt32(0);
  public final PBStringField face_text = PBField.initString("");
  public final PBStringField file_name = PBField.initString("");
  public final PBUInt64Field file_size = PBField.initUInt64(0L);
  public final PBStringField file_thumbnail_url = PBField.initString("");
  public final PBStringField image_thumbnail_url = PBField.initString("");
  public final PBStringField image_url = PBField.initString("");
  public final PBUInt32Field msg_type = PBField.initUInt32(0);
  public final PBStringField share_action = PBField.initString("");
  public final PBStringField share_brief = PBField.initString("");
  public final PBStringField share_image_url = PBField.initString("");
  public final PBStringField share_source = PBField.initString("");
  public final PBStringField share_summary = PBField.initString("");
  public final PBStringField share_title = PBField.initString("");
  public final PBStringField share_url = PBField.initString("");
  public final PBStringField text = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf10.oidb_0xf10.MsgContent
 * JD-Core Version:    0.7.0.1
 */