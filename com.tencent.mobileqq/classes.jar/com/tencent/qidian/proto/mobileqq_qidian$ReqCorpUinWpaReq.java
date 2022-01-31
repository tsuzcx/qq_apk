package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_qidian$ReqCorpUinWpaReq
  extends MessageMicro<ReqCorpUinWpaReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_sigt = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_assign_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_assign_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_touin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40 }, new String[] { "bytes_sigt", "uint64_qquin", "uint64_touin", "uint32_assign_type", "uint64_assign_id" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L) }, ReqCorpUinWpaReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.qidian.proto.mobileqq_qidian.ReqCorpUinWpaReq
 * JD-Core Version:    0.7.0.1
 */