package tencent.kandian.ugc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class topic_info$TopicFeedsCountInfo
  extends MessageMicro<TopicFeedsCountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field content_count = PBField.initUInt32(0);
  public final PBStringField end_rowkey = PBField.initString("");
  public final PBUInt64Field end_score = PBField.initUInt64(0L);
  public final PBUInt32Field topic_id = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "topic_id", "content_count", "end_rowkey", "end_score" }, new Object[] { localInteger, localInteger, "", Long.valueOf(0L) }, TopicFeedsCountInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.kandian.ugc.topic_info.TopicFeedsCountInfo
 * JD-Core Version:    0.7.0.1
 */