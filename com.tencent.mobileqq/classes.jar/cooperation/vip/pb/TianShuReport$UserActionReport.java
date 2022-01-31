package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class TianShuReport$UserActionReport
  extends MessageMicro<UserActionReport>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 112, 120, 128, 136, 146, 154, 162, 170 }, new String[] { "trace_id", "trace_num", "trace_detail", "trace_index", "appid", "page_id", "item_id", "sub_item_id", "module_id", "sub_module_id", "position_id", "test_id", "rule_id", "oper_time", "action_id", "action_value", "action_attr", "trigger_info", "busi_info", "item_type", "to_uid" }, new Object[] { "", Integer.valueOf(0), "", "", "", "", "", "", "", "", "", Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(100), Long.valueOf(0L), Integer.valueOf(1), "", "", "", "" }, UserActionReport.class);
  public final PBEnumField action_attr = PBField.initEnum(1);
  public final PBEnumField action_id = PBField.initEnum(100);
  public final PBInt64Field action_value = PBField.initInt64(0L);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField busi_info = PBField.initString("");
  public final PBStringField item_id = PBField.initString("");
  public final PBStringField item_type = PBField.initString("");
  public final PBStringField module_id = PBField.initString("");
  public final PBInt64Field oper_time = PBField.initInt64(0L);
  public final PBStringField page_id = PBField.initString("");
  public final PBStringField position_id = PBField.initString("");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.pb.TianShuReport.UserActionReport
 * JD-Core Version:    0.7.0.1
 */