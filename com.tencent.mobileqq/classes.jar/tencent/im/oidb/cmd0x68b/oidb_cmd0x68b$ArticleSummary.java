package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x68b$ArticleSummary
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ads_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_circle_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_colour = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_friend_like_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gallery_report_extdata = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_media_specs = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_server_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_test = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField enum_article_style = PBField.initEnum(0);
  public final PBFloatField float_aspect_ratio = PBField.initFloat(0.0F);
  public final PBUInt32Field is_accountless = PBField.initUInt32(0);
  public final PBBytesField json_picture_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x68b.ChannelInfo msg_channel_info = new oidb_cmd0x68b.ChannelInfo();
  public oidb_cmd0x68b.FeedsInfo msg_feeds_info = new oidb_cmd0x68b.FeedsInfo();
  public oidb_cmd0x68b.PackInfo msg_pack_info = new oidb_cmd0x68b.PackInfo();
  public final PBRepeatMessageField msg_sub_article_summary = PBField.initRepeatMessage(ArticleSummary.class);
  public oidb_cmd0x68b.SubscribeInfo msg_subscribe_info = new oidb_cmd0x68b.SubscribeInfo();
  public final PBRepeatMessageField rpt_article_tag_list = PBField.initRepeatMessage(oidb_cmd0x68b.ArticleTagInfo.class);
  public final PBRepeatMessageField rpt_comments = PBField.initRepeatMessage(oidb_cmd0x68b.CommentInfo.class);
  public final PBRepeatMessageField rpt_dislike_list = PBField.initRepeatMessage(oidb_cmd0x68b.DisLikeInfo.class);
  public final PBRepeatMessageField rpt_label_list = PBField.initRepeatMessage(oidb_cmd0x68b.ChannelInfo.class);
  public final PBUInt32Field uint32_abandon_repeat_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_jump_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_icon_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_active = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_disp_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_gallery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_picture_number = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_big_picture = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_show_small_picture = PBField.initUInt32(0);
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_merged_video_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recommend_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_source_article_id = PBField.initUInt64(0L);
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
    ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro18 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro19 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro20 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro21 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro22 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro23 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122, 130, 138, 144, 154, 162, 168, 176, 184, 194, 202, 210, 216, 226, 234, 240, 250, 258, 264, 272, 280, 290, 298, 306, 312, 322, 330, 338, 349, 352, 362, 368, 378, 386, 394, 400, 408, 418, 424, 434, 442, 448 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason", "json_picture_list", "json_video_list", "uint32_abandon_repeat_flag", "bytes_test", "bytes_colour", "uint32_strategy_id", "uint64_source_article_id", "uint64_merged_video_id", "rpt_article_tag_list", "bytes_friend_like_wording", "bytes_media_specs", "uint32_video_show_small_picture", "msg_channel_info", "bytes_inner_uniq_id", "uint32_comment_icon_type", "bytes_server_context", "rpt_dislike_list", "uint32_is_disp_timestamp", "uint32_is_gallery", "uint32_picture_number", "msg_pack_info", "rpt_comments", "bytes_circle_id", "uint32_is_active", "bytes_push_context", "msg_subscribe_info", "msg_feeds_info", "float_aspect_ratio", "uint32_video_play_count", "rpt_label_list", "is_accountless", "msg_sub_article_summary", "bytes_interface_data", "bytes_gallery_report_extdata", "enum_article_style", "uint32_video_comment_count", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_video_subscript_txt", "bytes_video_subscript_color", "uint32_ads_source" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro13, localByteStringMicro14, Integer.valueOf(0), null, localByteStringMicro15, Integer.valueOf(0), localByteStringMicro16, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro17, Integer.valueOf(0), localByteStringMicro18, null, null, Float.valueOf(0.0F), Integer.valueOf(0), null, Integer.valueOf(0), null, localByteStringMicro19, localByteStringMicro20, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro21, Integer.valueOf(0), localByteStringMicro22, localByteStringMicro23, Integer.valueOf(0) }, ArticleSummary.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.ArticleSummary
 * JD-Core Version:    0.7.0.1
 */