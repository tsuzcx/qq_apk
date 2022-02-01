package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class submsgtype0x44$MsgBody
  extends MessageMicro<MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 58, 66 }, new String[] { "msg_friend_msg_sync", "msg_group_msg_sync", "msg_clean_count_msg", "msg_modify_msg_sync", "msg_waiting_msg_sync", "msg_del_msg_notify", "msg_general_notify" }, new Object[] { null, null, null, null, null, null, null }, MsgBody.class);
  public submsgtype0x44.ClearCountMsg msg_clean_count_msg = new submsgtype0x44.ClearCountMsg();
  public submsgtype0x44.DelMsgNotify msg_del_msg_notify = new submsgtype0x44.DelMsgNotify();
  public submsgtype0x44.FriendSyncMsg msg_friend_msg_sync = new submsgtype0x44.FriendSyncMsg();
  public submsgtype0x44.GeneralNotify msg_general_notify = new submsgtype0x44.GeneralNotify();
  public submsgtype0x44.GroupSyncMsg msg_group_msg_sync = new submsgtype0x44.GroupSyncMsg();
  public submsgtype0x44.ModifySyncMsg msg_modify_msg_sync = new submsgtype0x44.ModifySyncMsg();
  public submsgtype0x44.WaitingSyncMsg msg_waiting_msg_sync = new submsgtype0x44.WaitingSyncMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0x44.submsgtype0x44.MsgBody
 * JD-Core Version:    0.7.0.1
 */