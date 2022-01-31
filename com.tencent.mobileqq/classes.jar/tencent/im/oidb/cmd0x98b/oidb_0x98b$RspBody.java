package tencent.im.oidb.cmd0x98b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x98b$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58 }, new String[] { "msg_start_activity_rsp", "msg_join_activity_rsp", "msg_click_package_rsp", "msg_open_package_rsp", "msg_report_package_rsp", "msg_get_activity_state_rsp", "msg_get_ranking_rsp" }, new Object[] { null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0x98b.ClickPackageRsp msg_click_package_rsp = new oidb_0x98b.ClickPackageRsp();
  public oidb_0x98b.GetActivityStateRsp msg_get_activity_state_rsp = new oidb_0x98b.GetActivityStateRsp();
  public oidb_0x98b.GetRankingRsp msg_get_ranking_rsp = new oidb_0x98b.GetRankingRsp();
  public oidb_0x98b.JoinActivityRsp msg_join_activity_rsp = new oidb_0x98b.JoinActivityRsp();
  public oidb_0x98b.OpenPackageRsp msg_open_package_rsp = new oidb_0x98b.OpenPackageRsp();
  public oidb_0x98b.ReportPackageRsp msg_report_package_rsp = new oidb_0x98b.ReportPackageRsp();
  public oidb_0x98b.StartActivityRsp msg_start_activity_rsp = new oidb_0x98b.StartActivityRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98b.oidb_0x98b.RspBody
 * JD-Core Version:    0.7.0.1
 */