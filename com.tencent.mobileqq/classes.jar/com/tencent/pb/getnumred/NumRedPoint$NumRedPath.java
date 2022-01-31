package com.tencent.pb.getnumred;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NumRedPoint$NumRedPath
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48 }, new String[] { "str_path", "str_missionid", "uint64_msgid", "uint32_msg_status", "uint32_expire_time", "uint32_push_num_red_ts" }, new Object[] { "", "", Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, NumRedPath.class);
  public final PBStringField str_missionid = PBField.initString("");
  public final PBStringField str_path = PBField.initString("");
  public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_push_num_red_ts = PBField.initUInt32(0);
  public final PBUInt64Field uint64_msgid = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.getnumred.NumRedPoint.NumRedPath
 * JD-Core Version:    0.7.0.1
 */