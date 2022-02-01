package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class topic_info$TopicRocommend
  extends MessageMicro<TopicRocommend>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field end_ts = PBField.initUInt32(0);
  public final PBUInt32Field pos_score = PBField.initUInt32(0);
  public final PBUInt32Field start_ts = PBField.initUInt32(0);
  public final PBUInt32Field topic_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "topic_id", "pos_score", "start_ts", "end_ts" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, TopicRocommend.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicRocommend
 * JD-Core Version:    0.7.0.1
 */