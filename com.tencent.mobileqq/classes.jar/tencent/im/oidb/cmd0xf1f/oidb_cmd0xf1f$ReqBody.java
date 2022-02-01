package tencent.im.oidb.cmd0xf1f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_cmd0xf1f$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "rpt_article_item", "opt_type" }, new Object[] { null, Integer.valueOf(1) }, ReqBody.class);
  public final PBEnumField opt_type = PBField.initEnum(1);
  public final PBRepeatMessageField<oidb_cmd0xf1f.ArticleItem> rpt_article_item = PBField.initRepeatMessage(oidb_cmd0xf1f.ArticleItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xf1f.oidb_cmd0xf1f.ReqBody
 * JD-Core Version:    0.7.0.1
 */