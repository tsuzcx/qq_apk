package tencent.im.new_year_2021;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class newyear_report$SsoReq
  extends MessageMicro<SsoReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "data", "option" }, new Object[] { null, null }, SsoReq.class);
  public newyear_report.NYReportReq data = new newyear_report.NYReportReq();
  public newyear_report.OptionReq option = new newyear_report.OptionReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.new_year_2021.newyear_report.SsoReq
 * JD-Core Version:    0.7.0.1
 */