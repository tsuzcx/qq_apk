package com.tencent.mobileqq.highway.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CSDataHighwayHead$SegHead
  extends MessageMicro<SegHead>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_serviceticket = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_cache_addr = PBField.initUInt32(0);
  public final PBUInt32Field uint32_datalength = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_query_times = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rtcode = PBField.initUInt32(0);
  public final PBUInt32Field uint32_serviceid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_update_cacheip = PBField.initUInt32(0);
  public final PBUInt64Field uint64_dataoffset = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_filesize = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 56, 66, 74, 80, 88, 96 }, new String[] { "uint32_serviceid", "uint64_filesize", "uint64_dataoffset", "uint32_datalength", "uint32_rtcode", "bytes_serviceticket", "uint32_flag", "bytes_md5", "bytes_file_md5", "uint32_cache_addr", "uint32_query_times", "uint32_update_cacheip" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SegHead.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead
 * JD-Core Version:    0.7.0.1
 */