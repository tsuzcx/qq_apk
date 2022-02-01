package tencent.im.oidb.cmd0x587;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x587$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<ByteStringMicro> rpt_bytes_openid = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBStringField str_nick = PBField.initString("");
  public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_birthday = PBField.initUInt32(0);
  public final PBUInt32Field uint32_c2c_aio_shortcut_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_extend_friend_card_shown = PBField.initUInt32(0);
  public final PBUInt32Field uint32_file_assist_top = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_profile_life_achievement_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_profile_weishi_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
  public final PBUInt32Field uint32_max_package_size = PBField.initUInt32(0);
  public final PBUInt32Field uint32_parent_allow_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_age_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_anonymous_answer_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_birthday_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_college_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_company_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_constellation_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_email_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_hometown_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_interest_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_location_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_miniapp_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_music_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_musicbox_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_personal_note_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_personality_label_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_present_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_profession_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_qqcircle_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_sex_visible = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_show_idol_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_sticky_note_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_profile_wz_game_card_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_qq_assistant_switch = PBField.initUInt32(0);
  public final PBUInt32Field uint32_req_medalwall_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_ueflag = PBField.initUInt32(0);
  public final PBUInt32Field user_login_guard_face = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 34, 40, 160018, 160072, 160248, 322176, 322504, 322512, 324328, 324336, 332856, 332872, 332880, 332888, 332904, 332912, 332944, 332952, 332976, 332984, 336600, 337024, 337376, 338312, 338584, 338664, 338720, 338848, 338888, 338936, 339016, 339336, 339352, 339400, 339904, 339912, 340040 }, new String[] { "rpt_uint64_uins", "uint32_max_package_size", "rpt_bytes_openid", "uint32_appid", "str_nick", "uint32_gender", "uint32_birthday", "uint32_profile_company_visible", "uint32_profile_interest_switch", "uint32_profile_music_switch", "uint32_ueflag", "uint32_parent_allow_flag", "uint32_profile_birthday_visible", "uint32_profile_constellation_visible", "uint32_profile_age_visible", "uint32_profile_sex_visible", "uint32_profile_hometown_visible", "uint32_profile_location_visible", "uint32_profile_profession_visible", "uint32_profile_college_visible", "uint32_profile_email_visible", "uint32_profile_personal_note_visible", "uint32_req_medalwall_flag", "uint32_profile_personality_label_switch", "uint32_extend_friend_card_shown", "uint32_profile_present_switch", "uint32_profile_miniapp_switch", "user_login_guard_face", "uint32_profile_musicbox_switch", "uint32_profile_sticky_note_switch", "uint32_profile_qqcircle_switch", "uint32_flag_profile_life_achievement_switch", "uint32_flag_profile_weishi_switch", "uint32_c2c_aio_shortcut_switch", "uint32_qq_assistant_switch", "uint32_profile_anonymous_answer_switch", "uint32_profile_show_idol_switch", "uint32_file_assist_top", "uint32_profile_wz_game_card_switch" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), "", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x587.oidb_0x587.ReqBody
 * JD-Core Version:    0.7.0.1
 */