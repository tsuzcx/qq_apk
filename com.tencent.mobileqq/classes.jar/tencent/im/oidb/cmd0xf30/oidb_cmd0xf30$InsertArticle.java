package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

public final class oidb_cmd0xf30$InsertArticle
  extends MessageMicro<InsertArticle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26 }, new String[] { "actions", "rpt_article_list" }, new Object[] { null, null }, InsertArticle.class);
  public final PBRepeatMessageField<oidb_cmd0xf30.Action> actions = PBField.initRepeatMessage(oidb_cmd0xf30.Action.class);
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle
 * JD-Core Version:    0.7.0.1
 */