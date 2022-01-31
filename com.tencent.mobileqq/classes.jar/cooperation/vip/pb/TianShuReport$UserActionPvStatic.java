package cooperation.vip.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class TianShuReport$UserActionPvStatic
  extends MessageMicro<UserActionPvStatic>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 50, 56, 64 }, new String[] { "appid", "page_id", "module_id", "sub_module_id", "rule_id", "item_id", "action_id", "value" }, new Object[] { "", "", "", "", Long.valueOf(0L), "", Integer.valueOf(100), Long.valueOf(0L) }, UserActionPvStatic.class);
  public final PBEnumField action_id = PBField.initEnum(100);
  public final PBStringField appid = PBField.initString("");
  public final PBStringField item_id = PBField.initString("");
  public final PBStringField module_id = PBField.initString("");
  public final PBStringField page_id = PBField.initString("");
  public final PBInt64Field rule_id = PBField.initInt64(0L);
  public final PBStringField sub_module_id = PBField.initString("");
  public final PBInt64Field value = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.pb.TianShuReport.UserActionPvStatic
 * JD-Core Version:    0.7.0.1
 */