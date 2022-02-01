package com.tencent.pb.now;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_feeds_read$ReadNearUserFeedsReq
  extends MessageMicro<ReadNearUserFeedsReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field bus_id = PBField.initUInt64(0L);
  public final PBUInt32Field id_type = PBField.initUInt32(0);
  public final PBBytesField lat = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField lng = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field num = PBField.initUInt32(0);
  public final PBUInt32Field pos = PBField.initUInt32(0);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 34, 42, 48, 56, 64 }, new String[] { "pos", "num", "lng", "lat", "id_type", "bus_id", "tinyid" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, ReadNearUserFeedsReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.pb.now.ilive_feeds_read.ReadNearUserFeedsReq
 * JD-Core Version:    0.7.0.1
 */