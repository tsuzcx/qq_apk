package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$GetBusinessMobileReq
  extends MessageMicro<GetBusinessMobileReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field uint64_cqquin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_extuin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_cqquin", "uint64_extuin" }, new Object[] { localLong, localLong }, GetBusinessMobileReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.GetBusinessMobileReq
 * JD-Core Version:    0.7.0.1
 */