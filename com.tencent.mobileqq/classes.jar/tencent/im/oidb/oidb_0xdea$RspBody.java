package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xdea$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "add_barrage_rsp", "get_barrage_list_rsp", "rpt_recall_barrage_rsp_list", "rpt_delete_barrage_rsp_list", "get_topic_rsp", "get_comment_rsp" }, new Object[] { null, null, null, null, null, null }, RspBody.class);
  public oidb_0xdea.AddBarrageRspBody add_barrage_rsp = new oidb_0xdea.AddBarrageRspBody();
  public oidb_0xdea.GetBarrageListRspBody get_barrage_list_rsp = new oidb_0xdea.GetBarrageListRspBody();
  public oidb_0xdea.GetCommentRspBody get_comment_rsp = new oidb_0xdea.GetCommentRspBody();
  public oidb_0xdea.GetTopicRspBody get_topic_rsp = new oidb_0xdea.GetTopicRspBody();
  public final PBRepeatMessageField<oidb_0xdea.DeleteBarrageRspBody> rpt_delete_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea.DeleteBarrageRspBody.class);
  public final PBRepeatMessageField<oidb_0xdea.RecallBarrageRspBody> rpt_recall_barrage_rsp_list = PBField.initRepeatMessage(oidb_0xdea.RecallBarrageRspBody.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdea.RspBody
 * JD-Core Version:    0.7.0.1
 */