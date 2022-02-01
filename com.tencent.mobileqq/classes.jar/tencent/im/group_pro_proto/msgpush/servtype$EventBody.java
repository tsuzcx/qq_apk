package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class servtype$EventBody
  extends MessageMicro<EventBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 138, 146, 170, 178, 186, 194, 202 }, new String[] { "msg_read_notify", "msg_comm_gray_tips", "msg_create_guild", "msg_destroy_guild", "msg_join_guild", "msg_kick_off_guild", "msg_quit_guild", "msg_change_guild_info", "msg_create_chan", "msg_destroy_chan", "msg_change_chan_info", "msg_set_admin", "msg_set_msg_recv_type", "msg_update_msg", "msg_set_top", "msg_switch_channel", "msg_update_category", "msg_update_voice_block_list", "msg_set_mute", "msg_live_status_change_room", "msg_switch_live_room" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, EventBody.class);
  public servtype.ChangeChanInfo msg_change_chan_info = new servtype.ChangeChanInfo();
  public servtype.ChangeGuildInfo msg_change_guild_info = new servtype.ChangeGuildInfo();
  public servtype.CommGrayTips msg_comm_gray_tips = new servtype.CommGrayTips();
  public servtype.CreateChan msg_create_chan = new servtype.CreateChan();
  public servtype.CreateGuild msg_create_guild = new servtype.CreateGuild();
  public servtype.DestroyChan msg_destroy_chan = new servtype.DestroyChan();
  public servtype.DestroyGuild msg_destroy_guild = new servtype.DestroyGuild();
  public servtype.JoinGuild msg_join_guild = new servtype.JoinGuild();
  public servtype.KickOffGuild msg_kick_off_guild = new servtype.KickOffGuild();
  public servtype.LiveRoomStatusChangeMsg msg_live_status_change_room = new servtype.LiveRoomStatusChangeMsg();
  public servtype.QuitGuild msg_quit_guild = new servtype.QuitGuild();
  public servtype.ReadNotify msg_read_notify = new servtype.ReadNotify();
  public servtype.SetAdmin msg_set_admin = new servtype.SetAdmin();
  public servtype.SetMsgRecvType msg_set_msg_recv_type = new servtype.SetMsgRecvType();
  public servtype.SetMute msg_set_mute = new servtype.SetMute();
  public servtype.SetTop msg_set_top = new servtype.SetTop();
  public servtype.SwitchVoiceChannel msg_switch_channel = new servtype.SwitchVoiceChannel();
  public servtype.SwitchLiveRoom msg_switch_live_room = new servtype.SwitchLiveRoom();
  public servtype.UpdateCategory msg_update_category = new servtype.UpdateCategory();
  public servtype.UpdateMsg msg_update_msg = new servtype.UpdateMsg();
  public servtype.UpdateVoiceBlockList msg_update_voice_block_list = new servtype.UpdateVoiceBlockList();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.group_pro_proto.msgpush.servtype.EventBody
 * JD-Core Version:    0.7.0.1
 */