package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5e1$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_bytes_openid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_package_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_allow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_cli_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_svr_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_bubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_business_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_zone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_common_place1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_country = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_crm_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_ext_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_addon_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_file_share_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_forbid_fileshare_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_group_mem_credit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss1_service = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss2_identity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss3_bitmapextra = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_music_gene = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_oin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_old_friend_chat_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pengyou_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pengyou_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pengyou_realname = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_province = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_recommend_privacy_ctrl_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_simple_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_start_time = PBField.initUInt32(0);
  public final PBUInt32Field user_login_guard_face = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 160016, 160024, 160032, 160072, 160112, 160120, 160160, 160216, 160240, 160248, 160256, 160264, 160272, 160280, 160328, 160448, 160472, 168008, 168016, 168024, 168032, 168048, 168056, 192808, 192824, 192944, 208032, 208040, 208080, 208088, 216176, 216200, 216208, 322584, 323232, 324040, 324816, 330440, 334480, 338664 }, new String[] { "rpt_uint64_uins", "uint32_start_time", "uint32_max_package_size", "rpt_bytes_openid", "uint32_appid", "uint32_req_nick", "uint32_req_country", "uint32_req_province", "uint32_req_gender", "uint32_req_allow", "uint32_req_face_id", "uint32_req_city", "uint32_req_common_place1", "uint32_req_mss3_bitmapextra", "uint32_req_birthday", "uint32_req_city_id", "uint32_req_lang1", "uint32_req_lang2", "uint32_req_lang3", "uint32_req_city_zone_id", "uint32_req_oin", "uint32_req_bubble_id", "uint32_req_mss2_identity", "uint32_req_mss1_service", "uint32_req_lflag", "uint32_req_ext_flag", "uint32_req_basic_svr_flag", "uint32_req_basic_cli_flag", "uint32_req_pengyou_realname", "uint32_req_pengyou_gender", "uint32_req_pengyou_flag", "uint32_req_full_birthday", "uint32_req_full_age", "uint32_req_simple_update_time", "uint32_req_mss_update_time", "uint32_req_group_mem_credit_flag", "uint32_req_face_addon_id", "uint32_req_music_gene", "uint32_req_file_share_bit", "uint32_req_recommend_privacy_ctrl_bit", "uint32_req_old_friend_chat_bit", "uint32_req_business_bit", "uint32_req_crm_bit", "uint32_req_forbid_fileshare_bit", "user_login_guard_face" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localByteStringMicro, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0x5e1.ReqBody
 * JD-Core Version:    0.7.0.1
 */