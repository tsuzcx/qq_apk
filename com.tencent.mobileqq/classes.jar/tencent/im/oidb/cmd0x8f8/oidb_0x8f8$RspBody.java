package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8f8$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114 }, new String[] { "msg_source_id", "msg_result", "msg_add_feeds_rsp", "msg_add_cmmnt_rsp", "msg_add_face_rsp", "msg_del_feeds_rsp", "msg_del_cmmnt_rsp", "msg_set_feeds_flag_rsp", "msg_add_visit_rsp", "msg_attend_vote_rsp", "msg_del_apic_rsp", "msg_set_theme_rsp", "msg_set_asyncmsg_state_rsp", "msg_del_litemail_index_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0x8f8.SubCmd02AddCmmntRsp msg_add_cmmnt_rsp = new oidb_0x8f8.SubCmd02AddCmmntRsp();
  public oidb_0x8f8.SubCmd04AddFaceRsp msg_add_face_rsp = new oidb_0x8f8.SubCmd04AddFaceRsp();
  public oidb_0x8f8.SubCmd01AddFeedsRsp msg_add_feeds_rsp = new oidb_0x8f8.SubCmd01AddFeedsRsp();
  public oidb_0x8f8.SubCmd09AddVisitRsp msg_add_visit_rsp = new oidb_0x8f8.SubCmd09AddVisitRsp();
  public oidb_0x8f8.SubCmd16AttendVoteRsp msg_attend_vote_rsp = new oidb_0x8f8.SubCmd16AttendVoteRsp();
  public oidb_0x8f8.SubCmd17DelAPicUrlRsp msg_del_apic_rsp = new oidb_0x8f8.SubCmd17DelAPicUrlRsp();
  public oidb_0x8f8.SubCmd06DelCmmntRsp msg_del_cmmnt_rsp = new oidb_0x8f8.SubCmd06DelCmmntRsp();
  public oidb_0x8f8.SubCmd05DelFeedsRsp msg_del_feeds_rsp = new oidb_0x8f8.SubCmd05DelFeedsRsp();
  public oidb_0x8f8.SubCmd20DelLiteMailIndexRsp msg_del_litemail_index_rsp = new oidb_0x8f8.SubCmd20DelLiteMailIndexRsp();
  public oidb_0x8f8.ResultMsg msg_result = new oidb_0x8f8.ResultMsg();
  public oidb_0x8f8.SubCmd19SetAsyncMsgStateRsp msg_set_asyncmsg_state_rsp = new oidb_0x8f8.SubCmd19SetAsyncMsgStateRsp();
  public oidb_0x8f8.SubCmd07SetFeedsFlagRsp msg_set_feeds_flag_rsp = new oidb_0x8f8.SubCmd07SetFeedsFlagRsp();
  public oidb_0x8f8.SubCmd18SetThemeStateRsp msg_set_theme_rsp = new oidb_0x8f8.SubCmd18SetThemeStateRsp();
  public oidb_0x8f8.SourceID msg_source_id = new oidb_0x8f8.SourceID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8.RspBody
 * JD-Core Version:    0.7.0.1
 */