package com.tencent.mobileqq.tianshu.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BusinessInfoCheckUpdate$NumMsgBusi
  extends MessageMicro<NumMsgBusi>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 58, 66, 74 }, new String[] { "uint64_msgid", "uint32_appid", "str_path", "str_missionid", "uint32_expire_time", "str_content", "str_url", "str_ext", "str_ret" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), "", "", "", "" }, NumMsgBusi.class);
  public final PBStringField str_content = PBField.initString("");
  public final PBStringField str_ext = PBField.initString("");
  public final PBStringField str_missionid = PBField.initString("");
  public final PBStringField str_path = PBField.initString("");
  public final PBStringField str_ret = PBField.initString("");
  public final PBStringField str_url = PBField.initString("");
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msgid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.NumMsgBusi
 * JD-Core Version:    0.7.0.1
 */