package com.trunk.feeds_inner_define;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class feeds_inner_define$ConcernUinRecord
  extends MessageMicro<ConcernUinRecord>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field uint32_concern_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ignore_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_read_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_concern_uin = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "uint64_concern_uin", "uint32_confirm_time", "uint32_read_time", "uint32_concern_type", "uint32_ignore_time" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger }, ConcernUinRecord.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.trunk.feeds_inner_define.feeds_inner_define.ConcernUinRecord
 * JD-Core Version:    0.7.0.1
 */