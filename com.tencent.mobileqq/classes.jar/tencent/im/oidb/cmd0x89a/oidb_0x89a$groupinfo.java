package tencent.im.oidb.cmd0x89a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0x89a$groupinfo
  extends MessageMicro<groupinfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_group_school_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_0x89a.GroupGeoInfo msg_group_geo_info = new oidb_0x89a.GroupGeoInfo();
  public final PBRepeatField<ByteStringMicro> rpt_string_group_tag = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public oidb_0x89a.GroupCardPrefix st_group_card_prefix = new oidb_0x89a.GroupCardPrefix();
  public oidb_0x89a.GroupExInfoOnly st_group_ex_info = new oidb_0x89a.GroupExInfoOnly();
  public oidb_0x89a.GroupNewGuidelinesInfo st_group_newguidelines = new oidb_0x89a.GroupNewGuidelinesInfo();
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
  public final PBUInt32Field uint32_active_member_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_add_option = PBField.initUInt32(0);
  public final PBUInt32Field uint32_allow_member_invite = PBField.initUInt32(0);
  public final PBUInt32Field uint32_app_privilege_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_app_privilege_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_certification_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_class_ext = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_ext_adm_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_face = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext3_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext4 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext4_mask = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_grade = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_open_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_sec_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_sec_level_info = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_type_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hl_guild_appid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hl_guild_orgid = PBField.initUInt32(0);
  public final PBUInt32Field uint32_hl_guild_sub_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_msg_limit_frequency = PBField.initUInt32(0);
  public final PBUInt32Field uint32_no_code_finger_open_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_no_finger_open_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_shutup_time = PBField.initUInt32(0);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 72, 80, 88, 98, 106, 114, 120, 128, 136, 144, 154, 162, 168, 178, 184, 192, 202, 208, 216, 224, 232, 242, 250, 256, 264, 272, 280, 288, 296, 304, 312, 320, 328, 336, 344, 354, 362 }, new String[] { "uint32_group_ext_adm_num", "uint32_flag", "string_group_name", "string_group_memo", "string_group_finger_memo", "string_group_aio_skin_url", "string_group_board_skin_url", "string_group_cover_skin_url", "uint32_group_grade", "uint32_active_member_num", "uint32_certification_type", "string_certification_text", "string_group_rich_finger_memo", "st_group_newguidelines", "uint32_group_face", "uint32_add_option", "uint32_shutup_time", "uint32_group_type_flag", "rpt_string_group_tag", "msg_group_geo_info", "uint32_group_class_ext", "string_group_class_text", "uint32_app_privilege_flag", "uint32_app_privilege_mask", "st_group_ex_info", "uint32_group_sec_level", "uint32_group_sec_level_info", "uint64_subscription_uin", "uint32_allow_member_invite", "string_group_question", "string_group_answer", "uint32_group_flagext3", "uint32_group_flagext3_mask", "uint32_group_open_appid", "uint32_no_finger_open_flag", "uint32_no_code_finger_open_flag", "uint64_root_id", "uint32_msg_limit_frequency", "uint32_hl_guild_appid", "uint32_hl_guild_sub_type", "uint32_hl_guild_orgid", "uint32_group_flagext4", "uint32_group_flagext4_mask", "bytes_group_school_info", "st_group_card_prefix" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, localByteStringMicro6, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro7, localByteStringMicro8, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro9, null, Integer.valueOf(0), localByteStringMicro10, Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro11, localByteStringMicro12, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro13, null }, groupinfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x89a.oidb_0x89a.groupinfo
 * JD-Core Version:    0.7.0.1
 */