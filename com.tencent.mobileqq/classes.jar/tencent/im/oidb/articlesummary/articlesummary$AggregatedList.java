package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class articlesummary$AggregatedList
  extends MessageMicro<AggregatedList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "rpt_article_summary", "uint32_aggregated_content_type", "rpt_multi_biu_same_content" }, new Object[] { null, Integer.valueOf(1), null }, AggregatedList.class);
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_article_summary = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
  public final PBRepeatMessageField<articlesummary.MultiBiuSameContent> rpt_multi_biu_same_content = PBField.initRepeatMessage(articlesummary.MultiBiuSameContent.class);
  public final PBUInt32Field uint32_aggregated_content_type = PBField.initUInt32(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.AggregatedList
 * JD-Core Version:    0.7.0.1
 */