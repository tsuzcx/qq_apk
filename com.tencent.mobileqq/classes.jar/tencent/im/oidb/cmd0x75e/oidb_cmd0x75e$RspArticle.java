package tencent.im.oidb.cmd0x75e;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0x75e$RspArticle
  extends MessageMicro<RspArticle>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 90 }, new String[] { "enum_op_type", "rpt_article_info" }, new Object[] { Integer.valueOf(1), null }, RspArticle.class);
  public final PBEnumField enum_op_type = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_cmd0x75e.ArticleInfo> rpt_article_info = PBField.initRepeatMessage(oidb_cmd0x75e.ArticleInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x75e.oidb_cmd0x75e.RspArticle
 * JD-Core Version:    0.7.0.1
 */