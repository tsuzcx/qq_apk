package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x8f9$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "msg_source_id", "msg_req_by_top", "msg_req_by_time", "msg_req_by_id", "msg_req_comment_by_top", "msg_req_by_type", "msg_req_get_theme_list", "msg_req_themecont_by_top", "msg_req_async_feeds", "msg_req_get_litemail_list_by_uin", "msg_set_all_litemail_readed_by_endtime", "msg_req_get_latest_node_info" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0x8f9.GetAsyncMsgFeedsReq msg_req_async_feeds = new oidb_0x8f9.GetAsyncMsgFeedsReq();
  public oidb_0x8f9.GetFeedsByIDReq msg_req_by_id = new oidb_0x8f9.GetFeedsByIDReq();
  public oidb_0x8f9.GetFeedsByTimeReq msg_req_by_time = new oidb_0x8f9.GetFeedsByTimeReq();
  public oidb_0x8f9.GetFeedsByTopReq msg_req_by_top = new oidb_0x8f9.GetFeedsByTopReq();
  public oidb_0x8f9.GetFeedsByTypeReq msg_req_by_type = new oidb_0x8f9.GetFeedsByTypeReq();
  public oidb_0x8f9.GetCommentsByTopReq msg_req_comment_by_top = new oidb_0x8f9.GetCommentsByTopReq();
  public oidb_0x8f9.GetLatestNodeInfoReq msg_req_get_latest_node_info = new oidb_0x8f9.GetLatestNodeInfoReq();
  public oidb_0x8f9.GetLiteMailListByUinReq msg_req_get_litemail_list_by_uin = new oidb_0x8f9.GetLiteMailListByUinReq();
  public oidb_0x8f9.GetFeedsByTopReq msg_req_get_theme_list = new oidb_0x8f9.GetFeedsByTopReq();
  public oidb_0x8f9.GetCommentsByTopReq msg_req_themecont_by_top = new oidb_0x8f9.GetCommentsByTopReq();
  public oidb_0x8f9.SetAllLiteMailReadedByEndTimeReq msg_set_all_litemail_readed_by_endtime = new oidb_0x8f9.SetAllLiteMailReadedByEndTimeReq();
  public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.ReqBody
 * JD-Core Version:    0.7.0.1
 */