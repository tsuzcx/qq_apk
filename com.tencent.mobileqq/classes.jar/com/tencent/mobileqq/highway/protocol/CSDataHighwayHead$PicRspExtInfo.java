package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead$PicRspExtInfo
  extends MessageMicro<PicRspExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_skey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_client_ip = PBField.initUInt32(0);
  public final PBUInt64Field uint64_block_size = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_up_offset = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "bytes_skey", "uint32_client_ip", "uint64_up_offset", "uint64_block_size" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, PicRspExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicRspExtInfo
 * JD-Core Version:    0.7.0.1
 */