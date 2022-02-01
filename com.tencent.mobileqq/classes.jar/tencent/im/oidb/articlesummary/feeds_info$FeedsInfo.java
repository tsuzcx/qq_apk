package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_info$FeedsInfo
  extends MessageMicro<FeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_src = PBField.initEnum(0);
  public final PBUInt32Field feeds_type = PBField.initUInt32(0);
  public feeds_info.FollowRecommendFeedsInfo msg_follow_recommend_feeds_info = new feeds_info.FollowRecommendFeedsInfo();
  public feeds_info.SocializeFeedsInfo msg_social_feeds_info = new feeds_info.SocializeFeedsInfo();
  public feeds_info.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new feeds_info.TopicRecommendFeedsInfo();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_index = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 90, 106, 114, 160, 1600, 1608 }, new String[] { "feeds_type", "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "msg_social_feeds_info", "msg_follow_recommend_feeds_info", "msg_topic_recommend_feeds_info", "enum_ugc_src", "uint64_feeds_index", "uint64_feeds_time" }, new Object[] { localInteger, localInteger, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null, null, localInteger, localLong, localLong }, FeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */