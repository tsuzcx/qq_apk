package tencent.im.oidb.cmd0xce5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class Oidb_0xce5$RobotInfo
  extends MessageMicro<RobotInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 48, 58, 66, 72, 80, 90, 98, 104, 112, 120, 128, 136, 144, 154 }, new String[] { "robot_uin", "name", "status", "desc", "enabled_groups", "welcome_msg", "call_name", "show_invite", "offline", "verify", "fallback", "join_time", "order", "appid", "api_mark", "miniapp_ids", "robot_type", "extra_info" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), "", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, RobotInfo.class);
  public final PBUInt64Field api_mark = PBField.initUInt64(0L);
  public final PBUInt64Field appid = PBField.initUInt64(0L);
  public final PBStringField call_name = PBField.initString("");
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field enabled_groups = PBField.initUInt32(0);
  public final PBStringField extra_info = PBField.initString("");
  public final PBRepeatField<String> fallback = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBUInt32Field join_time = PBField.initUInt32(0);
  public final PBRepeatField<Long> miniapp_ids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField name = PBField.initString("");
  public final PBUInt32Field offline = PBField.initUInt32(0);
  public final PBUInt32Field order = PBField.initUInt32(0);
  public final PBUInt32Field robot_type = PBField.initUInt32(0);
  public final PBUInt64Field robot_uin = PBField.initUInt64(0L);
  public final PBUInt32Field show_invite = PBField.initUInt32(0);
  public final PBUInt32Field status = PBField.initUInt32(0);
  public final PBStringField verify = PBField.initString("");
  public final PBStringField welcome_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xce5.Oidb_0xce5.RobotInfo
 * JD-Core Version:    0.7.0.1
 */