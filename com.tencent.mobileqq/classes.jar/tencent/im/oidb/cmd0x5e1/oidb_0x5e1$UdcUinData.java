package tencent.im.oidb.cmd0x5e1;

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
  public static final int BYTES_BASIC_CLI_FLAG_FIELD_NUMBER = 21007;
  public static final int BYTES_BASIC_SVR_FLAG_FIELD_NUMBER = 21006;
  public static final int BYTES_BIRTHDAY_FIELD_NUMBER = 20031;
  public static final int BYTES_CITY_FIELD_NUMBER = 20020;
  public static final int BYTES_CITY_ID_FIELD_NUMBER = 20032;
  public static final int BYTES_COUNTRY_FIELD_NUMBER = 20003;
  public static final int BYTES_FULL_AGE_FIELD_NUMBER = 26005;
  public static final int BYTES_FULL_BIRTHDAY_FIELD_NUMBER = 26004;
  public static final int BYTES_MSS1_SERVICE_FIELD_NUMBER = 21002;
  public static final int BYTES_MSS2_IDENTITY_FIELD_NUMBER = 21001;
  public static final int BYTES_MSS3_BITMAPEXTRA_FIELD_NUMBER = 20030;
  public static final int BYTES_MUSIC_GENE_FIELD_NUMBER = 27026;
  public static final int BYTES_NICK_FIELD_NUMBER = 20002;
  public static final int BYTES_OPENID_FIELD_NUMBER = 4;
  public static final int BYTES_PENGYOU_REALNAME_FIELD_NUMBER = 24101;
  public static final int BYTES_PROVINCE_FIELD_NUMBER = 20004;
  public static final int UINT32_ALLOW_FIELD_NUMBER = 20014;
  public static final int UINT32_BUBBLE_ID_FIELD_NUMBER = 20059;
  public static final int UINT32_CITY_ZONE_ID_FIELD_NUMBER = 20041;
  public static final int UINT32_COMMON_PLACE1_FIELD_NUMBER = 20027;
  public static final int UINT32_EXT_FLAG_FIELD_NUMBER = 21004;
  public static final int UINT32_FACE_ID_FIELD_NUMBER = 20015;
  public static final int UINT32_GENDER_FIELD_NUMBER = 20009;
  public static final int UINT32_GROUP_MEM_CREDIT_FLAG_FIELD_NUMBER = 27022;
  public static final int UINT32_LANG1_FIELD_NUMBER = 20033;
  public static final int UINT32_LANG2_FIELD_NUMBER = 20034;
  public static final int UINT32_LANG3_FIELD_NUMBER = 20035;
  public static final int UINT32_LFLAG_FIELD_NUMBER = 21003;
  public static final int UINT32_MSS_UPDATE_TIME_FIELD_NUMBER = 26011;
  public static final int UINT32_OIN_FIELD_NUMBER = 20056;
  public static final int UINT32_PENGYOU_FLAG_FIELD_NUMBER = 24118;
  public static final int UINT32_PENGYOU_GENDER_FIELD_NUMBER = 24103;
  public static final int UINT32_SIMPLE_UPDATE_TIME_FIELD_NUMBER = 26010;
  public static final int UINT64_FACE_ADDON_ID_FIELD_NUMBER = 27025;
  public static final int UINT64_UIN_FIELD_NUMBER = 1;
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
  public final PBUInt32Field uint32_city_zone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_common_place1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ext_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_mem_credit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mss_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_oin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pengyou_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pengyou_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_simple_update_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_face_addon_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 34, 160018, 160026, 160034, 160072, 160112, 160120, 160162, 160216, 160242, 160250, 160258, 160264, 160272, 160280, 160328, 160448, 160472, 168010, 168018, 168024, 168032, 168050, 168058, 192810, 192824, 192944, 208034, 208042, 208080, 208088, 216176, 216200, 216210 }, new String[] { "uint64_uin", "bytes_openid", "bytes_nick", "bytes_country", "bytes_province", "uint32_gender", "uint32_allow", "uint32_face_id", "bytes_city", "uint32_common_place1", "bytes_mss3_bitmapextra", "bytes_birthday", "bytes_city_id", "uint32_lang1", "uint32_lang2", "uint32_lang3", "uint32_city_zone_id", "uint32_oin", "uint32_bubble_id", "bytes_mss2_identity", "bytes_mss1_service", "uint32_lflag", "uint32_ext_flag", "bytes_basic_svr_flag", "bytes_basic_cli_flag", "bytes_pengyou_realname", "uint32_pengyou_gender", "uint32_pengyou_flag", "bytes_full_birthday", "bytes_full_age", "uint32_simple_update_time", "uint32_mss_update_time", "uint32_group_mem_credit_flag", "uint64_face_addon_id", "bytes_music_gene" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro14, localByteStringMicro15, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro16 }, UdcUinData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5e1.oidb_0x5e1.UdcUinData
 * JD-Core Version:    0.7.0.1
 */