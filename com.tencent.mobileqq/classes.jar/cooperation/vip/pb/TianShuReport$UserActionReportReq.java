package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TianShuReport$UserActionReportReq
  extends MessageMicro<UserActionReportReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 33, 41, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 144, 154, 162, 170, 178, 186, 194, 202, 210, 218, 224, 232, 240, 248, 256, 264, 274, 282, 290, 298 }, new String[] { "uid", "to_uid", "guid", "longitude", "latitude", "city_code", "platform", "client_type", "app_version", "market", "qua", "os_version", "mobile_type", "ip_addr", "network_type", "operators", "trace_id", "trace_num", "trace_detail", "trace_index", "appid", "page_id", "item_id", "sub_item_id", "module_id", "sub_module_id", "position_id", "test_id", "rule_id", "oper_time", "action_id", "action_value", "action_attr", "trigger_info", "busi_info", "item_type", "qimei" }, new Object[] { "", "", "", Double.valueOf(0.0D), Double.valueOf(0.0D), "", "", "", "", "", "", "", "", "", "", "", "", Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(100), Long.valueOf(0L), Integer.valueOf(1), "", "", "", "" }, UserActionReportReq.class);
  public final PBEnumField action_attr = PBField.initEnum(1);
  public final PBEnumField action_id = PBField.initEnum(100);
  public final PBInt64Field action_value = PBField.initInt64(0L);
  public final PBStringField app_version = PBField.initString("");
  public final PBStringField appid = PBField.initString("");
  public final PBStringField busi_info = PBField.initString("");
  public final PBStringField city_code = PBField.initString("");
  public final PBStringField client_type = PBField.initString("");
  public final PBStringField guid = PBField.initString("");
  public final PBStringField ip_addr = PBField.initString("");
  public final PBStringField item_id = PBField.initString("");
  public final PBStringField item_type = PBField.initString("");
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBStringField market = PBField.initString("");
  public final PBStringField mobile_type = PBField.initString("");
  public final PBStringField module_id = PBField.initString("");
  public final PBStringField network_type = PBField.initString("");
  public final PBInt64Field oper_time = PBField.initInt64(0L);
  public final PBStringField operators = PBField.initString("");
  public final PBStringField os_version = PBField.initString("");
  public final PBStringField page_id = PBField.initString("");
  public final PBStringField platform = PBField.initString("");
  public final PBStringField position_id = PBField.initString("");
  public final PBStringField qimei = PBField.initString("");
  public final PBStringField qua = PBField.initString("");
  public final PBInt64Field rule_id = PBField.initInt64(0L);
  public final PBStringField sub_item_id = PBField.initString("");
  public final PBStringField sub_module_id = PBField.initString("");
  public final PBInt64Field test_id = PBField.initInt64(0L);
  public final PBStringField to_uid = PBField.initString("");
  public final PBStringField trace_detail = PBField.initString("");
  public final PBStringField trace_id = PBField.initString("");
  public final PBStringField trace_index = PBField.initString("");
  public final PBUInt32Field trace_num = PBField.initUInt32(0);
  public final PBStringField trigger_info = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.pb.TianShuReport.UserActionReportReq
 * JD-Core Version:    0.7.0.1
 */