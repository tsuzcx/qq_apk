package com.tencent.msf.service.protocol.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SSOLoginMerge$BusiBuffData
  extends MessageMicro
{
  public static final int BUSIBUFFVEC_FIELD_NUMBER = 1;
  public static final int MAXRESPSIZEHINT_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "BusiBuffVec", "MaxRespSizeHint" }, new Object[] { null, Integer.valueOf(0) }, BusiBuffData.class);
  public final PBRepeatMessageField BusiBuffVec = PBField.initRepeatMessage(SSOLoginMerge.BusiBuffItem.class);
  public final PBUInt32Field MaxRespSizeHint = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.service.protocol.pb.SSOLoginMerge.BusiBuffData
 * JD-Core Version:    0.7.0.1
 */