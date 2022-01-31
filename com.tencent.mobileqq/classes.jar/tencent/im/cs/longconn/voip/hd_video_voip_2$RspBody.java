package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video_voip_2$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 418 }, new String[] { "msg_voip_head", "msg_failed_body", "msg_phone_bind_rsp_body", "msg_phone_callback_rsp_body", "msg_phone_cancel_callback_rsp_body", "msg_phone_speed_test_rsp_body", "msg_phone_multi_chat_create_rsp_body", "msg_phone_multi_chat_invite_rsp_body", "msg_phone_multi_chat_query_rsp_body", "msg_phone_multi_chat_kick_rsp_body", "msg_phone_multi_chat_cancel_rsp_body", "msg_phone_h5_check_rsp_body", "msg_get_call_type_rsp_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public hd_video_voip_2.CmdFailedRspBody msg_failed_body = new hd_video_voip_2.CmdFailedRspBody();
  public hd_video_voip_2.CmdGetCallTypeRspBody msg_get_call_type_rsp_body = new hd_video_voip_2.CmdGetCallTypeRspBody();
  public hd_video_voip_2.CmdPhoneBindRspBody msg_phone_bind_rsp_body = new hd_video_voip_2.CmdPhoneBindRspBody();
  public hd_video_voip_2.CmdPhoneCallBackRspBody msg_phone_callback_rsp_body = new hd_video_voip_2.CmdPhoneCallBackRspBody();
  public hd_video_voip_2.CmdPhoneCancelCallBackRspBody msg_phone_cancel_callback_rsp_body = new hd_video_voip_2.CmdPhoneCancelCallBackRspBody();
  public hd_video_voip_2.PhoneH5CheckRspBody msg_phone_h5_check_rsp_body = new hd_video_voip_2.PhoneH5CheckRspBody();
  public hd_video_voip_2.CmdPhoneMultiChatCancelRspBody msg_phone_multi_chat_cancel_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatCancelRspBody();
  public hd_video_voip_2.CmdPhoneMultiChatCreateRspBody msg_phone_multi_chat_create_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatCreateRspBody();
  public hd_video_voip_2.CmdPhoneMultiChatInviteRspBody msg_phone_multi_chat_invite_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatInviteRspBody();
  public hd_video_voip_2.CmdPhoneMultiChatKickRspBody msg_phone_multi_chat_kick_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatKickRspBody();
  public hd_video_voip_2.CmdPhoneMultiChatQueryRspBody msg_phone_multi_chat_query_rsp_body = new hd_video_voip_2.CmdPhoneMultiChatQueryRspBody();
  public hd_video_voip_2.CmdPhoneSpeedTestRsp msg_phone_speed_test_rsp_body = new hd_video_voip_2.CmdPhoneSpeedTestRsp();
  public hd_video_voip_2.VoipHead msg_voip_head = new hd_video_voip_2.VoipHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.RspBody
 * JD-Core Version:    0.7.0.1
 */