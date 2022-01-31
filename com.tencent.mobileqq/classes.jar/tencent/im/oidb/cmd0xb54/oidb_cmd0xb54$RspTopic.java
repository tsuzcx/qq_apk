package tencent.im.oidb.cmd0xb54;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xb54$RspTopic
  extends MessageMicro<RspTopic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_msg_topic" }, new Object[] { null }, RspTopic.class);
  public final PBRepeatMessageField<oidb_cmd0xb54.Topic> rpt_msg_topic = PBField.initRepeatMessage(oidb_cmd0xb54.Topic.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0xb54.oidb_cmd0xb54.RspTopic
 * JD-Core Version:    0.7.0.1
 */