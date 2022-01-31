package tencent.im.oidb.cmd0x8c8;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8c8$TopicRecommendFeedsInfo
  extends MessageMicro<TopicRecommendFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x8c8.TopicRecommendFeedsTitle msg_left_title = new oidb_cmd0x8c8.TopicRecommendFeedsTitle();
  public oidb_cmd0x8c8.TopicRecommendFeedsTitle msg_right_title = new oidb_cmd0x8c8.TopicRecommendFeedsTitle();
  public final PBRepeatMessageField<oidb_cmd0x8c8.TopicRecommendInfo> msg_topic_recommend_info = PBField.initRepeatMessage(oidb_cmd0x8c8.TopicRecommendInfo.class);
  public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 90, 98, 106, 114 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_uin", "bytes_subscribe_id", "msg_topic_recommend_info", "msg_left_title", "msg_right_title", "bytes_comments" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, null, null, null, localByteStringMicro2 }, TopicRecommendFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8c8.oidb_cmd0x8c8.TopicRecommendFeedsInfo
 * JD-Core Version:    0.7.0.1
 */