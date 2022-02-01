package com.tencent.mobileqq.comment.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xdea$Topic
  extends MessageMicro<Topic>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_src_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBEnumField entrance = PBField.initEnum(1);
  public final PBUInt32Field uint32_send_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_seq = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_send_uin", "uint64_seq", "uint32_send_time", "entrance", "bytes_src_msg" }, new Object[] { localLong, localLong, Integer.valueOf(0), Integer.valueOf(1), localByteStringMicro }, Topic.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.comment.oidb.oidb_0xdea.Topic
 * JD-Core Version:    0.7.0.1
 */