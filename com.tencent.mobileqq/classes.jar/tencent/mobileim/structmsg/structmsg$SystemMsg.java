package tencent.mobileim.structmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class structmsg$SystemMsg
  extends MessageMicro<SystemMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field action_uin = PBField.initUInt64(0L);
  public final PBStringField action_uin_nick = PBField.initString("");
  public final PBBytesField action_uin_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField action_uin_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<structmsg.SystemMsgAction> actions = PBField.initRepeatMessage(structmsg.SystemMsgAction.class);
  public final PBUInt64Field actor_uin = PBField.initUInt64(0L);
  public final PBStringField actor_uin_nick = PBField.initString("");
  public final PBBytesField bytes_game_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_game_nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_name_more = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_transparent_group_notify = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_warning_tips = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field card_switch = PBField.initUInt32(0);
  public final PBUInt64Field clone_uin = PBField.initUInt64(0L);
  public final PBStringField clone_uin_nick = PBField.initString("");
  public final PBBytesField eim_group_id_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public structmsg.FriendInfo friend_info = new structmsg.FriendInfo();
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBUInt32Field group_ext_flag = PBField.initUInt32(0);
  public structmsg.GroupInfo group_info = new structmsg.GroupInfo();
  public final PBUInt32Field group_inviter_role = PBField.initUInt32(0);
  public final PBUInt32Field group_msg_type = PBField.initUInt32(0);
  public final PBStringField group_name = PBField.initString("");
  public final PBStringField msg_actor_describe = PBField.initString("");
  public final PBStringField msg_additional = PBField.initString("");
  public final PBStringField msg_additional_list = PBField.initString("");
  public final PBStringField msg_decided = PBField.initString("");
  public final PBStringField msg_describe = PBField.initString("");
  public final PBStringField msg_detail = PBField.initString("");
  public structmsg.MsgInviteExt msg_invite_extinfo = new structmsg.MsgInviteExt();
  public structmsg.MsgPayGroupExt msg_pay_group_extinfo = new structmsg.MsgPayGroupExt();
  public final PBStringField msg_qna = PBField.initString("");
  public final PBStringField msg_source = PBField.initString("");
  public final PBStringField msg_title = PBField.initString("");
  public final PBBytesField pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field relation = PBField.initUInt32(0);
  public final PBUInt32Field req_uin_age = PBField.initUInt32(0);
  public final PBBytesField req_uin_business_card = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field req_uin_faceid = PBField.initInt32(0);
  public final PBUInt32Field req_uin_gender = PBField.initUInt32(0);
  public final PBStringField req_uin_nick = PBField.initString("");
  public final PBBytesField req_uin_pre_remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field reqsubtype = PBField.initUInt32(0);
  public final PBUInt32Field src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_src_id = PBField.initUInt32(0);
  public final PBUInt32Field sub_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_c2c_invite_join_group_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_doubt_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_group_flagext3 = PBField.initUInt32(0);
  public final PBUInt32Field uint32_source_flag = PBField.initUInt32(0);
  public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_eim_group_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_group_owner_uin = PBField.initUInt64(0L);
  
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
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 56, 64, 74, 80, 88, 96, 104, 114, 122, 128, 138, 146, 152, 160, 168, 176, 184, 194, 202, 208, 218, 226, 232, 240, 248, 258, 266, 282, 400, 410, 418, 426, 434, 442, 456, 466, 474, 482, 490, 506, 514, 522, 530, 536, 544, 552, 808 }, new String[] { "sub_type", "msg_title", "msg_describe", "msg_additional", "msg_source", "msg_decided", "src_id", "sub_src_id", "actions", "group_code", "action_uin", "group_msg_type", "group_inviter_role", "friend_info", "group_info", "actor_uin", "msg_actor_describe", "msg_additional_list", "relation", "reqsubtype", "clone_uin", "uint64_discuss_uin", "uint64_eim_group_id", "msg_invite_extinfo", "msg_pay_group_extinfo", "uint32_source_flag", "bytes_game_nick", "bytes_game_msg", "uint32_group_flagext3", "uint64_group_owner_uin", "uint32_doubt_flag", "bytes_warning_tips", "bytes_name_more", "bytes_transparent_group_notify", "req_uin_faceid", "req_uin_nick", "group_name", "action_uin_nick", "msg_qna", "msg_detail", "group_ext_flag", "actor_uin_nick", "pic_url", "clone_uin_nick", "req_uin_business_card", "eim_group_id_name", "req_uin_pre_remark", "action_uin_qq_nick", "action_uin_remark", "req_uin_gender", "req_uin_age", "uint32_c2c_invite_join_group_flag", "card_switch" }, new Object[] { Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), null, null, Long.valueOf(0L), "", "", Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), "", "", "", "", "", Integer.valueOf(0), "", localByteStringMicro6, "", localByteStringMicro7, localByteStringMicro8, localByteStringMicro9, localByteStringMicro10, localByteStringMicro11, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, SystemMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.mobileim.structmsg.structmsg.SystemMsg
 * JD-Core Version:    0.7.0.1
 */