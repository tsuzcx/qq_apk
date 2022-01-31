package tencent.im.oidb.cmd0x6cf;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x6cf$ArticleSummary
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ads_guide_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ads_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_frd_praise_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField bytes_recommend_barrage_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField json_picture_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.FeedsInfo msg_feeds_info = new oidb_0x6cf.FeedsInfo();
  public final PBRepeatMessageField rpt_dislike_list = PBField.initRepeatMessage(oidb_0x6cf.DisLikeInfo.class);
  public final PBRepeatMessageField rpt_label_list = PBField.initRepeatMessage(oidb_0x6cf.ChannelInfo.class);
  public final PBUInt32Field uint32_ads_guide_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_jump_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_big_picture = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_source_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recommend_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122, 130, 138, 168, 176, 186, 194, 202, 210, 242, 248, 258, 266, 272, 282, 288, 296, 304, 312, 320 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason", "json_picture_list", "json_video_list", "uint32_strategy_id", "uint32_video_play_count", "bytes_frd_praise_info", "bytes_inner_id", "msg_feeds_info", "rpt_label_list", "bytes_recommend_barrage_text_list", "uint32_video_comment_count", "rpt_dislike_list", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_ads_guide_txt", "uint32_ads_guide_time", "uint32_ads_source", "uint32_like_count", "uint32_myself_like_status", "uint32_video_source_type" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, null, null, localByteStringMicro13, Integer.valueOf(0), null, localByteStringMicro14, Integer.valueOf(0), localByteStringMicro15, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ArticleSummary.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary
 * JD-Core Version:    0.7.0.1
 */