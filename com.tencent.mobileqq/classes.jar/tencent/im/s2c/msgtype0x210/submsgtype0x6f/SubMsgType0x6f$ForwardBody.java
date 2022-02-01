package tencent.im.s2c.msgtype0x210.submsgtype0x6f;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0x6f$ForwardBody
  extends MessageMicro<ForwardBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public SubMsgType0x6f.RewardInfo msg_babyq_reward_info = new SubMsgType0x6f.RewardInfo();
  public SubMsgType0x6f.BirthdayReminderPush msg_birthday_reminder_push = new SubMsgType0x6f.BirthdayReminderPush();
  public SubMsgType0x6f.FanpaiziNotify msg_fanpanzi_notify = new SubMsgType0x6f.FanpaiziNotify();
  public SubMsgType0x6f.HotFriendNotify msg_hot_friend_notify = new SubMsgType0x6f.HotFriendNotify();
  public SubMsgType0x6f.MCardNotificationLike msg_mcard_notification_like = new SubMsgType0x6f.MCardNotificationLike();
  public SubMsgType0x6f.QimFriendNotify msg_mod_qim_friend = new SubMsgType0x6f.QimFriendNotify();
  public SubMsgType0x6f.QimFriendNotifyToQQ msg_mod_qim_friend_to_qq = new SubMsgType0x6f.QimFriendNotifyToQQ();
  public SubMsgType0x6f.PushLostDevFound msg_push_lost_dev = new SubMsgType0x6f.PushLostDevFound();
  public SubMsgType0x6f.PushLostDevFound msg_push_lost_dev_found = new SubMsgType0x6f.PushLostDevFound();
  public SubMsgType0x6f.QimRecomendMsg msg_push_qim_recommend = new SubMsgType0x6f.QimRecomendMsg();
  public SubMsgType0x6f.VipInfoNotify msg_vip_info_notify = new SubMsgType0x6f.VipInfoNotify();
  public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 16002, 16010, 16018, 16026, 16034, 16042, 16058, 16066, 16074, 16082, 16090 }, new String[] { "uint32_notify_type", "uint32_op_type", "msg_fanpanzi_notify", "msg_mcard_notification_like", "msg_vip_info_notify", "msg_push_lost_dev_found", "msg_birthday_reminder_push", "msg_push_lost_dev", "msg_babyq_reward_info", "msg_hot_friend_notify", "msg_push_qim_recommend", "msg_mod_qim_friend", "msg_mod_qim_friend_to_qq" }, new Object[] { localInteger, localInteger, null, null, null, null, null, null, null, null, null, null, null }, ForwardBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x6f.SubMsgType0x6f.ForwardBody
 * JD-Core Version:    0.7.0.1
 */