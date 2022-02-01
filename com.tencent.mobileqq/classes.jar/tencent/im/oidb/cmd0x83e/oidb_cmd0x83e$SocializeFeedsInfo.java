package tencent.im.oidb.cmd0x83e;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.BuluoInfo;
import tencent.im.oidb.articlesummary.feeds_info.LocationInfo;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.articlesummary.feeds_info.PGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.ShareWebPageInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsExtInfo;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsInfoUser;
import tencent.im.oidb.articlesummary.feeds_info.TopicRecommendFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.UGCFeedsInfo;
import tencent.im.oidb.articlesummary.feeds_info.VerifyResult;
import tencent.im.oidb.articlesummary.feeds_info.VisibleInfo;

public final class oidb_cmd0x83e$SocializeFeedsInfo
  extends MessageMicro<SocializeFeedsInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public feeds_info.BuluoInfo buluo_info = new feeds_info.BuluoInfo();
  public final PBBytesField bytes_comments = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_recommend_reason = PBField.initBytes(ByteStringMicro.EMPTY);
  public feeds_info.LocationInfo location_info = new feeds_info.LocationInfo();
  public feeds_info.BiuMultiLevel msg_biu_mutli_level = new feeds_info.BiuMultiLevel();
  public feeds_info.SocializeFeedsInfoUser msg_master_uin = new feeds_info.SocializeFeedsInfoUser();
  public feeds_info.PGCFeedsInfo msg_pgc_topic_feeds_info = new feeds_info.PGCFeedsInfo();
  public feeds_info.SocializeFeedsExtInfo msg_socialize_feeds_ext_info = new feeds_info.SocializeFeedsExtInfo();
  public feeds_info.TopicRecommendFeedsInfo msg_topic_recommend_feeds_info = new feeds_info.TopicRecommendFeedsInfo();
  public feeds_info.UGCFeedsInfo msg_ugc_topic_feeds_info = new feeds_info.UGCFeedsInfo();
  public feeds_info.VerifyResult msg_verify_result = new feeds_info.VerifyResult();
  public feeds_info.NowLiveInfo now_live_info = new feeds_info.NowLiveInfo();
  public final PBRepeatMessageField<feeds_info.SocializeFeedsInfoUser> rpt_recommend_list = PBField.initRepeatMessage(feeds_info.SocializeFeedsInfoUser.class);
  public feeds_info.ShareWebPageInfo share_web_page_info = new feeds_info.ShareWebPageInfo();
  public final PBUInt32Field uint32_biu_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_biu_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_comments_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_biu_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_myself_like_status = PBField.initUInt32(0);
  public final PBUInt64Field uint64_article_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_feeds_id = PBField.initUInt64(0L);
  public feeds_info.VisibleInfo visible_info = new feeds_info.VisibleInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 120, 128, 136, 146, 152, 160, 168, 178, 186, 194, 202, 210, 242, 274, 290, 298, 346 }, new String[] { "uint64_feeds_id", "uint64_article_id", "msg_master_uin", "rpt_recommend_list", "bytes_comments", "bytes_recommend_reason", "uint32_like_count", "uint32_myself_like_status", "uint32_comments_count", "msg_socialize_feeds_ext_info", "uint32_biu_time", "uint32_myself_biu_status", "uint32_biu_count", "msg_biu_mutli_level", "msg_ugc_topic_feeds_info", "msg_pgc_topic_feeds_info", "msg_verify_result", "msg_topic_recommend_feeds_info", "buluo_info", "now_live_info", "share_web_page_info", "location_info", "visible_info" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), null, null, localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null }, SocializeFeedsInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x83e.oidb_cmd0x83e.SocializeFeedsInfo
 * JD-Core Version:    0.7.0.1
 */