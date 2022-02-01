package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead$DataHole
  extends MessageMicro<DataHole>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_begin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_end = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_begin", "uint64_end" }, new Object[] { localLong, localLong }, DataHole.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.DataHole
 * JD-Core Version:    0.7.0.1
 */