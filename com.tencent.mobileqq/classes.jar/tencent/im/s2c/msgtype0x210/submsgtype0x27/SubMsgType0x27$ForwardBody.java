package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x27$ForwardBody
  extends MessageMicro<ForwardBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_redpoint_info = PBField.initBytes(ByteStringMicro.EMPTY);
  public SubMsgType0x27.AddGroup msg_add_group = new SubMsgType0x27.AddGroup();
  public SubMsgType0x27.AppointmentNotify msg_appointment_notify = new SubMsgType0x27.AppointmentNotify();
  public SubMsgType0x27.BinaryMsg msg_bin_pkg = new SubMsgType0x27.BinaryMsg();
  public SubMsgType0x27.MQQCampusNotify msg_campus_notify = new SubMsgType0x27.MQQCampusNotify();
  public SubMsgType0x27.ChatMatchInfo msg_chat_match_info = new SubMsgType0x27.ChatMatchInfo();
  public SubMsgType0x27.ConfMsgRoamFlag msg_conf_msg_roam_flag = new SubMsgType0x27.ConfMsgRoamFlag();
  public SubMsgType0x27.DaRenNotify msg_daren_notify = new SubMsgType0x27.DaRenNotify();
  public SubMsgType0x27.DelFriend msg_del_friend = new SubMsgType0x27.DelFriend();
  public SubMsgType0x27.DelGroup msg_del_group = new SubMsgType0x27.DelGroup();
  public SubMsgType0x27.FanpaiziNotify msg_fanpanzi_notify = new SubMsgType0x27.FanpaiziNotify();
  public SubMsgType0x27.FrdCustomOnlineStatusChange msg_frd_custom_online_status_change = new SubMsgType0x27.FrdCustomOnlineStatusChange();
  public SubMsgType0x27.GrpMsgRoamFlag msg_grp_msg_roam_flag = new SubMsgType0x27.GrpMsgRoamFlag();
  public SubMsgType0x27.HotFriendNotify msg_hot_friend_notify = new SubMsgType0x27.HotFriendNotify();
  public SubMsgType0x27.ModConfProfile msg_mod_conf_profile = new SubMsgType0x27.ModConfProfile();
  public SubMsgType0x27.ModCustomFace msg_mod_custom_face = new SubMsgType0x27.ModCustomFace();
  public SubMsgType0x27.SnsUpdateFlag msg_mod_friend_flag = new SubMsgType0x27.SnsUpdateFlag();
  public SubMsgType0x27.ModFriendGroup msg_mod_friend_group = new SubMsgType0x27.ModFriendGroup();
  public SubMsgType0x27.ModFriendRemark msg_mod_friend_remark = new SubMsgType0x27.ModFriendRemark();
  public SubMsgType0x27.ModSnsGeneralInfo msg_mod_friend_rings = new SubMsgType0x27.ModSnsGeneralInfo();
  public SubMsgType0x27.ModGroupMemberProfile msg_mod_group_member_profile = new SubMsgType0x27.ModGroupMemberProfile();
  public SubMsgType0x27.ModGroupName msg_mod_group_name = new SubMsgType0x27.ModGroupName();
  public SubMsgType0x27.ModGroupProfile msg_mod_group_profile = new SubMsgType0x27.ModGroupProfile();
  public SubMsgType0x27.ModGroupSort msg_mod_group_sort = new SubMsgType0x27.ModGroupSort();
  public SubMsgType0x27.ModLongNick msg_mod_long_nick = new SubMsgType0x27.ModLongNick();
  public SubMsgType0x27.ModProfile msg_mod_profile = new SubMsgType0x27.ModProfile();
  public SubMsgType0x27.ModLongNick msg_mod_rich_long_nick = new SubMsgType0x27.ModLongNick();
  public SubMsgType0x27.ModLongNick msg_mod_rich_long_nick_ex = new SubMsgType0x27.ModLongNick();
  public SubMsgType0x27.NewComeinUserNotify msg_new_comein_user_notify = new SubMsgType0x27.NewComeinUserNotify();
  public SubMsgType0x27.PraiseRankNotify msg_praise_rank_notify = new SubMsgType0x27.PraiseRankNotify();
  public SubMsgType0x27.PushReportDev msg_push_report_dev = new SubMsgType0x27.PushReportDev();
  public SubMsgType0x27.PushSearchDev msg_push_search_dev = new SubMsgType0x27.PushSearchDev();
  public SubMsgType0x27.QQPayPush msg_qq_pay_push = new SubMsgType0x27.QQPayPush();
  public SubMsgType0x27.ModFrdRoamPriv msg_roam_priv = new SubMsgType0x27.ModFrdRoamPriv();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 202, 210, 1602, 1610, 1618, 1626, 1634, 1642, 1682, 1690, 1698, 1714, 16002 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_add_group", "msg_del_group", "msg_mod_group_name", "msg_mod_group_sort", "msg_mod_friend_group", "msg_mod_profile", "msg_mod_friend_remark", "msg_mod_long_nick", "msg_mod_custom_face", "msg_mod_group_profile", "msg_mod_group_member_profile", "msg_del_friend", "msg_roam_priv", "msg_grp_msg_roam_flag", "msg_conf_msg_roam_flag", "msg_mod_rich_long_nick", "msg_bin_pkg", "msg_mod_friend_rings", "msg_mod_conf_profile", "msg_mod_friend_flag", "msg_appointment_notify", "msg_daren_notify", "msg_new_comein_user_notify", "msg_push_search_dev", "msg_push_report_dev", "msg_qq_pay_push", "bytes_redpoint_info", "msg_hot_friend_notify", "msg_praise_rank_notify", "msg_campus_notify", "msg_mod_rich_long_nick_ex", "msg_chat_match_info", "msg_frd_custom_online_status_change", "msg_fanpanzi_notify" }, new Object[] { localInteger, localInteger, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, localByteStringMicro, null, null, null, null, null, null, null }, ForwardBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x27.SubMsgType0x27.ForwardBody
 * JD-Core Version:    0.7.0.1
 */