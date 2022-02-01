package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8f9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40, 48, 56, 66, 74, 82 }, new String[] { "msg_source_id", "msg_result_msg", "rpt_feeds_recored", "rpt_feeds_comments", "uint32_last_modify_time", "uint32_feeds_rsp_flag", "uint32_unread_num", "msg_litemail_list", "msg_set_all_litemail_readed_by_endtime", "msg_rsp_get_latest_node_info" }, new Object[] { null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null }, RspBody.class);
  public oidb_0x8f9.GetLiteMailListByUinRsp msg_litemail_list = new oidb_0x8f9.GetLiteMailListByUinRsp();
  public oidb_0x8f9.ResultMsg msg_result_msg = new oidb_0x8f9.ResultMsg();
  public oidb_0x8f9.GetLatestNodeInfoRsp msg_rsp_get_latest_node_info = new oidb_0x8f9.GetLatestNodeInfoRsp();
  public oidb_0x8f9.SetAllLiteMailReadedByEndTimeRsp msg_set_all_litemail_readed_by_endtime = new oidb_0x8f9.SetAllLiteMailReadedByEndTimeRsp();
  public oidb_0x8f9.SourceID msg_source_id = new oidb_0x8f9.SourceID();
  public final PBRepeatMessageField<oidb_0x8f9.GroupFeedsCommentRecord> rpt_feeds_comments = PBField.initRepeatMessage(oidb_0x8f9.GroupFeedsCommentRecord.class);
  public final PBRepeatMessageField<oidb_0x8f9.GroupFeedsRecord> rpt_feeds_recored = PBField.initRepeatMessage(oidb_0x8f9.GroupFeedsRecord.class);
  public final PBUInt32Field uint32_feeds_rsp_flag = PBField.initUInt32(0);
  public final PBUInt32Field uint32_last_modify_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_unread_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f9.oidb_0x8f9.RspBody
 * JD-Core Version:    0.7.0.1
 */