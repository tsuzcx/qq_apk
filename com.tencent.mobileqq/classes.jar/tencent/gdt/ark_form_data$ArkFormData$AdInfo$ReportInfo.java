package tencent.gdt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class ark_form_data$ArkFormData$AdInfo$ReportInfo
  extends MessageMicro<ReportInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34, 50 }, new String[] { "landing_page_report_url", "trace_info" }, new Object[] { "", null }, ReportInfo.class);
  public final PBStringField landing_page_report_url = PBField.initString("");
  public ark_form_data.ArkFormData.AdInfo.ReportInfo.TraceInfo trace_info = new ark_form_data.ArkFormData.AdInfo.ReportInfo.TraceInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.gdt.ark_form_data.ArkFormData.AdInfo.ReportInfo
 * JD-Core Version:    0.7.0.1
 */