package tencent.im.oidb.cmd0x5eb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5eb$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField rpt_bytes_openid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_game_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_game_last_login_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_package_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_on_like_ranking_list_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_partake_like_ranking_list_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_plate_of_king_dan = PBField.initUInt32(0);
  public final PBUInt32Field uint32_plate_of_king_dan_display_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_preload_disable_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_allow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_apollo_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_apollo_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_apollo_vip_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_apollo_vip_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_auth_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_cli_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_basic_svr_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_bubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_charm_shown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_city_zone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_common_place1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_country = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_dance_max_score = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_ext_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_addon_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_font_effect_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_forbid_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_freshnews_notify_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_full_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_global_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_god_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_god_forbid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_group_mem_credit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_invite2group_auto_agree_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lang3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_lightalk_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_love_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_medalwall_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss1_service = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss2_identity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss3_bitmapextra = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_mss_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_music_gene = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_music_ring_autoplay = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_music_ring_redpoint = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_music_ring_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_oin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_province = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_c2c_call_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_c2c_last_guide_recharge_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_c2c_try_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_c2c_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_ever_c2c_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_ever_multi_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_multi_call_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_multi_last_guide_recharge_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_multi_try_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_pstn_multi_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_simple_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_stranger_declare = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_stranger_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_subaccount_display_third_qq_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_subscribe_nearbyassistant_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_suspend_effect_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_torchbearer_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_colorring_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_diy_font_timestamp_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_font_id_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_magicfont_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_pendant_diy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_praise_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vas_voicebubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_vip_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torch_disable_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_emoticon_usage_info = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 34, 40, 160016, 160024, 160032, 160072, 160112, 160120, 160160, 160176, 160216, 160240, 160248, 160256, 160264, 160272, 160280, 160296, 160328, 160448, 160472, 168008, 168016, 168024, 168032, 168048, 168056, 208032, 208040, 208080, 208088, 208096, 208104, 208112, 208120, 216176, 216200, 216208, 216272, 216280, 216288, 216296, 216328, 216416, 216472, 217608, 217664, 217736, 217792, 217800, 217872, 217880, 217888, 217904, 217928, 217952, 217960, 218032, 322768, 322784, 322800, 324048, 324056, 324064, 324072, 324200, 324240, 334048, 334264, 334272, 334432, 334440, 335600, 335784, 335944, 335992, 336024, 336040, 336048, 336056, 336064, 336088, 336096, 336192, 336408, 336584, 336600, 336736, 336968, 336976, 343840 }, new String[] { "rpt_uint64_uins", "uint32_max_package_size", "rpt_bytes_openid", "uint32_appid", "uint32_req_nick", "uint32_req_country", "uint32_req_province", "uint32_req_gender", "uint32_req_allow", "uint32_req_face_id", "uint32_req_city", "uint32_req_constellation", "uint32_req_common_place1", "uint32_req_mss3_bitmapextra", "uint32_req_birthday", "uint32_req_city_id", "uint32_req_lang1", "uint32_req_lang2", "uint32_req_lang3", "uint32_req_age", "uint32_req_city_zone_id", "uint32_req_oin", "uint32_req_bubble_id", "uint32_req_mss2_identity", "uint32_req_mss1_service", "uint32_req_lflag", "uint32_req_ext_flag", "uint32_req_basic_svr_flag", "uint32_req_basic_cli_flag", "uint32_req_full_birthday", "uint32_req_full_age", "uint32_req_simple_update_time", "uint32_req_mss_update_time", "uint32_req_pstn_multi_call_time", "uint32_req_pstn_multi_last_guide_recharge_time", "uint32_req_pstn_c2c_call_time", "uint32_req_pstn_c2c_last_guide_recharge_time", "uint32_req_group_mem_credit_flag", "uint32_req_face_addon_id", "uint32_req_music_gene", "uint32_req_stranger_nick", "uint32_req_stranger_declare", "uint32_req_love_status", "uint32_req_profession", "uint32_req_vas_colorring_flag", "uint32_req_charm", "uint32_req_apollo_timestamp", "uint32_req_vas_font_id_flag", "uint32_req_global_group_level", "uint32_req_vas_praise_flag", "uint32_game_last_login_time", "uint32_game_appid", "uint32_req_vas_voicebubble_id", "uint32_req_vas_pendant_diy_id", "uint32_req_suspend_effect_id", "uint32_req_vas_face_id", "uint32_req_vas_diy_font_timestamp_flag", "uint32_vas_emoticon_usage_info", "uint32_req_dance_max_score", "uint32_req_font_effect_id", "uint32_req_invite2group_auto_agree_flag", "uint32_req_subaccount_display_third_qq_flag", "uint32_notify_partake_like_ranking_list_flag", "uint32_req_lightalk_switch", "uint32_req_music_ring_visible", "uint32_req_music_ring_autoplay", "uint32_req_music_ring_redpoint", "uint32_torch_disable_flag", "uint32_req_vas_magicfont_flag", "uint32_req_vip_flag", "uint32_req_auth_flag", "uint32_req_forbid_flag", "uint32_req_god_forbid", "uint32_req_god_flag", "uint32_req_charm_level", "uint32_req_charm_shown", "uint32_req_freshnews_notify_flag", "uint32_req_apollo_vip_level", "uint32_req_apollo_vip_flag", "uint32_req_pstn_c2c_vip", "uint32_req_pstn_multi_vip", "uint32_req_pstn_ever_c2c_vip", "uint32_req_pstn_ever_multi_vip", "uint32_req_pstn_multi_try_flag", "uint32_req_pstn_c2c_try_flag", "uint32_req_subscribe_nearbyassistant_switch", "uint32_req_torchbearer_flag", "uint32_preload_disable_flag", "uint32_req_medalwall_flag", "uint32_notify_on_like_ranking_list_flag", "uint32_plate_of_king_dan_display_switch", "uint32_plate_of_king_dan", "uint32_req_apollo_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody
 * JD-Core Version:    0.7.0.1
 */