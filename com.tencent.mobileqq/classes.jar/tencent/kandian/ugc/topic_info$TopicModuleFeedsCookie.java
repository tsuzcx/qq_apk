package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class topic_info$TopicModuleFeedsCookie
  extends MessageMicro<TopicModuleFeedsCookie>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 120 }, new String[] { "info", "source", "live_rowkeys" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, TopicModuleFeedsCookie.class);
  public final PBRepeatMessageField<topic_info.SyncCookie> info = PBField.initRepeatMessage(topic_info.SyncCookie.class);
  public final PBRepeatField<Integer> live_rowkeys = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field source = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicModuleFeedsCookie
 * JD-Core Version:    0.7.0.1
 */