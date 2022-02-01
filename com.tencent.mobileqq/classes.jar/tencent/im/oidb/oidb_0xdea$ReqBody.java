package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class oidb_0xdea$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "add_barrage_req", "get_barrage_list_req", "rpt_recall_barrage_req_list", "rpt_delete_barrage_req_list", "get_topic_req", "get_comment_req" }, new Object[] { null, null, null, null, null, null }, ReqBody.class);
  public oidb_0xdea.AddBarrageReqBody add_barrage_req = new oidb_0xdea.AddBarrageReqBody();
  public oidb_0xdea.GetBarrageListReqBody get_barrage_list_req = new oidb_0xdea.GetBarrageListReqBody();
  public oidb_0xdea.GetCommentReqBody get_comment_req = new oidb_0xdea.GetCommentReqBody();
  public oidb_0xdea.GetTopicReqBody get_topic_req = new oidb_0xdea.GetTopicReqBody();
  public final PBRepeatMessageField<oidb_0xdea.DeleteBarrageReqBody> rpt_delete_barrage_req_list = PBField.initRepeatMessage(oidb_0xdea.DeleteBarrageReqBody.class);
  public final PBRepeatMessageField<oidb_0xdea.RecallBarrageReqBody> rpt_recall_barrage_req_list = PBField.initRepeatMessage(oidb_0xdea.RecallBarrageReqBody.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xdea.ReqBody
 * JD-Core Version:    0.7.0.1
 */