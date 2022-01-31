package tencent.im.oidb.cmd0x9e4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x9e4$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_bytes_openid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_package_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_allow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_auth_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_cli_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_svr_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_bubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_cface_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_charm_shown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_zone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_clear_gps = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_close_fresh_push_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_common_label = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_common_place1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_country = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_ext_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_addon_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_forbid_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gift_activated_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_god_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_god_forbid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_group_mem_credit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_love_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss1_service = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss2_identity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss3_bitmapextra = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_music_gene = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_oin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_province = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pub_number_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_simple_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_stranger_declare = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_stranger_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vip_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vote_flag = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 34, 40, 160016, 160024, 160032, 160072, 160112, 160120, 160160, 160176, 160216, 160240, 160248, 160256, 160264, 160272, 160280, 160296, 160328, 160448, 160472, 168008, 168016, 168024, 168032, 168048, 168056, 208032, 208040, 208080, 208088, 216176, 216200, 216208, 216272, 216280, 216288, 216296, 216416, 322592, 324448, 334048, 334264, 334272, 334280, 334432, 334440, 334456, 335600, 335784, 335944, 335976, 440000 }, new String[] { "rpt_uint64_uins", "uint32_max_package_size", "rpt_bytes_openid", "uint32_appid", "uint32_req_nick", "uint32_req_country", "uint32_req_province", "uint32_req_gender", "uint32_req_allow", "uint32_req_face_id", "uint32_req_city", "uint32_req_constellation", "uint32_req_common_place1", "uint32_req_mss3_bitmapextra", "uint32_req_birthday", "uint32_req_city_id", "uint32_req_lang1", "uint32_req_lang2", "uint32_req_lang3", "uint32_req_age", "uint32_req_city_zone_id", "uint32_req_oin", "uint32_req_bubble_id", "uint32_req_mss2_identity", "uint32_req_mss1_service", "uint32_req_lflag", "uint32_req_ext_flag", "uint32_req_basic_svr_flag", "uint32_req_basic_cli_flag", "uint32_req_full_birthday", "uint32_req_full_age", "uint32_req_simple_update_time", "uint32_req_mss_update_time", "uint32_req_group_mem_credit_flag", "uint32_req_face_addon_id", "uint32_req_music_gene", "uint32_req_stranger_nick", "uint32_req_stranger_declare", "uint32_req_love_status", "uint32_req_profession", "uint32_req_charm", "uint32_req_vote_flag", "uint32_req_cface_flag", "uint32_req_vip_flag", "uint32_req_auth_flag", "uint32_req_forbid_flag", "uint32_req_gift_activated_flag", "uint32_req_god_forbid", "uint32_req_god_flag", "uint32_req_clear_gps", "uint32_req_charm_level", "uint32_req_charm_shown", "uint32_req_close_fresh_push_flag", "uint32_req_pub_number_flag", "uint32_req_common_label" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x9e4.cmd0x9e4.ReqBody
 * JD-Core Version:    0.7.0.1
 */