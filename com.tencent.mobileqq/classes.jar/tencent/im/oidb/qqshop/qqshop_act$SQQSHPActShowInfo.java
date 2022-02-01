package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class qqshop_act$SQQSHPActShowInfo
  extends MessageMicro<SQQSHPActShowInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "title", "logo", "subtext", "btn_text", "btn_url", "detail_url", "gift_text", "act_text" }, new Object[] { "", "", "", "", "", "", "", "" }, SQQSHPActShowInfo.class);
  public final PBStringField act_text = PBField.initString("");
  public final PBStringField btn_text = PBField.initString("");
  public final PBStringField btn_url = PBField.initString("");
  public final PBStringField detail_url = PBField.initString("");
  public final PBStringField gift_text = PBField.initString("");
  public final PBStringField logo = PBField.initString("");
  public final PBStringField subtext = PBField.initString("");
  public final PBStringField title = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.qqshop.qqshop_act.SQQSHPActShowInfo
 * JD-Core Version:    0.7.0.1
 */