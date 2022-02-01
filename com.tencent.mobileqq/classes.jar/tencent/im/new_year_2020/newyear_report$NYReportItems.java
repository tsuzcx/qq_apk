package tencent.im.new_year_2020;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class newyear_report$NYReportItems
  extends MessageMicro<NYReportItems>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action = PBField.initUInt32(0);
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBStringField event = PBField.initString("");
  public final PBUInt64Field optime = PBField.initUInt64(0L);
  public final PBStringField param_array = PBField.initString("");
  public final PBUInt32Field result = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 42, 48 }, new String[] { "optime", "event", "action", "result", "param_array", "count" }, new Object[] { Long.valueOf(0L), "", localInteger, localInteger, "", localInteger }, NYReportItems.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.new_year_2020.newyear_report.NYReportItems
 * JD-Core Version:    0.7.0.1
 */