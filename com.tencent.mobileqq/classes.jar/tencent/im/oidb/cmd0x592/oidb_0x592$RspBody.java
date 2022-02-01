package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.trunk.Qworkflow.Qworkflow.AppID;

public final class oidb_0x592$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154 }, new String[] { "msg_appid", "msg_add_schedule_rsp", "msg_get_once_schedule_list_rsp", "msg_get_schedule_by_id_rsp", "msg_get_repeated_schedule_list_rsp", "msg_update_schedule_content_rsp", "msg_delete_my_schedule_rsp", "msg_recall_schedule_rsp", "msg_share_schedule_rsp", "msg_change_my_recv_status_rsp", "msg_set_all_readed_time_rsp", "msg_modify_unread_cnt_rsp", "msg_set_remind_bell_switch_rsp", "msg_get_date_has_once_schedule_rsp", "msg_modify_repeated_schedule_rsp", "msg_recall_repeated_schedule_rsp", "msg_get_repeated_schedule_list_rsp_new", "msg_get_once_schedule_list_incrementally_rsp", "msg_accept_schedule_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0x592.AcceptScheduleRsp msg_accept_schedule_rsp = new oidb_0x592.AcceptScheduleRsp();
  public oidb_0x592.AddScheduleRsp msg_add_schedule_rsp = new oidb_0x592.AddScheduleRsp();
  public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
  public oidb_0x592.ChangeMyNotificationReceivingStatusRsp msg_change_my_recv_status_rsp = new oidb_0x592.ChangeMyNotificationReceivingStatusRsp();
  public oidb_0x592.DeleteMyScheduleRsp msg_delete_my_schedule_rsp = new oidb_0x592.DeleteMyScheduleRsp();
  public oidb_0x592.GetDateHasOnceScheduleRsp msg_get_date_has_once_schedule_rsp = new oidb_0x592.GetDateHasOnceScheduleRsp();
  public oidb_0x592.GetOnceScheduleListIncrementallyRsp msg_get_once_schedule_list_incrementally_rsp = new oidb_0x592.GetOnceScheduleListIncrementallyRsp();
  public oidb_0x592.GetOnceScheduleListRsp msg_get_once_schedule_list_rsp = new oidb_0x592.GetOnceScheduleListRsp();
  public oidb_0x592.GetRepeatedScheduleListRsp msg_get_repeated_schedule_list_rsp = new oidb_0x592.GetRepeatedScheduleListRsp();
  public oidb_0x592.GetRepeatedScheduleListRsp msg_get_repeated_schedule_list_rsp_new = new oidb_0x592.GetRepeatedScheduleListRsp();
  public oidb_0x592.GetScheduleByIDRsp msg_get_schedule_by_id_rsp = new oidb_0x592.GetScheduleByIDRsp();
  public oidb_0x592.ModifyRepeatedScheduleRsp msg_modify_repeated_schedule_rsp = new oidb_0x592.ModifyRepeatedScheduleRsp();
  public oidb_0x592.ModifyUnreadCntRsp msg_modify_unread_cnt_rsp = new oidb_0x592.ModifyUnreadCntRsp();
  public oidb_0x592.RecallRepeatedScheduleRsp msg_recall_repeated_schedule_rsp = new oidb_0x592.RecallRepeatedScheduleRsp();
  public oidb_0x592.RecallScheduleRsp msg_recall_schedule_rsp = new oidb_0x592.RecallScheduleRsp();
  public oidb_0x592.SetAllReadedTimeRsp msg_set_all_readed_time_rsp = new oidb_0x592.SetAllReadedTimeRsp();
  public oidb_0x592.SetRemindBellSwitchRsp msg_set_remind_bell_switch_rsp = new oidb_0x592.SetRemindBellSwitchRsp();
  public oidb_0x592.ShareScheduleRsp msg_share_schedule_rsp = new oidb_0x592.ShareScheduleRsp();
  public oidb_0x592.UpdateScheduleContentRsp msg_update_schedule_content_rsp = new oidb_0x592.UpdateScheduleContentRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.RspBody
 * JD-Core Version:    0.7.0.1
 */