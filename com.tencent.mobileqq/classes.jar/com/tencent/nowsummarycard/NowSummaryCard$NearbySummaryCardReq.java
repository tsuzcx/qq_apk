package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$NearbySummaryCardReq
  extends MessageMicro<NearbySummaryCardReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field gender = PBField.initUInt64(0L);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBUInt32Field id_type = PBField.initUInt32(0);
  public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "pb_data", "id", "id_type", "gender" }, new Object[] { localByteStringMicro, localLong, Integer.valueOf(0), localLong }, NearbySummaryCardReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbySummaryCardReq
 * JD-Core Version:    0.7.0.1
 */