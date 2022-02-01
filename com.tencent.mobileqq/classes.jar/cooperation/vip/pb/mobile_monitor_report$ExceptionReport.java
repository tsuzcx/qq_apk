package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class mobile_monitor_report$ExceptionReport
  extends MessageMicro<ExceptionReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "busi_id", "errcode", "msg" }, new Object[] { Integer.valueOf(1), Integer.valueOf(0), "" }, ExceptionReport.class);
  public final PBEnumField busi_id = PBField.initEnum(1);
  public final PBInt32Field errcode = PBField.initInt32(0);
  public final PBStringField msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.pb.mobile_monitor_report.ExceptionReport
 * JD-Core Version:    0.7.0.1
 */