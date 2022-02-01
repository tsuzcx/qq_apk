package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qq_ad_get$QQAdGetRsp$AdInfo$ReportInfo$NegativeFeedbackItem
  extends MessageMicro<NegativeFeedbackItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action_type = PBField.initUInt32(0);
  public final PBStringField icon_url = PBField.initString("");
  public final PBStringField jump_title = PBField.initString("");
  public final PBStringField jump_url = PBField.initString("");
  public final PBUInt32Field report_type = PBField.initUInt32(0);
  public final PBStringField text = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 48 }, new String[] { "icon_url", "text", "report_type", "jump_url", "jump_title", "action_type" }, new Object[] { "", "", localInteger, "", "", localInteger }, NegativeFeedbackItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.NegativeFeedbackItem
 * JD-Core Version:    0.7.0.1
 */