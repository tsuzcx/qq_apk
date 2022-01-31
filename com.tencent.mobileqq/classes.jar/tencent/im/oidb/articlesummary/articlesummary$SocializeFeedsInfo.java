package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class articlesummary$SocializeFeedsInfo
  extends MessageMicro<SocializeFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public articlesummary.BuluoInfo buluo_info = new articlesummary.BuluoInfo();
  public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_recommend_prompt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_jump_recommend_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_private_status_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_account_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public articlesummary.GameLiveInfo game_live_info = new articlesummary.GameLiveInfo();
  public feeds_info.IconWordingInfo icon_wording_info = new feeds_info.IconWordingInfo();
  public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
  public articlesummary.BiuMultiLevel msg_biu_mutli_level = new articlesummary.BiuMultiLevel();
  public articlesummary.CardJumpInfo msg_card_jump_info = new articlesummary.CardJumpInfo();
  public articlesummary.SocializeFeedsInfoUser msg_master_uin = new articlesummary.SocializeFeedsInfoUser();
  public articlesummary.PGCFeedsInfo msg_pgc_topic_feeds_info = new articlesummary.PGCFeedsInfo();
  public articlesummary.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new articlesummary.SocializeFeedsExtInfo();
  public articlesummary.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new articlesummary.TopicRecommendFeedsInfo();
  public articlesummary.UGCFeedsInfo msg_ugc_topic_feeds_info = new articlesummary.UGCFeedsInfo();
  public articlesummary.VerifyResult msg_verify_result = new articlesummary.VerifyResult();
  public final PBRepeatMessageField<articlesummary.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(articlesummary.SocializeFeedsInfoUser.class);
  public feeds_info.ShareWebPageInfo share_web_page_info = new feeds_info.ShareWebPageInfo();
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feed_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_feeds_style = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_counts = PBField.initUInt32(0);
  public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_jump_recommend_page = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_origin_feeds_deleted = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public feeds_info.VisibleInfo visible_info = new feeds_info.VisibleInfo();
  public articlesummary.WendaInfo wenda_info = new articlesummary.WendaInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 216, 224, 234, 242, 250, 256, 266, 290, 298, 304, 314, 320, 330, 338, 346, 378, 394 }, new String[] { "uint64_feeds_id", "uint32_feeds_style", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "uint32_follow_status", "uint32_follow_counts", "bytes_recommend_account_reason", "buluo_info", "wenda_info", "uint32_is_origin_feeds_deleted", "icon_wording_info", "share_web_page_info", "location_info", "uint32_feed_status", "bytes_private_status_title", "uint32_is_jump_recommend_page", "bytes_jump_recommend_url", "bytes_jump_recommend_prompt", "visible_info", "msg_card_jump_info", "game_live_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, null, null, Integer.valueOf(0), null, null, null, Integer.valueOf(0), localByteStringMicro4, Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, null, null, null }, SocializeFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */