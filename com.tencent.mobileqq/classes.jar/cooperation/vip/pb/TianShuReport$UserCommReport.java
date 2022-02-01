package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class TianShuReport$UserCommReport
  extends MessageMicro<UserCommReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 33, 41, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138 }, new String[] { "uid", "to_uid", "guid", "longitude", "latitude", "city_code", "platform", "client_type", "app_version", "market", "qua", "os_version", "mobile_type", "ip_addr", "network_type", "operators", "qimei" }, new Object[] { "", "", "", Double.valueOf(0.0D), Double.valueOf(0.0D), "", "", "", "", "", "", "", "", "", "", "", "" }, UserCommReport.class);
  public final PBStringField app_version = PBField.initString("");
  public final PBStringField city_code = PBField.initString("");
  public final PBStringField client_type = PBField.initString("");
  public final PBStringField guid = PBField.initString("");
  public final PBStringField ip_addr = PBField.initString("");
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBStringField market = PBField.initString("");
  public final PBStringField mobile_type = PBField.initString("");
  public final PBStringField network_type = PBField.initString("");
  public final PBStringField operators = PBField.initString("");
  public final PBStringField os_version = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBStringField qimei = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
  public final PBStringField to_uid = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.vip.pb.TianShuReport.UserCommReport
 * JD-Core Version:    0.7.0.1
 */