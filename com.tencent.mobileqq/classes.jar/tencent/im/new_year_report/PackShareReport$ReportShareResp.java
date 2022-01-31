package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class PackShareReport$ReportShareResp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 80 }, new String[] { "reserve" }, new Object[] { Integer.valueOf(0) }, ReportShareResp.class);
  public final PBUInt32Field reserve = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.new_year_report.PackShareReport.ReportShareResp
 * JD-Core Version:    0.7.0.1
 */