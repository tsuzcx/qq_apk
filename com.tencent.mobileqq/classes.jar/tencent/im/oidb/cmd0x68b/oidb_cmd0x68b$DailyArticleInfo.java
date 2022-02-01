package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import tencent.im.oidb.articlesummary.articlesummary.ArticleTagInfo;

public final class oidb_cmd0x68b$DailyArticleInfo
  extends MessageMicro<DailyArticleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rowkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<articlesummary.ArticleTagInfo> rpt_article_tag_list = PBField.initRepeatMessage(articlesummary.ArticleTagInfo.class);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "bytes_rowkey", "rpt_article_tag_list" }, new Object[] { localByteStringMicro, null }, DailyArticleInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.DailyArticleInfo
 * JD-Core Version:    0.7.0.1
 */