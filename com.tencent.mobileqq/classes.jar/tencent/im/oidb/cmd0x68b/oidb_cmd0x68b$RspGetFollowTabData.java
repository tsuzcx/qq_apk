package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.TopicRecommendFeedsInfo;

public final class oidb_cmd0x68b$RspGetFollowTabData
  extends MessageMicro<RspGetFollowTabData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_refresh_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_set_top_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<oidb_cmd0x68b.RspGetFollowTabFeeds> rpt_article_list = PBField.initRepeatMessage(oidb_cmd0x68b.RspGetFollowTabFeeds.class);
  public articlesummary.TopicRecommendFeedsInfo topic_update_info = new articlesummary.TopicRecommendFeedsInfo();
  public final PBUInt32Field uint32_has_followed_topic = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hint_index = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
  public final PBUInt32Field uint32_refresh_topic_update_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_topic_reddot_update_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90, 98, 104, 114, 120, 128, 138, 144 }, new String[] { "uint32_is_no_more_data", "rpt_article_list", "bytes_set_top_cookie", "uint32_refresh_topic_update_info", "topic_update_info", "uint32_has_followed_topic", "uint32_topic_reddot_update_num", "bytes_refresh_cookie", "uint32_hint_index" }, new Object[] { localInteger, null, localByteStringMicro1, localInteger, null, localInteger, localInteger, localByteStringMicro2, localInteger }, RspGetFollowTabData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabData
 * JD-Core Version:    0.7.0.1
 */