package tencent.im.oidb.oidb_0xd9e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xd9e$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_topic_item" }, new Object[] { null }, RspBody.class);
  public final PBRepeatMessageField<oidb_0xd9e.UserTopicItem> rpt_topic_item = PBField.initRepeatMessage(oidb_0xd9e.UserTopicItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xd9e.oidb_0xd9e.RspBody
 * JD-Core Version:    0.7.0.1
 */