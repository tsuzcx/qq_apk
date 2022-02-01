package tencent.im.oidb.cmd0xf30;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.articlesummary.articlesummary.ArticleSummary;

public final class oidb_cmd0xf30$InsertArticle
  extends MessageMicro<InsertArticle>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<oidb_cmd0xf30.Action> actions = PBField.initRepeatMessage(oidb_cmd0xf30.Action.class);
  public final PBBoolField filter_ad = PBField.initBool(false);
  public final PBBoolField is_ad = PBField.initBool(false);
  public final PBUInt32Field least_ad_dis = PBField.initUInt32(0);
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_ad_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
  public final PBRepeatMessageField<articlesummary.ArticleSummary> rpt_article_list = PBField.initRepeatMessage(articlesummary.ArticleSummary.class);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 34, 40, 48, 56 }, new String[] { "actions", "rpt_article_list", "rpt_ad_list", "is_ad", "filter_ad", "least_ad_dis" }, new Object[] { null, null, null, localBoolean, localBoolean, Integer.valueOf(0) }, InsertArticle.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf30.oidb_cmd0xf30.InsertArticle
 * JD-Core Version:    0.7.0.1
 */