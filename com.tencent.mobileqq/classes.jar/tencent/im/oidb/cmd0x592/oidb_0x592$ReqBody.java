package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.trunk.Qworkflow.Qworkflow.AppID;

public final class oidb_0x592$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154 }, new String[] { "msg_appid", "msg_add_schedule_req", "msg_get_once_schedule_list_req", "msg_get_schedule_by_id_req", "msg_get_repeated_schedule_list_req", "msg_update_schedule_content_req", "msg_delete_my_schedule_req", "msg_recall_schedule_req", "msg_share_schedule_req", "msg_change_my_recv_status_req", "msg_set_all_readed_time_req", "msg_modify_unread_cnt_req", "msg_set_remind_bell_switch_req", "msg_get_date_has_once_schedule_req", "msg_modify_repeated_schedule_req", "msg_recall_repeated_schedule_req", "msg_get_repeated_schedule_list_req_new", "msg_get_once_schedule_list_incrementally_req", "msg_accept_schedule_req" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0x592.AcceptScheduleReq msg_accept_schedule_req = new oidb_0x592.AcceptScheduleReq();
  public oidb_0x592.AddScheduleReq msg_add_schedule_req = new oidb_0x592.AddScheduleReq();
  public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
  public oidb_0x592.ChangeMyNotificationReceivingStatusReq msg_change_my_recv_status_req = new oidb_0x592.ChangeMyNotificationReceivingStatusReq();
  public oidb_0x592.DeleteMyScheduleReq msg_delete_my_schedule_req = new oidb_0x592.DeleteMyScheduleReq();
  public oidb_0x592.GetDateHasOnceScheduleReq msg_get_date_has_once_schedule_req = new oidb_0x592.GetDateHasOnceScheduleReq();
  public oidb_0x592.GetOnceScheduleListIncrementallyReq msg_get_once_schedule_list_incrementally_req = new oidb_0x592.GetOnceScheduleListIncrementallyReq();
  public oidb_0x592.GetOnceScheduleListReq msg_get_once_schedule_list_req = new oidb_0x592.GetOnceScheduleListReq();
  public oidb_0x592.GetRepeatedScheduleListReq msg_get_repeated_schedule_list_req = new oidb_0x592.GetRepeatedScheduleListReq();
  public oidb_0x592.GetRepeatedScheduleListReq msg_get_repeated_schedule_list_req_new = new oidb_0x592.GetRepeatedScheduleListReq();
  public oidb_0x592.GetScheduleByIDReq msg_get_schedule_by_id_req = new oidb_0x592.GetScheduleByIDReq();
  public oidb_0x592.ModifyRepeatedScheduleReq msg_modify_repeated_schedule_req = new oidb_0x592.ModifyRepeatedScheduleReq();
  public oidb_0x592.ModifyUnreadCntReq msg_modify_unread_cnt_req = new oidb_0x592.ModifyUnreadCntReq();
  public oidb_0x592.RecallRepeatedScheduleReq msg_recall_repeated_schedule_req = new oidb_0x592.RecallRepeatedScheduleReq();
  public oidb_0x592.RecallScheduleReq msg_recall_schedule_req = new oidb_0x592.RecallScheduleReq();
  public oidb_0x592.SetAllReadedTimeReq msg_set_all_readed_time_req = new oidb_0x592.SetAllReadedTimeReq();
  public oidb_0x592.SetRemindBellSwitchReq msg_set_remind_bell_switch_req = new oidb_0x592.SetRemindBellSwitchReq();
  public oidb_0x592.ShareScheduleReq msg_share_schedule_req = new oidb_0x592.ShareScheduleReq();
  public oidb_0x592.UpdateScheduleContentReq msg_update_schedule_content_req = new oidb_0x592.UpdateScheduleContentReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x592.oidb_0x592.ReqBody
 * JD-Core Version:    0.7.0.1
 */