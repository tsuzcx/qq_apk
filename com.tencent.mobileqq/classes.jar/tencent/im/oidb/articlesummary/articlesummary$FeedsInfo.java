package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$FeedsInfo
  extends MessageMicro<FeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_src = PBField.initEnum(0);
  public final PBUInt32Field feeds_type = PBField.initUInt32(0);
  public articlesummary.AggregatedList msg_aggregated_list = new articlesummary.AggregatedList();
  public articlesummary.ArkAppFeedsInfo msg_ark_app_feeds_info = new articlesummary.ArkAppFeedsInfo();
  public articlesummary.FollowRecommendFeedsInfo msg_follow_recommend_feeds_info = new articlesummary.FollowRecommendFeedsInfo();
  public articlesummary.PosAdInfo msg_pos_ad_info = new articlesummary.PosAdInfo();
  public articlesummary.SocializeFeedsInfo msg_social_feeds_info = new articlesummary.SocializeFeedsInfo();
  public articlesummary.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new articlesummary.TopicRecommendFeedsInfo();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hot_biulist = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_index = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 90, 98, 106, 114, 122, 160, 170, 1600, 1608, 1618, 1680 }, new String[] { "feeds_type", "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "msg_social_feeds_info", "msg_pos_ad_info", "msg_follow_recommend_feeds_info", "msg_topic_recommend_feeds_info", "msg_ark_app_feeds_info", "enum_ugc_src", "msg_aggregated_list", "uint64_feeds_index", "uint64_feeds_time", "bytes_feeds_cookie", "uint32_hot_biulist" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null, null, null, null, Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro4, Integer.valueOf(0) }, FeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */