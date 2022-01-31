package tencent.im.oidb.cmd0x68b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x68b$UserExposeArticle
  extends MessageMicro<UserExposeArticle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_article" }, new Object[] { null }, UserExposeArticle.class);
  public final PBRepeatMessageField<oidb_cmd0x68b.ExposeArticleInfo> rpt_article = PBField.initRepeatMessage(oidb_cmd0x68b.ExposeArticleInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x68b.oidb_cmd0x68b.UserExposeArticle
 * JD-Core Version:    0.7.0.1
 */