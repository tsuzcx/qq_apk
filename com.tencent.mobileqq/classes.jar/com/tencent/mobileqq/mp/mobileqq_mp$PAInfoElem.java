package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$PAInfoElem
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 58 }, new String[] { "puin", "account_type", "index", "uin_seq", "time", "unread_num", "pa_msg_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), "" }, PAInfoElem.class);
  public final PBUInt32Field account_type = PBField.initUInt32(0);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBStringField pa_msg_id = PBField.initString("");
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBUInt64Field time = PBField.initUInt64(0L);
  public final PBUInt64Field uin_seq = PBField.initUInt64(0L);
  public final PBUInt32Field unread_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.PAInfoElem
 * JD-Core Version:    0.7.0.1
 */