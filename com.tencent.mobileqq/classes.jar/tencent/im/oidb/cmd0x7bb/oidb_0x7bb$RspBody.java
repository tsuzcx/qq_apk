package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x7bb$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 66, 74 }, new String[] { "open_poi_rsp", "query_poi_rsp", "query_item_rsp", "page_item_rsp", "page_history_rsp", "deduct_item_rsp", "query_task_rsp", "report_rsp" }, new Object[] { null, null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0x7bb.DeductItemRsp deduct_item_rsp = new oidb_0x7bb.DeductItemRsp();
  public oidb_0x7bb.OpenPoiRsp open_poi_rsp = new oidb_0x7bb.OpenPoiRsp();
  public oidb_0x7bb.PageHistoryRsp page_history_rsp = new oidb_0x7bb.PageHistoryRsp();
  public oidb_0x7bb.PageItemRsp page_item_rsp = new oidb_0x7bb.PageItemRsp();
  public oidb_0x7bb.QueryItemRsp query_item_rsp = new oidb_0x7bb.QueryItemRsp();
  public oidb_0x7bb.QueryPoiRsp query_poi_rsp = new oidb_0x7bb.QueryPoiRsp();
  public oidb_0x7bb.QueryTaskRsp query_task_rsp = new oidb_0x7bb.QueryTaskRsp();
  public oidb_0x7bb.ReportRsp report_rsp = new oidb_0x7bb.ReportRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.RspBody
 * JD-Core Version:    0.7.0.1
 */