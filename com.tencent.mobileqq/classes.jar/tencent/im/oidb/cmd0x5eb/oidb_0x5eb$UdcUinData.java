package tencent.im.oidb.cmd0x5eb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x5eb$UdcUinData
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
  public final PBBytesField bytes_province = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stranger_declare = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_stranger_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field int32_history_num_flag = PBField.initUInt32(0);
  public final PBUInt32Field roam_flag_qq_7day = PBField.initUInt32(0);
  public final PBUInt32Field roam_flag_svip_2year = PBField.initUInt32(0);
  public final PBUInt32Field roam_flag_svip_5year = PBField.initUInt32(0);
  public final PBUInt32Field roam_flag_svip_forever = PBField.initUInt32(0);
  public final PBUInt32Field roam_flag_vip_30day = PBField.initUInt32(0);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_allow = PBField.initUInt32(0);
  public final PBUInt32Field uint32_apollo_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_apollo_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_apollo_vip_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_apollo_vip_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_auth_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_auto_to_text_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_bubble_unread_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_charm_shown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_city_zone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmshow_3d_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_common_place1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_constellation = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dance_max_score = PBField.initUInt32(0);
  public final PBUInt32Field uint32_do_not_disturb_mode_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ext_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_extend_friend_card_shown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_extend_friend_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_color_note_recent_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_hide_pretty_group_owner_identity = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_is_pretty_group_owner = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_school_verified = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_study_mode_student = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_study_mode_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_super_yellow_diamond = PBField.initUInt32(0);
  public final PBUInt32Field uint32_forbid_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_freshnews_notify_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_global_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_god_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_god_forbid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_mem_credit_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hidden_session_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hidden_session_video_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_input_status_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang1 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lang3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lflag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_lightalk_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_love_status = PBField.initUInt32(0);
  public final PBUInt32Field uint32_mss_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_music_ring_autoplay = PBField.initUInt32(0);
  public final PBUInt32Field uint32_music_ring_redpoint = PBField.initUInt32(0);
  public final PBUInt32Field uint32_music_ring_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_on_like_ranking_list_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_notify_partake_like_ranking_list_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_oin = PBField.initUInt32(0);
  public final PBUInt32Field uint32_plate_of_king_dan = PBField.initUInt32(0);
  public final PBUInt32Field uint32_plate_of_king_dan_display_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_posterfont_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_preload_disable_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profession = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_qqcircle_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_sticky_note_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_c2c_call_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_c2c_last_guide_recharge_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_c2c_try_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_c2c_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_ever_c2c_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_ever_multi_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_multi_call_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_multi_last_guide_recharge_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_multi_try_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_pstn_multi_vip = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_font_effect_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_global_ring_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_invite2group_auto_agree_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_medalwall_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_push_notice_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rsp_connections_switch_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rsp_listen_together_player_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rsp_qq_level_icon_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_rsp_theme_font_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_school_status_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_simple_ui_pref = PBField.initUInt32(0);
  public final PBUInt32Field uint32_simple_ui_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_simple_update_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_stranger_vote_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subaccount_display_third_qq_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subscribe_nearbyassistant_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_suspend_effect_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torch_disable_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_torchbearer_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_troophonor_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_colorring_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_diy_font_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_emoticon_usage_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_face_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_font_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_magicfont_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_pendant_diy_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_praise_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vas_voicebubble_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_face_addon_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_game_appid = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_game_last_login_time = PBField.initUInt64(0L);
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
    ByteStringMicro localByteStringMicro17 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 34, 160018, 160026, 160034, 160072, 160112, 160120, 160162, 160176, 160216, 160242, 160250, 160258, 160264, 160272, 160280, 160296, 160328, 160448, 160472, 168010, 168018, 168024, 168032, 168050, 168058, 208034, 208042, 208080, 208088, 208096, 208104, 208112, 208120, 216176, 216200, 216210, 216274, 216282, 216288, 216296, 216328, 216416, 216472, 217608, 217664, 217736, 217792, 217800, 217872, 217880, 217888, 217904, 217920, 217928, 217952, 217960, 218032, 218056, 218960, 218984, 320392, 322592, 322768, 322784, 322800, 323680, 323816, 324000, 324048, 324056, 324064, 324072, 324200, 324240, 330248, 334048, 334264, 334272, 334432, 334440, 335600, 335784, 335944, 335992, 336024, 336040, 336048, 336056, 336064, 336088, 336096, 336192, 336408, 336584, 336600, 336736, 336832, 336968, 336976, 337336, 337376, 337632, 337840, 338040, 338088, 338272, 338280, 338296, 338384, 338544, 338552, 338600, 338608, 338656, 338672, 338744, 338848, 338888, 338880, 338896, 338904, 338912, 343840, 360000, 360264 }, new String[] { "uint64_uin", "bytes_openid", "bytes_nick", "bytes_country", "bytes_province", "uint32_gender", "uint32_allow", "uint32_face_id", "bytes_city", "uint32_constellation", "uint32_common_place1", "bytes_mss3_bitmapextra", "bytes_birthday", "bytes_city_id", "uint32_lang1", "uint32_lang2", "uint32_lang3", "uint32_age", "uint32_city_zone_id", "uint32_oin", "uint32_bubble_id", "bytes_mss2_identity", "bytes_mss1_service", "uint32_lflag", "uint32_ext_flag", "bytes_basic_svr_flag", "bytes_basic_cli_flag", "bytes_full_birthday", "bytes_full_age", "uint32_simple_update_time", "uint32_mss_update_time", "uint32_pstn_multi_call_time", "uint32_pstn_multi_last_guide_recharge_time", "uint32_pstn_c2c_call_time", "uint32_pstn_c2c_last_guide_recharge_time", "uint32_group_mem_credit_flag", "uint64_face_addon_id", "bytes_music_gene", "bytes_stranger_nick", "bytes_stranger_declare", "uint32_love_status", "uint32_profession", "uint32_vas_colorring_id", "uint32_charm", "uint32_apollo_timestamp", "uint32_vas_font_id", "uint32_global_group_level", "uint32_vas_praise_id", "uint64_game_last_login_time", "uint64_game_appid", "uint32_vas_voicebubble_id", "uint32_vas_pendant_diy_id", "uint32_suspend_effect_id", "uint32_vas_face_id", "uint32_do_not_disturb_mode_time", "uint32_vas_diy_font_timestamp", "uint32_vas_emoticon_usage_info", "uint32_dance_max_score", "uint32_req_font_effect_id", "uint32_posterfont_id", "uint32_req_global_ring_id", "uint32_rsp_theme_font_id", "roam_flag_qq_7day", "uint32_stranger_vote_switch", "uint32_req_invite2group_auto_agree_flag", "uint32_subaccount_display_third_qq_flag", "uint32_notify_partake_like_ranking_list_flag", "roam_flag_vip_30day", "roam_flag_svip_forever", "roam_flag_svip_2year", "uint32_lightalk_switch", "uint32_music_ring_visible", "uint32_music_ring_autoplay", "uint32_music_ring_redpoint", "uint32_torch_disable_flag", "uint32_vas_magicfont_flag", "uint32_flag_super_yellow_diamond", "uint32_vip_flag", "uint32_auth_flag", "uint32_forbid_flag", "uint32_god_forbid", "uint32_god_flag", "uint32_charm_level", "uint32_charm_shown", "uint32_freshnews_notify_flag", "uint32_apollo_vip_level", "uint32_apollo_vip_flag", "uint32_pstn_c2c_vip", "uint32_pstn_multi_vip", "uint32_pstn_ever_c2c_vip", "uint32_pstn_ever_multi_vip", "uint32_pstn_multi_try_flag", "uint32_pstn_c2c_try_flag", "uint32_subscribe_nearbyassistant_switch", "uint32_torchbearer_flag", "uint32_preload_disable_flag", "uint32_req_medalwall_flag", "uint32_notify_on_like_ranking_list_flag", "int32_history_num_flag", "uint32_plate_of_king_dan_display_switch", "uint32_plate_of_king_dan", "uint32_extend_friend_flag", "uint32_extend_friend_card_shown", "uint32_req_push_notice_flag", "uint32_cmshow_3d_flag", "roam_flag_svip_5year", "uint32_input_status_flag", "uint32_school_status_flag", "uint32_simple_ui_switch", "uint32_auto_to_text_flag", "uint32_simple_ui_pref", "uint32_hidden_session_switch", "uint32_hidden_session_video_switch", "uint32_flag_hide_pretty_group_owner_identity", "uint32_flag_is_pretty_group_owner", "uint32_rsp_connections_switch_id", "uint32_rsp_qq_level_icon_type", "uint32_flag_color_note_recent_switch", "uint32_profile_sticky_note_switch", "uint32_profile_qqcircle_switch", "uint32_troophonor_switch", "uint32_flag_study_mode_switch", "uint32_flag_school_verified", "uint32_flag_study_mode_student", "uint32_apollo_status", "uint32_bubble_unread_switch", "uint32_rsp_listen_together_player_id" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9, localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, localByteStringMicro13, localByteStringMicro14, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro15, localByteStringMicro16, localByteStringMicro17, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UdcUinData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData
 * JD-Core Version:    0.7.0.1
 */