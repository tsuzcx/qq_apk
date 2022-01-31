package com.tencent.pb.getnumredmsg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NumRedMsg$NumMsgBusi
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 74 }, new String[] { "ui64_msgid", "ui_appid", "str_path", "str_missionid", "ui_expire_time", "str_content", "str_url", "str_ext", "str_ret" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "" }, NumMsgBusi.class);
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_ext = PBField.initString("");
  public final PBStringField str_missionid = PBField.initString("");
  public final PBStringField str_path = PBField.initString("");
  public final PBStringField str_ret = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt64Field ui64_msgid = PBField.initUInt64(0L);
  public final PBUInt32Field ui_appid = PBField.initUInt32(0);
  public final PBUInt32Field ui_expire_time = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getnumredmsg.NumRedMsg.NumMsgBusi
 * JD-Core Version:    0.7.0.1
 */