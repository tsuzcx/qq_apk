package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class structmsg$GroupInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48 }, new String[] { "group_auth_type", "display_action", "msg_alert", "msg_detail_alert", "msg_other_admin_done", "uint32_app_privilege_flag" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), "", "", "", Integer.valueOf(0) }, GroupInfo.class);
  public final PBUInt32Field display_action = PBField.initUInt32(0);
  public final PBUInt32Field group_auth_type = PBField.initUInt32(0);
  public final PBStringField msg_alert = PBField.initString("");
  public final PBStringField msg_detail_alert = PBField.initString("");
  public final PBStringField msg_other_admin_done = PBField.initString("");
  public final PBUInt32Field uint32_app_privilege_flag = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.GroupInfo
 * JD-Core Version:    0.7.0.1
 */