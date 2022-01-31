package tencent.im.oidb.cmd0x857;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.apollo_game_status.STCMGameMessage;
import tencent.im.apollo_push_msgInfo.STPushMsgElem;

public final class TroopTips0x857$NotifyMsgBody
  extends MessageMicro<NotifyMsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 58, 66, 74, 82, 90, 98, 104, 114, 122, 130, 138, 146, 162, 168, 178, 186, 194, 210, 218, 226, 234, 242, 250 }, new String[] { "opt_enum_type", "opt_uint64_msg_time", "opt_uint64_msg_expires", "opt_uint64_group_code", "opt_msg_graytips", "opt_msg_messagebox", "opt_msg_floatedtips", "opt_msg_toptips", "opt_msg_redtips", "opt_msg_group_notify", "opt_msg_recall", "opt_msg_theme_notify", "uint32_service_type", "opt_msg_objmsg_update", "opt_msg_werewolf_push", "opt_stcm_game_state", "apllo_msg_push", "opt_msg_goldtips", "opt_msg_miniapp_notify", "opt_uint64_sender_uin", "opt_msg_luckybag_notify", "opt_msg_troopformtips_push", "opt_msg_media_push", "opt_general_gray_tip", "opt_msg_video_push", "opt_lbs_share_change_plus_info", "opt_msg_sing_push", "opt_msg_group_info_change", "opt_group_announce_tbc_info" }, new Object[] { Integer.valueOf(1), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), null, null, null, null, null, null, null, null, Integer.valueOf(0), null, null, null, null, null, null, Long.valueOf(0L), null, null, null, null, null, null, null, null, null }, NotifyMsgBody.class);
  public apollo_push_msgInfo.STPushMsgElem apllo_msg_push = new apollo_push_msgInfo.STPushMsgElem();
  public final PBEnumField opt_enum_type = PBField.initEnum(1);
  public TroopTips0x857.GeneralGrayTipInfo opt_general_gray_tip = new TroopTips0x857.GeneralGrayTipInfo();
  public TroopTips0x857.GroupAnnounceTBCInfo opt_group_announce_tbc_info = new TroopTips0x857.GroupAnnounceTBCInfo();
  public TroopTips0x857.LbsShareChangePushInfo opt_lbs_share_change_plus_info = new TroopTips0x857.LbsShareChangePushInfo();
  public TroopTips0x857.FloatedTipsInfo opt_msg_floatedtips = new TroopTips0x857.FloatedTipsInfo();
  public TroopTips0x857.GoldMsgTipsElem opt_msg_goldtips = new TroopTips0x857.GoldMsgTipsElem();
  public TroopTips0x857.AIOGrayTipsInfo opt_msg_graytips = new TroopTips0x857.AIOGrayTipsInfo();
  public TroopTips0x857.GroupInfoChange opt_msg_group_info_change = new TroopTips0x857.GroupInfoChange();
  public TroopTips0x857.GroupNotifyInfo opt_msg_group_notify = new TroopTips0x857.GroupNotifyInfo();
  public TroopTips0x857.LuckyBagNotify opt_msg_luckybag_notify = new TroopTips0x857.LuckyBagNotify();
  public TroopTips0x857.MediaChangePushInfo opt_msg_media_push = new TroopTips0x857.MediaChangePushInfo();
  public TroopTips0x857.MessageBoxInfo opt_msg_messagebox = new TroopTips0x857.MessageBoxInfo();
  public TroopTips0x857.MiniAppNotify opt_msg_miniapp_notify = new TroopTips0x857.MiniAppNotify();
  public TroopTips0x857.NotifyObjmsgUpdate opt_msg_objmsg_update = new TroopTips0x857.NotifyObjmsgUpdate();
  public TroopTips0x857.MessageRecallReminder opt_msg_recall = new TroopTips0x857.MessageRecallReminder();
  public TroopTips0x857.RedGrayTipsInfo opt_msg_redtips = new TroopTips0x857.RedGrayTipsInfo();
  public TroopTips0x857.SingChangePushInfo opt_msg_sing_push = new TroopTips0x857.SingChangePushInfo();
  public TroopTips0x857.ThemeStateNotify opt_msg_theme_notify = new TroopTips0x857.ThemeStateNotify();
  public TroopTips0x857.AIOTopTipsInfo opt_msg_toptips = new TroopTips0x857.AIOTopTipsInfo();
  public TroopTips0x857.TroopFormGrayTipsInfo opt_msg_troopformtips_push = new TroopTips0x857.TroopFormGrayTipsInfo();
  public TroopTips0x857.VideoChangePushInfo opt_msg_video_push = new TroopTips0x857.VideoChangePushInfo();
  public TroopTips0x857.WereWolfPush opt_msg_werewolf_push = new TroopTips0x857.WereWolfPush();
  public apollo_game_status.STCMGameMessage opt_stcm_game_state = new apollo_game_status.STCMGameMessage();
  public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_expires = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_msg_time = PBField.initUInt64(0L);
  public final PBUInt64Field opt_uint64_sender_uin = PBField.initUInt64(0L);
  public final PBUInt32Field uint32_service_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x857.TroopTips0x857.NotifyMsgBody
 * JD-Core Version:    0.7.0.1
 */