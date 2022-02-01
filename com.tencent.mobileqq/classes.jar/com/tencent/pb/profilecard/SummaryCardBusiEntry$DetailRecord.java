package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SummaryCardBusiEntry$DetailRecord
  extends MessageMicro<DetailRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field fuin = PBField.initUInt32(0);
  public final PBInt32Field hideFlag = PBField.initInt32(0);
  public final PBInt32Field mod = PBField.initInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBUInt32Field vtime = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "fuin", "source", "vtime", "mod", "hideFlag" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger }, DetailRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.profilecard.SummaryCardBusiEntry.DetailRecord
 * JD-Core Version:    0.7.0.1
 */