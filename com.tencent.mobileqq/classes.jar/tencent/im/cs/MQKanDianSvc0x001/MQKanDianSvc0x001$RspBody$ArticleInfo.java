package tencent.im.cs.MQKanDianSvc0x001;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class MQKanDianSvc0x001$RspBody$ArticleInfo
  extends MessageMicro<ArticleInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "str_subject", "str_abstract", "str_content_url" }, new Object[] { "", "", "" }, ArticleInfo.class);
  public final PBStringField str_abstract = PBField.initString("");
  public final PBStringField str_content_url = PBField.initString("");
  public final PBStringField str_subject = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.cs.MQKanDianSvc0x001.MQKanDianSvc0x001.RspBody.ArticleInfo
 * JD-Core Version:    0.7.0.1
 */