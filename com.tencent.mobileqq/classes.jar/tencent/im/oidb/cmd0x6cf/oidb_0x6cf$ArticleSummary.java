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
import tencent.im.oidb.cmd0x885.oidb_0x885.AdTagInfo;

public final class oidb_0x6cf$ArticleSummary
  extends MessageMicro<ArticleSummary>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ads_guide_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ads_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_aio_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_avatar_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_frd_praise_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_kb_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_location_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_qzone_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> bytes_recommend_barrage_text_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_strategy_ids = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_title_with_topic = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_wechat_share_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_pgc_ahthor = PBField.initUInt32(0);
  public final PBBytesField json_picture_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x6cf.AccountVInfo msg_account_v_info = new oidb_0x6cf.AccountVInfo();
  public oidb_0x6cf.DownloadBarInfo msg_download_bar_info = new oidb_0x6cf.DownloadBarInfo();
  public oidb_0x6cf.ECommerceEntranceInfo msg_ecommerce_entrance_info = new oidb_0x6cf.ECommerceEntranceInfo();
  public oidb_0x6cf.FeedsInfo msg_feeds_info = new oidb_0x6cf.FeedsInfo();
  public oidb_0x6cf.FusionBiuInfo msg_fusion_biu_info = new oidb_0x6cf.FusionBiuInfo();
  public oidb_0x885.AdTagInfo msg_kd_tag_info = new oidb_0x885.AdTagInfo();
  public oidb_0x6cf.LikeDownloadBarInfo msg_like_download_bar_info = new oidb_0x6cf.LikeDownloadBarInfo();
  public oidb_0x6cf.SoftAdDownloadBarInfo msg_soft_ad_download_bar_info = new oidb_0x6cf.SoftAdDownloadBarInfo();
  public oidb_0x6cf.SubscriptInfo msg_subscript_20 = new oidb_0x6cf.SubscriptInfo();
  public oidb_0x6cf.TopBarInfo msg_top_bar_info = new oidb_0x6cf.TopBarInfo();
  public oidb_0x6cf.TopicRecommendInfo msg_topic_recommend_info = new oidb_0x6cf.TopicRecommendInfo();
  public oidb_0x6cf.UGDownloadBarInfo msg_ug_bottom_download_bar_info = new oidb_0x6cf.UGDownloadBarInfo();
  public oidb_0x6cf.UGDownloadBarInfo msg_ug_middle_download_bar_info = new oidb_0x6cf.UGDownloadBarInfo();
  public oidb_0x6cf.UGDownloadBarInfo msg_ug_top_download_bar_info = new oidb_0x6cf.UGDownloadBarInfo();
  public oidb_0x6cf.UGCFeedsInfo msg_ugc_feeds_info = new oidb_0x6cf.UGCFeedsInfo();
  public final PBRepeatMessageField<oidb_0x6cf.DisLikeInfo> rpt_dislike_list = PBField.initRepeatMessage(oidb_0x6cf.DisLikeInfo.class);
  public final PBRepeatMessageField<oidb_0x6cf.ChannelInfo> rpt_label_list = PBField.initRepeatMessage(oidb_0x6cf.ChannelInfo.class);
  public final PBUInt32Field uint32_account_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_guide_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_jump_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_forbid_reprint_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first_page_use_gif = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_no_show_cover = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_ugc = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_share_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_big_picture = PBField.initUInt32(0);
  public final PBUInt32Field uint32_strategy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_trigger_sec = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_play_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_video_source_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_algorithm_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recommend_seq = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_recommend_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_time = PBField.initUInt64(0L);
  public oidb_0x6cf.VideoColumnInfo video_column_info = new oidb_0x6cf.VideoColumnInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
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
    ByteStringMicro localByteStringMicro24 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro25 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro26 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro27 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro28 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122, 130, 138, 168, 176, 186, 194, 202, 210, 242, 248, 258, 266, 272, 282, 288, 296, 304, 312, 320, 328, 338, 346, 354, 360, 370, 378, 386, 392, 402, 410, 418, 426, 432, 440, 450, 456, 466, 474, 482, 490, 498, 506, 514, 522, 530, 538, 544, 554, 562, 570, 586, 592, 602, 610, 640, 706 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason", "json_picture_list", "json_video_list", "uint32_strategy_id", "uint32_video_play_count", "bytes_frd_praise_info", "bytes_inner_id", "msg_feeds_info", "rpt_label_list", "bytes_recommend_barrage_text_list", "uint32_video_comment_count", "rpt_dislike_list", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_ads_guide_txt", "uint32_ads_guide_time", "uint32_ads_source", "uint32_like_count", "uint32_myself_like_status", "uint32_video_source_type", "uint32_account_grade", "bytes_video_subscript_txt", "bytes_video_subscript_color", "msg_topic_recommend_info", "uint32_is_ugc", "msg_ugc_feeds_info", "msg_top_bar_info", "bytes_video_report_info", "uint32_biu_count", "msg_ecommerce_entrance_info", "bytes_avatar_jump_url", "msg_download_bar_info", "bytes_first_page_gif_url", "uint32_is_first_page_use_gif", "uint32_is_no_show_cover", "bytes_kb_id", "uint32_trigger_sec", "bytes_video_logo_url", "msg_kd_tag_info", "msg_like_download_bar_info", "video_column_info", "msg_soft_ad_download_bar_info", "msg_ug_top_download_bar_info", "msg_account_v_info", "msg_ug_middle_download_bar_info", "msg_ug_bottom_download_bar_info", "msg_fusion_biu_info", "uint32_forbid_reprint_flag", "bytes_wechat_share_url", "bytes_aio_share_url", "bytes_qzone_share_url", "bytes_title_with_topic", "is_pgc_ahthor", "msg_subscript_20", "bytes_location_info", "uint32_share_count", "bytes_strategy_ids" }, new Object[] { localLong, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localLong, localInteger, localByteStringMicro6, localByteStringMicro7, localLong, localLong, localInteger, localLong, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localInteger, localInteger, localByteStringMicro11, localByteStringMicro12, null, null, localByteStringMicro13, localInteger, null, localByteStringMicro14, localInteger, localByteStringMicro15, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro16, localByteStringMicro17, null, localInteger, null, null, localByteStringMicro18, localInteger, null, localByteStringMicro19, null, localByteStringMicro20, localInteger, localInteger, localByteStringMicro21, localInteger, localByteStringMicro22, null, null, null, null, null, null, null, null, null, localInteger, localByteStringMicro23, localByteStringMicro24, localByteStringMicro25, localByteStringMicro26, localInteger, null, localByteStringMicro27, localInteger, localByteStringMicro28 }, ArticleSummary.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ArticleSummary
 * JD-Core Version:    0.7.0.1
 */