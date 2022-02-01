package com.tencent.mobileqq.mp;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class MqqNearbyGdt$ExposeResponse
  extends MessageMicro<ExposeResponse>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "retcode" }, new Object[] { Integer.valueOf(0) }, ExposeResponse.class);
  public final PBInt32Field retcode = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mp.MqqNearbyGdt.ExposeResponse
 * JD-Core Version:    0.7.0.1
 */