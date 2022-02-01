package com.tencent.mobileqq.qwallet.hb.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x438$RedBagInfo
  extends MessageMicro<RedBagInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_pc_body = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_authkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_index = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_password = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_redbag_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_source = PBField.initUInt32(0);
  public final PBUInt64Field uint64_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_creator_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_expire_time = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 56, 66, 74 }, new String[] { "uint64_creator_uin", "string_redbag_id", "uint64_expire_time", "string_password", "string_authkey", "uint64_code", "uint32_source", "bytes_pc_body", "string_index" }, new Object[] { localLong, localByteStringMicro1, localLong, localByteStringMicro2, localByteStringMicro3, localLong, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5 }, RedBagInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.pb.oidb_0x438.RedBagInfo
 * JD-Core Version:    0.7.0.1
 */