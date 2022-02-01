package tencent.im.group;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class group_member_info$MemberInfo
  extends MessageMicro<MemberInfo>
{
  public static final int CONCERN_TYPE_CONCERN = 1;
  public static final int CONCERN_TYPE_GENERAL = 0;
  public static final int CONCERN_TYPE_HATE = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBoolField bool_is_allow_mod_card = PBField.initBool(false);
  public final PBBoolField bool_is_concerned = PBField.initBool(false);
  public final PBBoolField bool_is_friend = PBField.initBool(false);
  public final PBBoolField bool_is_super_qq = PBField.initBool(false);
  public final PBBoolField bool_is_super_vip = PBField.initBool(false);
  public final PBBoolField bool_is_vip = PBField.initBool(false);
  public final PBBoolField bool_is_year_vip = PBField.initBool(false);
  public final PBBoolField bool_location_shared = PBField.initBool(false);
  public final PBBytesField bytes_group_honor = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_job = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_phone_num = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_special_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_id = PBField.initUInt32(0);
  public group_member_info.FlowersEntry msg_flower_entry = new group_member_info.FlowersEntry();
  public group_member_info.MemberGameInfo msg_game_info = new group_member_info.MemberGameInfo();
  public group_member_info.TeamEntry msg_team_entry = new group_member_info.TeamEntry();
  public group_member_info.RspGroupCardGetStory qqstory_infocard = new group_member_info.RspGroupCardGetStory();
  public final PBRepeatMessageField<group_member_info.CustomEntry> rpt_msg_custom_enties = PBField.initRepeatMessage(group_member_info.CustomEntry.class);
  public final PBRepeatMessageField<group_member_info.GBarInfo> rpt_msg_gbar_concerned = PBField.initRepeatMessage(group_member_info.GBarInfo.class);
  public final PBBytesField str_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_gbar_title = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_gbar_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_lev = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_location = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField str_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_age = PBField.initUInt32(0);
  public final PBUInt32Field uint32_concern_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_credit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_gbar_cnt = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_honor_bit = PBField.initUInt32(0);
  public final PBUInt32Field uint32_level = PBField.initUInt32(0);
  public final PBUInt32Field uint32_result = PBField.initUInt32(0);
  public final PBUInt32Field uint32_role = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sex = PBField.initUInt32(0);
  public final PBUInt32Field uint32_special_title_expire_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_vip_lev = PBField.initUInt32(0);
  public final PBUInt64Field uint64_distance = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_join = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_last_speak = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    Boolean localBoolean = Boolean.valueOf(false);
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 48, 56, 66, 72, 82, 90, 96, 106, 112, 120, 130, 138, 146, 154, 160, 168, 176, 184, 192, 200, 208, 216, 224, 232, 240, 250, 256, 266, 274, 282, 290, 296, 306, 312, 322, 330, 336 }, new String[] { "uint64_uin", "uint32_result", "str_errmsg", "bool_is_friend", "str_remark", "bool_is_concerned", "uint32_credit", "str_card", "uint32_sex", "str_location", "str_nick", "uint32_age", "str_lev", "uint64_join", "uint64_last_speak", "rpt_msg_custom_enties", "rpt_msg_gbar_concerned", "str_gbar_title", "str_gbar_url", "uint32_gbar_cnt", "bool_is_allow_mod_card", "bool_is_vip", "bool_is_year_vip", "bool_is_super_vip", "bool_is_super_qq", "uint32_vip_lev", "uint32_role", "bool_location_shared", "uint64_distance", "uint32_concern_type", "bytes_special_title", "uint32_special_title_expire_time", "msg_flower_entry", "msg_team_entry", "bytes_phone_num", "bytes_job", "medal_id", "qqstory_infocard", "uint32_level", "msg_game_info", "bytes_group_honor", "uint32_group_honor_bit" }, new Object[] { localLong, localInteger, localByteStringMicro1, localBoolean, localByteStringMicro2, localBoolean, localInteger, localByteStringMicro3, localInteger, localByteStringMicro4, localByteStringMicro5, localInteger, localByteStringMicro6, localLong, localLong, null, null, localByteStringMicro7, localByteStringMicro8, localInteger, localBoolean, localBoolean, localBoolean, localBoolean, localBoolean, localInteger, localInteger, localBoolean, localLong, localInteger, localByteStringMicro9, localInteger, null, null, localByteStringMicro10, localByteStringMicro11, localInteger, null, localInteger, null, localByteStringMicro12, localInteger }, MemberInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.group.group_member_info.MemberInfo
 * JD-Core Version:    0.7.0.1
 */