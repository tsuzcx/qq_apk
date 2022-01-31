package tencent.im.oidb.articlesummary;

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

public final class articlesummary$ArticleSummary
  extends MessageMicro<ArticleSummary>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public articlesummary.AwesomeCommentInfo awesome_comment_icon = new articlesummary.AwesomeCommentInfo();
  public articlesummary.BusinessBarInfo business_bar = new articlesummary.BusinessBarInfo();
  public final PBBytesField bytes_ad_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_ads_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_content_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_summary = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_article_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_circle_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_colour = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_comment_button_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_gif_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_first_page_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_friend_like_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gallery_busi_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gallery_report_extdata = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_gw_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_inner_uniq_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_interface_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_card_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_kb_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_media_specs = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_original_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_push_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_report_common_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_server_context = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_test = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_report_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_subscript_color = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_video_subscript_txt = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.DiandianLabel diandian_label = new articlesummary.DiandianLabel();
  public articlesummary.DiandianWording diandian_wording = new articlesummary.DiandianWording();
  public final PBEnumField enum_article_style = PBField.initEnum(0);
  public final PBFloatField float_aspect_ratio = PBField.initFloat(0.0F);
  public articlesummary.HotWordInfo hot_word_info = new articlesummary.HotWordInfo();
  public final PBUInt32Field is_accountless = PBField.initUInt32(0);
  public final PBBytesField json_picture_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField json_video_list = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.AccountVInfo msg_account_v_info = new articlesummary.AccountVInfo();
  public articlesummary.ChannelInfo msg_channel_info = new articlesummary.ChannelInfo();
  public articlesummary.FamilyCommentInfo msg_family_comment_info = new articlesummary.FamilyCommentInfo();
  public articlesummary.FeedsInfo msg_feeds_info = new articlesummary.FeedsInfo();
  public articlesummary.FusionBiuInfo msg_fusion_biu_info = new articlesummary.FusionBiuInfo();
  public articlesummary.KdLiveInfo msg_kd_live_info = new articlesummary.KdLiveInfo();
  public articlesummary.NewPackInfo msg_new_pack_info = new articlesummary.NewPackInfo();
  public articlesummary.PackInfo msg_pack_info = new articlesummary.PackInfo();
  public articlesummary.PartnerAccountInfo msg_partner_account_info = new articlesummary.PartnerAccountInfo();
  public articlesummary.ScripCmsInfo msg_scrip_cms_info = new articlesummary.ScripCmsInfo();
  public final PBRepeatMessageField<articlesummary.SRTUniversalID> msg_srt_universal_id = PBField.initRepeatMessage(articlesummary.SRTUniversalID.class);
  public final PBRepeatMessageField<ArticleSummary> msg_sub_article_summary = PBField.initRepeatMessage(ArticleSummary.class);
  public articlesummary.SubscribeInfo msg_subscribe_info = new articlesummary.SubscribeInfo();
  public articlesummary.WeishiUGInfo msg_ug_info = new articlesummary.WeishiUGInfo();
  public articlesummary.RecommendFollowInfos recommend_info = new articlesummary.RecommendFollowInfos();
  public final PBRepeatMessageField<articlesummary.ArticleTagInfo> rpt_article_tag_list = PBField.initRepeatMessage(articlesummary.ArticleTagInfo.class);
  public final PBRepeatMessageField<articlesummary.CommentInfo> rpt_comments = PBField.initRepeatMessage(articlesummary.CommentInfo.class);
  public final PBRepeatMessageField<articlesummary.DisLikeInfo> rpt_dislike_list = PBField.initRepeatMessage(articlesummary.DisLikeInfo.class);
  public final PBRepeatMessageField<articlesummary.ChannelInfo> rpt_label_list = PBField.initRepeatMessage(articlesummary.ChannelInfo.class);
  public final PBUInt32Field uint32_abandon_repeat_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_jump_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ads_source = PBField.initUInt32(0);
  public final PBUInt32Field uint32_article_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comment_icon_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expose_repeat_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_active = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_close_dislike = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_disp_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_first_page_use_gif = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_gallery = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_show_search_word = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_super_top_article = PBField.initUInt32(0);
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
  public articlesummary.VideoColumnInfo video_column_info = new articlesummary.VideoColumnInfo();
  public articlesummary.VideoDownloadBarInfo video_download_bar_info = new articlesummary.VideoDownloadBarInfo();
  public articlesummary.VideoColumnInfo video_multi_column_info = new articlesummary.VideoColumnInfo();
  public articlesummary.VideoColumnInfo video_simple_column_info = new articlesummary.VideoColumnInfo();
  
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
    ByteStringMicro localByteStringMicro24 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro25 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro26 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro27 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro28 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro29 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro30 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro31 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro32 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro33 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 82, 88, 96, 104, 112, 122, 130, 138, 144, 154, 162, 168, 176, 184, 194, 202, 210, 216, 226, 234, 240, 250, 258, 264, 272, 280, 290, 298, 306, 312, 322, 330, 338, 349, 352, 362, 368, 378, 386, 394, 400, 408, 418, 424, 434, 442, 448, 458, 466, 474, 482, 488, 498, 506, 514, 522, 530, 538, 546, 554, 562, 568, 576, 584, 594, 602, 610, 618, 626, 634, 640, 650, 658, 666, 674, 682, 690, 706, 714, 722, 730, 744 }, new String[] { "uint64_article_id", "bytes_article_title", "bytes_article_summary", "bytes_first_page_pic_url", "bytes_original_url", "bytes_article_content_url", "uint64_time", "uint32_comment_count", "bytes_subscribe_id", "bytes_subscribe_name", "uint64_recommend_time", "uint64_recommend_seq", "uint32_show_big_picture", "uint64_algorithm_id", "bytes_recommend_reason", "json_picture_list", "json_video_list", "uint32_abandon_repeat_flag", "bytes_test", "bytes_colour", "uint32_strategy_id", "uint64_source_article_id", "uint64_merged_video_id", "rpt_article_tag_list", "bytes_friend_like_wording", "bytes_media_specs", "uint32_video_show_small_picture", "msg_channel_info", "bytes_inner_uniq_id", "uint32_comment_icon_type", "bytes_server_context", "rpt_dislike_list", "uint32_is_disp_timestamp", "uint32_is_gallery", "uint32_picture_number", "msg_pack_info", "rpt_comments", "bytes_circle_id", "uint32_is_active", "bytes_push_context", "msg_subscribe_info", "msg_feeds_info", "float_aspect_ratio", "uint32_video_play_count", "rpt_label_list", "is_accountless", "msg_sub_article_summary", "bytes_interface_data", "bytes_gallery_report_extdata", "enum_article_style", "uint32_video_comment_count", "bytes_ads_jump_url", "uint32_ads_jump_type", "bytes_video_subscript_txt", "bytes_video_subscript_color", "uint32_ads_source", "bytes_video_report_info", "diandian_wording", "msg_new_pack_info", "bytes_first_page_gif_url", "uint32_is_first_page_use_gif", "recommend_info", "hot_word_info", "diandian_label", "bytes_gallery_busi_data", "business_bar", "video_download_bar_info", "awesome_comment_icon", "bytes_gw_common_data", "bytes_kb_id", "uint32_article_type", "uint32_is_close_dislike", "uint32_is_super_top_article", "bytes_jump_card_id", "bytes_report_common_data", "bytes_video_logo_url", "msg_partner_account_info", "video_column_info", "bytes_comment_button_jump_url", "uint32_is_show_search_word", "bytes_ad_report_common_data", "msg_srt_universal_id", "video_multi_column_info", "msg_account_v_info", "msg_scrip_cms_info", "video_simple_column_info", "msg_fusion_biu_info", "msg_kd_live_info", "msg_ug_info", "msg_family_comment_info", "uint32_expose_repeat_flag" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), null, localByteStringMicro13, localByteStringMicro14, Integer.valueOf(0), null, localByteStringMicro15, Integer.valueOf(0), localByteStringMicro16, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, localByteStringMicro17, Integer.valueOf(0), localByteStringMicro18, null, null, Float.valueOf(0.0F), Integer.valueOf(0), null, Integer.valueOf(0), null, localByteStringMicro19, localByteStringMicro20, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro21, Integer.valueOf(0), localByteStringMicro22, localByteStringMicro23, Integer.valueOf(0), localByteStringMicro24, null, null, localByteStringMicro25, Integer.valueOf(0), null, null, null, localByteStringMicro26, null, null, null, localByteStringMicro27, localByteStringMicro28, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro29, localByteStringMicro30, localByteStringMicro31, null, null, localByteStringMicro32, Integer.valueOf(0), localByteStringMicro33, null, null, null, null, null, null, null, null, null, Integer.valueOf(0) }, ArticleSummary.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.ArticleSummary
 * JD-Core Version:    0.7.0.1
 */