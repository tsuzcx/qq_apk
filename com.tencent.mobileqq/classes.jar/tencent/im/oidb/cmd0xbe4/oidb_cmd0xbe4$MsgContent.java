package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbe4$MsgContent
  extends MessageMicro<MsgContent>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 90, 98, 106, 112 }, new String[] { "string_feeds_id", "uint32_feed_type", "uint32_type", "str_desc", "str_feeds_pic", "string_sys_activityid", "uint32_sys_from" }, new Object[] { "", Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, MsgContent.class);
  public final PBStringField str_desc = PBField.initString("");
  public final PBStringField str_feeds_pic = PBField.initString("");
  public final PBStringField string_feeds_id = PBField.initString("");
  public final PBStringField string_sys_activityid = PBField.initString("");
  public final PBUInt32Field uint32_feed_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sys_from = PBField.initUInt32(0);
  public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4.MsgContent
 * JD-Core Version:    0.7.0.1
 */