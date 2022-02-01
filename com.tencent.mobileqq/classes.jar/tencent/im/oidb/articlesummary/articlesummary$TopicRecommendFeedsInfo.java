package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$TopicRecommendFeedsInfo
  extends MessageMicro<TopicRecommendFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.TopicRecommendFeedsTitle msg_left_title = new articlesummary.TopicRecommendFeedsTitle();
  public articlesummary.TopicRecommendFeedsTitle msg_right_title = new articlesummary.TopicRecommendFeedsTitle();
  public final PBRepeatMessageField<articlesummary.TopicRecommendInfo> msg_topic_recommend_info = PBField.initRepeatMessage(articlesummary.TopicRecommendInfo.class);
  public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42, 90, 98, 106, 114 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_uin", "bytes_subscribe_id", "bytes_subscribe_name", "msg_topic_recommend_info", "msg_left_title", "msg_right_title", "bytes_comments" }, new Object[] { localLong, Integer.valueOf(0), localLong, localByteStringMicro1, localByteStringMicro2, null, null, null, localByteStringMicro3 }, TopicRecommendFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo
 * JD-Core Version:    0.7.0.1
 */