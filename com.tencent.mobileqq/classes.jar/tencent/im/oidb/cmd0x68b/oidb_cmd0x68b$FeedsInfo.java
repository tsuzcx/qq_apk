package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$FeedsInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_business_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_name_prefix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_business_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_feeds_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_ugc_src = PBField.initEnum(0);
  public final PBEnumField feeds_type = PBField.initEnum(0);
  public oidb_cmd0x68b.ArkAppFeedsInfo msg_ark_app_feeds_info = new oidb_cmd0x68b.ArkAppFeedsInfo();
  public oidb_cmd0x68b.FollowRecommendFeedsInfo msg_follow_recommend_feeds_info = new oidb_cmd0x68b.FollowRecommendFeedsInfo();
  public oidb_cmd0x68b.PosAdInfo msg_pos_ad_info = new oidb_cmd0x68b.PosAdInfo();
  public oidb_cmd0x68b.SocializeFeedsInfo msg_social_feeds_info = new oidb_cmd0x68b.SocializeFeedsInfo();
  public oidb_cmd0x68b.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new oidb_cmd0x68b.TopicRecommendFeedsInfo();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_index = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 90, 98, 106, 114, 122, 160, 1600, 1608, 1618 }, new String[] { "feeds_type", "uint32_business_id", "bytes_business_name", "bytes_business_url", "bytes_business_name_prefix", "msg_social_feeds_info", "msg_pos_ad_info", "msg_follow_recommend_feeds_info", "msg_topic_recommend_feeds_info", "msg_ark_app_feeds_info", "enum_ugc_src", "uint64_feeds_index", "uint64_feeds_time", "bytes_feeds_cookie" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, null, null, null, null, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro4 }, FeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.FeedsInfo
 * JD-Core Version:    0.7.0.1
 */