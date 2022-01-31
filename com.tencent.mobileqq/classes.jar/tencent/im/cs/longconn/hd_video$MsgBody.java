package tencent.im.cs.longconn;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 82, 90 }, new String[] { "msg_video_head", "msg_invite_body", "msg_pstn_callback_notify_accept", "msg_pstn_callback_notify_logout" }, new Object[] { null, null, null, null }, MsgBody.class);
  public hd_video.CmdS2CInviteReqBody msg_invite_body = new hd_video.CmdS2CInviteReqBody();
  public hd_video.CmdPSTNCallbackNotifyAccept msg_pstn_callback_notify_accept = new hd_video.CmdPSTNCallbackNotifyAccept();
  public hd_video.CmdPSTNCallbackNotifyLogout msg_pstn_callback_notify_logout = new hd_video.CmdPSTNCallbackNotifyLogout();
  public hd_video.VideoHead msg_video_head = new hd_video.VideoHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.hd_video.MsgBody
 * JD-Core Version:    0.7.0.1
 */