package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class NowSummaryCard$NearbySummaryCardRsp
  extends MessageMicro<NearbySummaryCardRsp>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBUInt32Field id_type = PBField.initUInt32(0);
  public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field ret_code = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "pb_data", "id", "id_type", "ret_code", "err_msg" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2 }, NearbySummaryCardRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.nowsummarycard.NowSummaryCard.NearbySummaryCardRsp
 * JD-Core Version:    0.7.0.1
 */