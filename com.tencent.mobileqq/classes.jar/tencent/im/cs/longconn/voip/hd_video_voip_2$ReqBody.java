package tencent.im.cs.longconn.voip;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class hd_video_voip_2$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 410 }, new String[] { "msg_voip_head", "msg_phone_bind_req_body", "msg_phone_callback_req_body", "msg_phone_cancel_callback_req_body", "msg_phone_speed_test_req_body", "msg_phone_multi_chat_create_req_body", "msg_phone_multi_chat_invite_req_body", "msg_phone_multi_chat_query_req_body", "msg_phone_multi_chat_kick_req_body", "msg_phone_multi_chat_cancel_req_body", "msg_phone_h5_check_req_body", "msg_bm", "msg_get_call_type_req_body" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public hd_video_voip_2.BalanceAccount msg_bm = new hd_video_voip_2.BalanceAccount();
  public hd_video_voip_2.CmdGetCallTypeReqBody msg_get_call_type_req_body = new hd_video_voip_2.CmdGetCallTypeReqBody();
  public hd_video_voip_2.CmdPhoneBindReqBody msg_phone_bind_req_body = new hd_video_voip_2.CmdPhoneBindReqBody();
  public hd_video_voip_2.CmdPhoneCallBackReqBody msg_phone_callback_req_body = new hd_video_voip_2.CmdPhoneCallBackReqBody();
  public hd_video_voip_2.CmdPhoneCancelCallBackReqBody msg_phone_cancel_callback_req_body = new hd_video_voip_2.CmdPhoneCancelCallBackReqBody();
  public hd_video_voip_2.PhoneH5CheckReqBody msg_phone_h5_check_req_body = new hd_video_voip_2.PhoneH5CheckReqBody();
  public hd_video_voip_2.CmdPhoneMultiChatCancelReqBody msg_phone_multi_chat_cancel_req_body = new hd_video_voip_2.CmdPhoneMultiChatCancelReqBody();
  public hd_video_voip_2.CmdPhoneMultiChatCreateReqBody msg_phone_multi_chat_create_req_body = new hd_video_voip_2.CmdPhoneMultiChatCreateReqBody();
  public hd_video_voip_2.CmdPhoneMultiChatInviteReqBody msg_phone_multi_chat_invite_req_body = new hd_video_voip_2.CmdPhoneMultiChatInviteReqBody();
  public hd_video_voip_2.CmdPhoneMultiChatKickReqBody msg_phone_multi_chat_kick_req_body = new hd_video_voip_2.CmdPhoneMultiChatKickReqBody();
  public hd_video_voip_2.CmdPhoneMultiChatQueryReqBody msg_phone_multi_chat_query_req_body = new hd_video_voip_2.CmdPhoneMultiChatQueryReqBody();
  public hd_video_voip_2.CmdPhoneSpeedTestReq msg_phone_speed_test_req_body = new hd_video_voip_2.CmdPhoneSpeedTestReq();
  public hd_video_voip_2.VoipHead msg_voip_head = new hd_video_voip_2.VoipHead();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.longconn.voip.hd_video_voip_2.ReqBody
 * JD-Core Version:    0.7.0.1
 */