package com.tencent.pb.apollo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class STGameLogin$STGameLoginReq
  extends MessageMicro<STGameLoginReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "local_ts", "from" }, new Object[] { Integer.valueOf(0), "" }, STGameLoginReq.class);
  public final PBStringField from = PBField.initString("");
  public final PBUInt32Field local_ts = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.apollo.STGameLogin.STGameLoginReq
 * JD-Core Version:    0.7.0.1
 */