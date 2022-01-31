package tencent.im.oidb.cmd0x7bb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x7bb$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 66, 74 }, new String[] { "open_poi_req", "query_poi_req", "query_item_req", "page_item_req", "page_history_req", "deduct_item_req", "query_task_req", "report_req" }, new Object[] { null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0x7bb.DeductItemReq deduct_item_req = new oidb_0x7bb.DeductItemReq();
  public oidb_0x7bb.OpenPoiReq open_poi_req = new oidb_0x7bb.OpenPoiReq();
  public oidb_0x7bb.PageHistoryReq page_history_req = new oidb_0x7bb.PageHistoryReq();
  public oidb_0x7bb.PageItemReq page_item_req = new oidb_0x7bb.PageItemReq();
  public oidb_0x7bb.QueryItemReq query_item_req = new oidb_0x7bb.QueryItemReq();
  public oidb_0x7bb.QueryPoiReq query_poi_req = new oidb_0x7bb.QueryPoiReq();
  public oidb_0x7bb.QueryTaskReq query_task_req = new oidb_0x7bb.QueryTaskReq();
  public oidb_0x7bb.ReportReq report_req = new oidb_0x7bb.ReportReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x7bb.oidb_0x7bb.ReqBody
 * JD-Core Version:    0.7.0.1
 */