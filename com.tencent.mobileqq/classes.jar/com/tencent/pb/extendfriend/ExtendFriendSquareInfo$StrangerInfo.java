package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ExtendFriendSquareInfo$StrangerInfo
  extends MessageMicro<StrangerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ad_content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_declaration = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_personalization = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_tmp_session_sig = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_voice_code = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_voice_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<ExtendFriendSquareInfo.labelInfo> rpt_label_info = PBField.initRepeatMessage(ExtendFriendSquareInfo.labelInfo.class);
  public final PBRepeatMessageField<ExtendFriendSquareInfo.schoolInfo> rpt_school_info = PBField.initRepeatMessage(ExtendFriendSquareInfo.schoolInfo.class);
  public final PBStringField str_recom_trace = PBField.initString("");
  public final PBUInt32Field uint32_addfri_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bigvip_hide = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bigvip_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bigvip_open = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_my_like = PBField.initUInt32(0);
  public final PBUInt32Field uint32_my_left_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_popularity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_show_vip_info_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_svip_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_total_like_count = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vipicon_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_voice_duration = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vote_switch = PBField.initUInt32(0);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_update_time = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 66, 74, 80, 90, 96, 112, 120, 128, 138, 144, 152, 160, 168, 176, 184, 192, 202, 210, 218, 224, 234, 242 }, new String[] { "uint64_uin", "bytes_cover_url", "uint32_total_like_count", "uint32_is_my_like", "uint32_my_left_like_count", "bytes_nick", "uint32_popularity", "bytes_declaration", "bytes_voice_url", "uint64_update_time", "bytes_tmp_session_sig", "uint32_voice_duration", "uint32_gender", "uint32_addfri_status", "uint32_vote_switch", "str_recom_trace", "uint32_show_vip_info_flag", "uint32_svip_level", "uint32_vipicon_id", "uint32_bigvip_level", "uint32_bigvip_open", "uint32_bigvip_hide", "uint32_vip_flag", "bytes_ad_content", "bytes_personalization", "rpt_label_info", "uint32_age", "bytes_voice_code", "rpt_school_info" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localInteger, localInteger, localInteger, localByteStringMicro2, localInteger, localByteStringMicro3, localByteStringMicro4, Long.valueOf(0L), localByteStringMicro5, localInteger, localInteger, localInteger, localInteger, "", localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro6, localByteStringMicro7, null, localInteger, localByteStringMicro8, null }, StrangerInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.pb.extendfriend.ExtendFriendSquareInfo.StrangerInfo
 * JD-Core Version:    0.7.0.1
 */