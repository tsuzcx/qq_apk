package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_info$SocializeFeedsInfo
  extends MessageMicro<SocializeFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public feeds_info.BuluoInfo buluo_info = new feeds_info.BuluoInfo();
  public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_extra_json_params = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_recommend_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_recommend_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_private_status_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_account_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public feeds_info.GameLiveInfo game_live_info = new feeds_info.GameLiveInfo();
  public feeds_info.IconWordingInfo icon_wording_info = new feeds_info.IconWordingInfo();
  public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
  public feeds_info.LongContentInfo long_content_info = new feeds_info.LongContentInfo();
  public feeds_info.BiuMultiLevel msg_biu_mutli_level = new feeds_info.BiuMultiLevel();
  public feeds_info.CardConfigInfo msg_card_config_info = new feeds_info.CardConfigInfo();
  public feeds_info.CardJumpInfo msg_card_jump_info = new feeds_info.CardJumpInfo();
  public feeds_info.ColumnTopicInfo msg_column_topic_info = new feeds_info.ColumnTopicInfo();
  public feeds_info.SocializeFeedsInfoUser msg_master_uin = new feeds_info.SocializeFeedsInfoUser();
  public feeds_info.PGCFeedsInfo msg_pgc_topic_feeds_info = new feeds_info.PGCFeedsInfo();
  public feeds_info.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new feeds_info.SocializeFeedsExtInfo();
  public feeds_info.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new feeds_info.TopicRecommendFeedsInfo();
  public feeds_info.UGCFeedsInfo msg_ugc_topic_feeds_info = new feeds_info.UGCFeedsInfo();
  public feeds_info.VerifyResult msg_verify_result = new feeds_info.VerifyResult();
  public feeds_info.NowLiveInfo now_live_info = new feeds_info.NowLiveInfo();
  public final PBRepeatMessageField<feeds_info.MediaData> rpt_media_data_list = PBField.initRepeatMessage(feeds_info.MediaData.class);
  public final PBRepeatMessageField<feeds_info.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(feeds_info.SocializeFeedsInfoUser.class);
  public feeds_info.ShareWebPageInfo share_web_page_info = new feeds_info.ShareWebPageInfo();
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feed_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_biu_comment = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_jump_recommend_page = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_origin_feeds_deleted = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_short_video = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_real_verify_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public feeds_info.VisibleInfo visible_info = new feeds_info.VisibleInfo();
  public feeds_info.WendaInfo wenda_info = new feeds_info.WendaInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 216, 224, 234, 242, 250, 256, 266, 274, 280, 290, 298, 304, 314, 320, 330, 338, 346, 352, 362, 368, 378, 386, 394, 402, 410, 418 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "uint32_follow_status", "uint32_follow_count", "bytes_recommend_account_reason", "buluo_info", "wenda_info", "uint32_is_origin_feeds_deleted", "icon_wording_info", "now_live_info", "uint32_is_short_video", "share_web_page_info", "location_info", "uint32_feed_status", "bytes_private_status_title", "uint32_is_jump_recommend_page", "bytes_jump_recommend_url", "bytes_jump_recommend_prompt", "visible_info", "uint32_real_verify_status", "bytes_extra_json_params", "uint32_is_biu_comment", "msg_card_jump_info", "msg_card_config_info", "game_live_info", "long_content_info", "rpt_media_data_list", "msg_column_topic_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, null, Integer.valueOf(0), localByteStringMicro7, Integer.valueOf(0), null, null, null, null, null, null }, SocializeFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */