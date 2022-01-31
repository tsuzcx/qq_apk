package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class topic_info$TopicBubbleInfo
  extends MessageMicro<TopicBubbleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint32_topic_id", "uint32_up_ts" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0) }, TopicBubbleInfo.class);
  public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_up_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicBubbleInfo
 * JD-Core Version:    0.7.0.1
 */