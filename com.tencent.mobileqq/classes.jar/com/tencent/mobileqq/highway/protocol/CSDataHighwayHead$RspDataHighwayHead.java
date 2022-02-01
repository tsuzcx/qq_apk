package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead$RspDataHighwayHead
  extends MessageMicro<RspDataHighwayHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_rsp_extendinfo = PBField.initBytes(ByteStringMicro.EMPTY);
  public CSDataHighwayHead.DataHighwayHead msg_basehead = new CSDataHighwayHead.DataHighwayHead();
  public CSDataHighwayHead.SegHead msg_seghead = new CSDataHighwayHead.SegHead();
  public final PBUInt32Field uint32_allow_retry = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cachecost = PBField.initUInt32(0);
  public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
  public final PBUInt32Field uint32_htcost = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_reset = PBField.initUInt32(0);
  public final PBUInt64Field uint64_range = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 58, 64, 72, 80 }, new String[] { "msg_basehead", "msg_seghead", "uint32_error_code", "uint32_allow_retry", "uint32_cachecost", "uint32_htcost", "bytes_rsp_extendinfo", "uint64_timestamp", "uint64_range", "uint32_is_reset" }, new Object[] { null, null, localInteger, localInteger, localInteger, localInteger, localByteStringMicro, localLong, localLong, localInteger }, RspDataHighwayHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.RspDataHighwayHead
 * JD-Core Version:    0.7.0.1
 */