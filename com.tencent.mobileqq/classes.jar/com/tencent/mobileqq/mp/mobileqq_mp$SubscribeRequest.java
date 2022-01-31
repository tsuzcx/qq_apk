package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_mp$SubscribeRequest
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32 }, new String[] { "puin", "template_id", "msg_id", "index" }, new Object[] { Long.valueOf(0L), "", Long.valueOf(0L), Integer.valueOf(0) }, SubscribeRequest.class);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt64Field msg_id = PBField.initUInt64(0L);
  public final PBUInt64Field puin = PBField.initUInt64(0L);
  public final PBStringField template_id = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.mp.mobileqq_mp.SubscribeRequest
 * JD-Core Version:    0.7.0.1
 */