package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class GetExtendFriendInfo$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt32Field uint32_bigvip_hide = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bigvip_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bigvip_open = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_show_card = PBField.initUInt32(0);
  public final PBUInt32Field uint32_popularity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_vip_info_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_svip_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vipicon_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_duration = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 130, 136 }, new String[] { "uint64_uin", "bytes_declaration", "bytes_voice_url", "uint32_popularity", "uint64_update_time", "uint32_is_show_card", "uint32_voice_duration", "uint32_show_vip_info_flag", "uint32_svip_level", "uint32_vipicon_id", "uint32_bigvip_level", "uint32_bigvip_open", "uint32_bigvip_hide", "uint32_vip_flag", "uint32_gender", "str_nick", "uint32_total_like_count" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0) }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody
 * JD-Core Version:    0.7.0.1
 */