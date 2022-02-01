package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

public final class oidb_cmd0x68b$RspGetFollowTabFeeds
  extends MessageMicro<RspGetFollowTabFeeds>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint32_feeds_type", "msg_article_summary", "uint64_follow_recommend_id" }, new Object[] { Integer.valueOf(0), null, Long.valueOf(0L) }, RspGetFollowTabFeeds.class);
  public articlesummary.ArticleSummary msg_article_summary = new articlesummary.ArticleSummary();
  public final PBEnumField uint32_feeds_type = PBField.initEnum(0);
  public final PBUInt64Field uint64_follow_recommend_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.RspGetFollowTabFeeds
 * JD-Core Version:    0.7.0.1
 */