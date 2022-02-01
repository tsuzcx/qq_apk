package com.tencent.mobileqq.qwallet.hb.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x438$ReqInfo
  extends MessageMicro<ReqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_redbag_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_code", "uint64_last_redbag_time" }, new Object[] { localLong, localLong }, ReqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.ReqInfo
 * JD-Core Version:    0.7.0.1
 */