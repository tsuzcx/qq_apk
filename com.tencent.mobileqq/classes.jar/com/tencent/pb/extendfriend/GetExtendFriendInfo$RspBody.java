package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetExtendFriendInfo$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_show_card = PBField.initUInt32(0);
  public final PBUInt32Field uint32_popularity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_duration = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56 }, new String[] { "uint64_uin", "bytes_declaration", "bytes_voice_url", "uint32_popularity", "uint64_update_time", "uint32_is_show_card", "uint32_voice_duration" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody
 * JD-Core Version:    0.7.0.1
 */