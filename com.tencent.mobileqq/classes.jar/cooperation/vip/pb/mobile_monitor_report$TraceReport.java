package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobile_monitor_report$TraceReport
  extends MessageMicro<TraceReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "msg", "trace_id", "trace_num", "page_id" }, new Object[] { "", "", Integer.valueOf(0), "" }, TraceReport.class);
  public final PBStringField msg = PBField.initString("");
  public final PBStringField page_id = PBField.initString("");
  public final PBStringField trace_id = PBField.initString("");
  public final PBUInt32Field trace_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.pb.mobile_monitor_report.TraceReport
 * JD-Core Version:    0.7.0.1
 */