package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class articlesummary$LongContentInfo
  extends MessageMicro<LongContentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_long_content_card_type", "msg_article_basic_ingo", "msg_pgc_video_info", "msg_outside_link_info" }, new Object[] { Integer.valueOf(1), null, null, null }, LongContentInfo.class);
  public final PBEnumField enum_long_content_card_type = PBField.initEnum(1);
  public articlesummary.ArticleBasicInfo msg_article_basic_ingo = new articlesummary.ArticleBasicInfo();
  public articlesummary.OutsideLinkInfo msg_outside_link_info = new articlesummary.OutsideLinkInfo();
  public articlesummary.PGCVideoInfo msg_pgc_video_info = new articlesummary.PGCVideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.LongContentInfo
 * JD-Core Version:    0.7.0.1
 */