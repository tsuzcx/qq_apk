package com.tencent.pb.qqvalue;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqvalue$GetQQValueRsp
  extends MessageMicro<GetQQValueRsp>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "qq_value" }, new Object[] { null }, GetQQValueRsp.class);
  public qqvalue.UserQQValueInfo qq_value = new qqvalue.UserQQValueInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pb.qqvalue.qqvalue.GetQQValueRsp
 * JD-Core Version:    0.7.0.1
 */