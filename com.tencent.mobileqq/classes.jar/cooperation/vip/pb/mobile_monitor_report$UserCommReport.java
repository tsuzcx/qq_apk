package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class mobile_monitor_report$UserCommReport
  extends MessageMicro<UserCommReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 17, 25, 34, 40, 48, 58, 66 }, new String[] { "imei", "longitude", "latitude", "city_code", "net_type", "from_id", "mobile_type", "qua" }, new Object[] { "", Double.valueOf(0.0D), Double.valueOf(0.0D), "", Integer.valueOf(1), Integer.valueOf(0), "", "" }, UserCommReport.class);
  public final PBStringField city_code = PBField.initString("");
  public final PBUInt32Field from_id = PBField.initUInt32(0);
  public final PBStringField imei = PBField.initString("");
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBStringField mobile_type = PBField.initString("");
  public final PBEnumField net_type = PBField.initEnum(1);
  public final PBStringField qua = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.mobile_monitor_report.UserCommReport
 * JD-Core Version:    0.7.0.1
 */