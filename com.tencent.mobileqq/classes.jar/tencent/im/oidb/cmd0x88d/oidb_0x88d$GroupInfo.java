package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x88d$GroupInfo
  extends MessageMicro<GroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_school_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_join_group_auth = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x88d.GroupGeoInfo group_geo_info = new oidb_0x88d.GroupGeoInfo();
  public oidb_0x88d.GroupHeadPortrait msg_head_portrait = new oidb_0x88d.GroupHeadPortrait();
  public final PBRepeatMessageField<oidb_0x88d.TagRecord> rpt_tag_record = PBField.initRepeatMessage(oidb_0x88d.TagRecord.class);
  public oidb_0x88d.GroupCardPrefix st_group_card_prefix = new oidb_0x88d.GroupCardPrefix();
  public oidb_0x88d.GroupExInfoOnly st_group_ex_info = new oidb_0x88d.GroupExInfoOnly();
  public final PBBytesField string_certification_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_aio_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_answer = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_board_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_class_text = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_cover_skin_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_question = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_group_rich_finger_memo = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_long_group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField string_poid_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_active_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_app_privilege_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_appeal_deadline = PBField.initUInt32(0);
  public final PBUInt32Field uint32_auto_agree_join_group_user_num_for_conf_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_auto_agree_join_group_user_num_for_normal_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_certification_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_flag_ex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_flag_ex2 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_history_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_join_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_join_real_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_join_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_last_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_new_mobile_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_privilege = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_read_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_ringtone_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmduin_uin_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conf_max_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_conf_to_group_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_create_source_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_admin_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_aio_skin_timestamp = PBField.initUInt32(0);
  public final PBRepeatField<Integer> uint32_group_alliance_code = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field uint32_group_board_skin_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_cover_skin_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_create_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_cur_msg_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_default_page = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_extra_adm_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flag_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext4 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_freeze_reason = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_info_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_last_msg_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_open_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_roaming_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_sec_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_sec_level_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_special_class = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_visitor_cur_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_visitor_max_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_head_portrait_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hl_guild_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hl_guild_orgid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hl_guild_sub_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_important_msg_latest_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_allow_conf_group_member_at_all = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_allow_conf_group_member_modify_group_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_allow_conf_group_member_nick = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_allow_hl_guild_binary = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_allow_recall_msg = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_conf_group = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_group_freeze = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_modify_conf_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_is_modify_conf_group_name = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level_name_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_member_list_change_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_membercard_seq = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_limit_frequency = PBField.initUInt32(0);
  public final PBUInt32Field uint32_no_code_finger_open_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_no_finger_open_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_password_redbag_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_timestamp = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_timestamp_me = PBField.initUInt32(0);
  public final PBUInt32Field uint32_team_seq = PBField.initUInt32(0);
  public final PBUInt64Field uint64_alliance_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_owner = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_history_msg_begin_time = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_invite_no_auth_num_limit = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_parent_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_root_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_subscription_uin = PBField.initUInt64(0L);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 122, 130, 138, 146, 152, 160, 168, 176, 184, 194, 202, 208, 216, 224, 232, 240, 248, 258, 266, 272, 282, 288, 296, 304, 314, 322, 330, 338, 344, 354, 360, 368, 376, 384, 392, 400, 408, 416, 424, 432, 440, 448, 458, 464, 472, 480, 490, 496, 504, 512, 520, 528, 536, 544, 552, 560, 568, 576, 584, 592, 600, 608, 616, 624, 632, 640, 648, 656, 664, 672, 680, 688, 696, 704, 714, 720, 728, 736, 746, 752, 760, 768, 776, 784, 792, 800, 808, 816, 826, 832, 842, 848 }, new String[] { "uint64_group_owner", "uint32_group_create_time", "uint32_group_flag", "uint32_group_flag_ext", "uint32_group_member_max_num", "uint32_group_member_num", "uint32_group_option", "uint32_group_class_ext", "uint32_group_special_class", "uint32_group_level", "uint32_group_face", "uint32_group_default_page", "uint32_group_info_seq", "uint32_group_roaming_time", "string_group_name", "string_group_memo", "string_group_finger_memo", "string_group_class_text", "uint32_group_alliance_code", "uint32_group_extra_adm_num", "uint64_group_uin", "uint32_group_cur_msg_seq", "uint32_group_last_msg_time", "string_group_question", "string_group_answer", "uint32_group_visitor_max_num", "uint32_group_visitor_cur_num", "uint32_level_name_seq", "uint32_group_admin_max_num", "uint32_group_aio_skin_timestamp", "uint32_group_board_skin_timestamp", "string_group_aio_skin_url", "string_group_board_skin_url", "uint32_group_cover_skin_timestamp", "string_group_cover_skin_url", "uint32_group_grade", "uint32_active_member_num", "uint32_certification_type", "string_certification_text", "string_group_rich_finger_memo", "rpt_tag_record", "group_geo_info", "uint32_head_portrait_seq", "msg_head_portrait", "uint32_shutup_timestamp", "uint32_shutup_timestamp_me", "uint32_create_source_flag", "uint32_cmduin_msg_seq", "uint32_cmduin_join_time", "uint32_cmduin_uin_flag", "uint32_cmduin_flag_ex", "uint32_cmduin_new_mobile_flag", "uint32_cmduin_read_msg_seq", "uint32_cmduin_last_msg_time", "uint32_group_type_flag", "uint32_app_privilege_flag", "st_group_ex_info", "uint32_group_sec_level", "uint32_group_sec_level_info", "uint32_cmduin_privilege", "string_poid_info", "uint32_cmduin_flag_ex2", "uint64_conf_uin", "uint32_conf_max_msg_seq", "uint32_conf_to_group_time", "uint32_password_redbag_time", "uint64_subscription_uin", "uint32_member_list_change_seq", "uint32_membercard_seq", "uint64_root_id", "uint64_parent_id", "uint32_team_seq", "uint64_history_msg_begin_time", "uint64_invite_no_auth_num_limit", "uint32_cmduin_history_msg_seq", "uint32_cmduin_join_msg_seq", "uint32_group_flagext3", "uint32_group_open_appid", "uint32_is_conf_group", "uint32_is_modify_conf_group_face", "uint32_is_modify_conf_group_name", "uint32_no_finger_open_flag", "uint32_no_code_finger_open_flag", "uint32_auto_agree_join_group_user_num_for_normal_group", "uint32_auto_agree_join_group_user_num_for_conf_group", "uint32_is_allow_conf_group_member_nick", "uint32_is_allow_conf_group_member_at_all", "uint32_is_allow_conf_group_member_modify_group_name", "string_long_group_name", "uint32_cmduin_join_real_msg_seq", "uint32_is_group_freeze", "uint32_msg_limit_frequency", "bytes_join_group_auth", "uint32_hl_guild_appid", "uint32_hl_guild_sub_type", "uint32_hl_guild_orgid", "uint32_is_allow_hl_guild_binary", "uint32_cmduin_ringtone_id", "uint32_group_flagext4", "uint32_group_freeze_reason", "uint32_is_allow_recall_msg", "uint32_important_msg_latest_seq", "bytes_group_school_info", "uint32_appeal_deadline", "st_group_card_prefix", "uint64_alliance_id" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, Integer.valueOf(0), localByteStringMicro9, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro10, localByteStringMicro11, null, null, Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro12, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro13, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro14, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro15, Integer.valueOf(0), null, Long.valueOf(0L) }, GroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo
 * JD-Core Version:    0.7.0.1
 */