package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e1$UdcUinData
  extends MessageMicro<UdcUinData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_basic_cli_flag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_basic_svr_flag = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_birthday = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_city = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_city_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_country = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_full_age = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_full_birthday = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mss1_service = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mss2_identity = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_mss3_bitmapextra = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_music_gene = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_openid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_pengyou_realname = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_province = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_allow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_business_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_city_zone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_common_place1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_crm_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ext_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_share_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_forbid_fileshare_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_mem_credit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mss_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_oin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_old_friend_chat = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pengyou_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pengyou_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_recommend_privacy_ctrl = PBField.initUInt32(0);
  public final PBUInt32Field uint32_simple_update_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_face_addon_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  public final PBUInt32Field user_login_guard_face = PBField.initUInt32(0);
  
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
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro10 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro11 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro12 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro13 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro14 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro15 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro16 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 34, 160018, 160026, 160034, 160072, 160112, 160120, 160162, 160216, 160242, 160250, 160258, 160264, 160272, 160280, 160328, 160448, 160472, 168010, 168018, 168024, 168032, 168050, 168058, 192810, 192824, 192944, 208034, 208042, 208080, 208088, 216176, 216200, 216210, 322584, 323232, 324040, 324816, 330440, 334480, 338664 }, new String[] { "uint64_uin", "bytes_openid", "bytes_nick", "bytes_country", "bytes_province", "uint32_gender", "uint32_allow", "uint32_face_id", "bytes_city", "uint32_common_place1", "bytes_mss3_bitmapextra", "bytes_birthday", "bytes_city_id", "uint32_lang1", "uint32_lang2", "uint32_lang3", "uint32_city_zone_id", "uint32_oin", "uint32_bubble_id", "bytes_mss2_identity", "bytes_mss1_service", "uint32_lflag", "uint32_ext_flag", "bytes_basic_svr_flag", "bytes_basic_cli_flag", "bytes_pengyou_realname", "uint32_pengyou_gender", "uint32_pengyou_flag", "bytes_full_birthday", "bytes_full_age", "uint32_simple_update_time", "uint32_mss_update_time", "uint32_group_mem_credit_flag", "uint64_face_addon_id", "bytes_music_gene", "uint32_file_share_bit", "uint32_recommend_privacy_ctrl", "uint32_old_friend_chat", "uint32_business_bit", "uint32_crm_bit", "uint32_forbid_fileshare_bit", "user_login_guard_face" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localInteger, localInteger, localInteger, localByteStringMicro5, localInteger, localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localByteStringMicro9, localByteStringMicro10, localInteger, localInteger, localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localInteger, localInteger, localByteStringMicro14, localByteStringMicro15, localInteger, localInteger, localInteger, Long.valueOf(0L), localByteStringMicro16, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, UdcUinData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x5e1.UdcUinData
 * JD-Core Version:    0.7.0.1
 */