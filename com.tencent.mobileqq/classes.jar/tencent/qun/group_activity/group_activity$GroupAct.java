package tencent.qun.group_activity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class group_activity$GroupAct
  extends MessageMicro<GroupAct>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField string_btntext = PBField.initString("");
  public final PBStringField string_des = PBField.initString("");
  public final PBStringField string_iconurl = PBField.initString("");
  public final PBStringField string_jumpparam = PBField.initString("");
  public final PBStringField string_title = PBField.initString("");
  public final PBStringField string_url = PBField.initString("");
  public final PBUInt32Field uint32_act_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_end_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_jumptype = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40, 50, 58, 66, 72, 80 }, new String[] { "uint32_act_id", "string_title", "string_des", "string_url", "uint32_jumptype", "string_jumpparam", "string_iconurl", "string_btntext", "uint32_start_time", "uint32_end_time" }, new Object[] { localInteger, "", "", "", localInteger, "", "", "", localInteger, localInteger }, GroupAct.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.qun.group_activity.group_activity.GroupAct
 * JD-Core Version:    0.7.0.1
 */