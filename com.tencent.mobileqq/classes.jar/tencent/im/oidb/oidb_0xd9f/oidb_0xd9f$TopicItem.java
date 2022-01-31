package tencent.im.oidb.oidb_0xd9f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0xd9f$TopicItem
  extends MessageMicro<TopicItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34 }, new String[] { "uint32_topic_id", "str_topic", "uint32_frd_num", "rpt_frd_item" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), null }, TopicItem.class);
  public final PBRepeatMessageField<oidb_0xd9f.UinItem> rpt_frd_item = PBField.initRepeatMessage(oidb_0xd9f.UinItem.class);
  public final PBStringField str_topic = PBField.initString("");
  public final PBUInt32Field uint32_frd_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.TopicItem
 * JD-Core Version:    0.7.0.1
 */