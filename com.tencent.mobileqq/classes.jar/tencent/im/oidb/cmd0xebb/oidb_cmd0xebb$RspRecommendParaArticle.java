package tencent.im.oidb.cmd0xebb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

public final class oidb_cmd0xebb$RspRecommendParaArticle
  extends MessageMicro<RspRecommendParaArticle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90 }, new String[] { "uint64_channel_id", "uint32_is_no_more_data", "rpt_article_list" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null }, RspRecommendParaArticle.class);
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
  public final PBUInt32Field uint32_is_no_more_data = PBField.initUInt32(0);
  public final PBUInt64Field uint64_channel_id = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xebb.oidb_cmd0xebb.RspRecommendParaArticle
 * JD-Core Version:    0.7.0.1
 */