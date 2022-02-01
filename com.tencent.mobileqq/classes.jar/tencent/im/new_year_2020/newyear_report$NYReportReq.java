package tencent.im.new_year_2020;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class newyear_report$NYReportReq
  extends MessageMicro<NYReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "commonInfo", "reportItems" }, new Object[] { null, null }, NYReportReq.class);
  public newyear_report.NYCommonInfo commonInfo = new newyear_report.NYCommonInfo();
  public final PBRepeatMessageField<newyear_report.NYReportItems> reportItems = PBField.initRepeatMessage(newyear_report.NYReportItems.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.new_year_2020.newyear_report.NYReportReq
 * JD-Core Version:    0.7.0.1
 */