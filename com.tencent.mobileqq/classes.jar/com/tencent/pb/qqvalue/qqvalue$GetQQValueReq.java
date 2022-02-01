package com.tencent.pb.qqvalue;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqvalue$GetQQValueReq
  extends MessageMicro<GetQQValueReq>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "ext_info" }, new Object[] { Long.valueOf(0L), null }, GetQQValueReq.class);
  public final PBRepeatMessageField<qqvalue.GetQQValueReq.ExtInfo> ext_info = PBField.initRepeatMessage(qqvalue.GetQQValueReq.ExtInfo.class);
  public final PBInt64Field uin = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.qqvalue.qqvalue.GetQQValueReq
 * JD-Core Version:    0.7.0.1
 */