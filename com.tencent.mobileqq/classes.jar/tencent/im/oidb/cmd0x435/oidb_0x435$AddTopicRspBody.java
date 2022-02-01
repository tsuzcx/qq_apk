package tencent.im.oidb.cmd0x435;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x435$AddTopicRspBody
  extends MessageMicro<AddTopicRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_topic_info" }, new Object[] { null }, AddTopicRspBody.class);
  public oidb_0x435.TopicInfo msg_topic_info = new oidb_0x435.TopicInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x435.oidb_0x435.AddTopicRspBody
 * JD-Core Version:    0.7.0.1
 */