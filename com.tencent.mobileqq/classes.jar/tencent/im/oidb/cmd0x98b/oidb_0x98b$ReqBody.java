package tencent.im.oidb.cmd0x98b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x98b$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 90 }, new String[] { "msg_start_activity_req", "msg_join_activity_req", "msg_click_package_req", "msg_open_package_req", "msg_report_package_req", "msg_get_activity_state_req", "msg_get_ranking_req", "msg_lbs_info" }, new Object[] { null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0x98b.ClickPackageReq msg_click_package_req = new oidb_0x98b.ClickPackageReq();
  public oidb_0x98b.GetActivityStateReq msg_get_activity_state_req = new oidb_0x98b.GetActivityStateReq();
  public oidb_0x98b.GetRankingReq msg_get_ranking_req = new oidb_0x98b.GetRankingReq();
  public oidb_0x98b.JoinActivityReq msg_join_activity_req = new oidb_0x98b.JoinActivityReq();
  public oidb_0x98b.LBSInfo msg_lbs_info = new oidb_0x98b.LBSInfo();
  public oidb_0x98b.OpenPackageReq msg_open_package_req = new oidb_0x98b.OpenPackageReq();
  public oidb_0x98b.ReportPackageReq msg_report_package_req = new oidb_0x98b.ReportPackageReq();
  public oidb_0x98b.StartActivityReq msg_start_activity_req = new oidb_0x98b.StartActivityReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98b.oidb_0x98b.ReqBody
 * JD-Core Version:    0.7.0.1
 */