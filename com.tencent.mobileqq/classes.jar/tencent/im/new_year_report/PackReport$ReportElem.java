package tencent.im.new_year_report;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class PackReport$ReportElem
  extends MessageMicro<ReportElem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field count = PBField.initUInt64(0L);
  public final PBUInt64Field timestamp = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "timestamp", "count" }, new Object[] { localLong, localLong }, ReportElem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_report.PackReport.ReportElem
 * JD-Core Version:    0.7.0.1
 */