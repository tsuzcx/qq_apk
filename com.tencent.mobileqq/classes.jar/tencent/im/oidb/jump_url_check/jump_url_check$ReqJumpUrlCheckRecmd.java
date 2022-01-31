package tencent.im.oidb.jump_url_check;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class jump_url_check$ReqJumpUrlCheckRecmd
  extends MessageMicro<ReqJumpUrlCheckRecmd>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "uin", "jump_url", "pkg_name", "schema", "action", "activity_list" }, new Object[] { Long.valueOf(0L), "", "", "", "", null }, ReqJumpUrlCheckRecmd.class);
  public final PBStringField action = PBField.initString("");
  public final PBRepeatMessageField<jump_url_check.ActivityInfo> activity_list = PBField.initRepeatMessage(jump_url_check.ActivityInfo.class);
  public final PBStringField jump_url = PBField.initString("");
  public final PBStringField pkg_name = PBField.initString("");
  public final PBStringField schema = PBField.initString("");
  public final PBUInt64Field uin = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.jump_url_check.jump_url_check.ReqJumpUrlCheckRecmd
 * JD-Core Version:    0.7.0.1
 */