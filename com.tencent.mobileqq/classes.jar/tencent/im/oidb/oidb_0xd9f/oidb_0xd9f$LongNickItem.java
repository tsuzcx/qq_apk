package tencent.im.oidb.oidb_0xd9f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class oidb_0xd9f$LongNickItem
  extends MessageMicro<LongNickItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "str_longnick", "rpt_topic_item" }, new Object[] { "", null }, LongNickItem.class);
  public final PBRepeatMessageField<oidb_0xd9f.TopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xd9f.TopicItem.class);
  public final PBStringField str_longnick = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd9f.oidb_0xd9f.LongNickItem
 * JD-Core Version:    0.7.0.1
 */