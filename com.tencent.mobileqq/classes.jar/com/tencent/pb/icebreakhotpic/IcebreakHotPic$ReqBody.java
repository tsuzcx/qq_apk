package com.tencent.pb.icebreakhotpic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class IcebreakHotPic$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
  public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 48, 56 }, new String[] { "bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_aio_type", "uint64_to_uin", "uin32_gender", "uint32_age" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.icebreakhotpic.IcebreakHotPic.ReqBody
 * JD-Core Version:    0.7.0.1
 */