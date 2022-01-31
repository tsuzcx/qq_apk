package tencent.im.oidb.cmd0x8f8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8f8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106 }, new String[] { "msg_source_id", "msg_add_feeds", "msg_add_cmmnt", "msg_add_face", "msg_del_feeds", "msg_del_cmmnt", "msg_set_feeds_flag", "msg_add_visit", "msg_attend_vote", "msg_del_apic", "msg_set_theme", "msg_set_async_state", "msg_del_litemail_index" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0x8f8.SubCmd02AddCmmntReq msg_add_cmmnt = new oidb_0x8f8.SubCmd02AddCmmntReq();
  public oidb_0x8f8.SubCmd04AddFaceReq msg_add_face = new oidb_0x8f8.SubCmd04AddFaceReq();
  public oidb_0x8f8.SubCmd01AddFeedsReq msg_add_feeds = new oidb_0x8f8.SubCmd01AddFeedsReq();
  public oidb_0x8f8.SubCmd09AddVisitReq msg_add_visit = new oidb_0x8f8.SubCmd09AddVisitReq();
  public oidb_0x8f8.SubCmd16AttendVoteReq msg_attend_vote = new oidb_0x8f8.SubCmd16AttendVoteReq();
  public oidb_0x8f8.SubCmd17DelAPicUrlReq msg_del_apic = new oidb_0x8f8.SubCmd17DelAPicUrlReq();
  public oidb_0x8f8.SubCmd06DelCmmntReq msg_del_cmmnt = new oidb_0x8f8.SubCmd06DelCmmntReq();
  public oidb_0x8f8.SubCmd05DelFeedsReq msg_del_feeds = new oidb_0x8f8.SubCmd05DelFeedsReq();
  public oidb_0x8f8.SubCmd20DelLiteMailIndexReq msg_del_litemail_index = new oidb_0x8f8.SubCmd20DelLiteMailIndexReq();
  public oidb_0x8f8.SubCmd19SetAsyncMsgStateReq msg_set_async_state = new oidb_0x8f8.SubCmd19SetAsyncMsgStateReq();
  public oidb_0x8f8.SubCmd07SetFeedsFlagReq msg_set_feeds_flag = new oidb_0x8f8.SubCmd07SetFeedsFlagReq();
  public oidb_0x8f8.SubCmd18SetThemeStateReq msg_set_theme = new oidb_0x8f8.SubCmd18SetThemeStateReq();
  public oidb_0x8f8.SourceID msg_source_id = new oidb_0x8f8.SourceID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f8.oidb_0x8f8.ReqBody
 * JD-Core Version:    0.7.0.1
 */