package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x496$UinRange
  extends MessageMicro<UinRange>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field end_uin = PBField.initUInt64(0L);
  public final PBUInt64Field start_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "start_uin", "end_uin" }, new Object[] { localLong, localLong }, UinRange.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.org.pb.oidb_0x496.UinRange
 * JD-Core Version:    0.7.0.1
 */