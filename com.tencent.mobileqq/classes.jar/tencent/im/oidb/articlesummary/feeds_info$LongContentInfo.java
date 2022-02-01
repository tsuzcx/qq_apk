package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class feeds_info$LongContentInfo
  extends MessageMicro<LongContentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "enum_long_content_card_type", "msg_article_basic_info", "msg_pgc_video_info", "msg_outside_link_info" }, new Object[] { Integer.valueOf(1), null, null, null }, LongContentInfo.class);
  public final PBEnumField enum_long_content_card_type = PBField.initEnum(1);
  public feeds_info.ArticleBasicInfo msg_article_basic_info = new feeds_info.ArticleBasicInfo();
  public feeds_info.OutsideLinkInfo msg_outside_link_info = new feeds_info.OutsideLinkInfo();
  public feeds_info.PGCVideoInfo msg_pgc_video_info = new feeds_info.PGCVideoInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.feeds_info.LongContentInfo
 * JD-Core Version:    0.7.0.1
 */