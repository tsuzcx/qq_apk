package tencent.im.oidb.articlesummary;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class articlesummary$ArticleBasicInfo
  extends MessageMicro<ArticleBasicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "rowkey", "title", "msg_pgc_pic_info_list", "jump_url" }, new Object[] { "", "", null, "" }, ArticleBasicInfo.class);
  public final PBStringField jump_url = PBField.initString("");
  public final PBRepeatMessageField<articlesummary.PGCPicInfo> msg_pgc_pic_info_list = PBField.initRepeatMessage(articlesummary.PGCPicInfo.class);
  public final PBStringField rowkey = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.articlesummary.articlesummary.ArticleBasicInfo
 * JD-Core Version:    0.7.0.1
 */