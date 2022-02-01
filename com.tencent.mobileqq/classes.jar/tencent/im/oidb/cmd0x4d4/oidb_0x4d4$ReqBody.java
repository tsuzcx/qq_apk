package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.trunk.Qworkflow.Qworkflow.AppID;

public final class oidb_0x4d4$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "msg_appid", "msg_get_workflow_list_req", "msg_update_workflows_req", "msg_add_workflow_req", "msg_delete_workflow_req", "msg_recall_workflow_req", "msg_set_workflows_readed_req", "msg_set_all_workflow_processed_req", "msg_get_workflow_by_id_req", "msg_set_workflows_ignore_state_req", "msg_share_workflow_req", "msg_hasten_workflow_req" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public oidb_0x4d4.AddWorkflowReq msg_add_workflow_req = new oidb_0x4d4.AddWorkflowReq();
  public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
  public oidb_0x4d4.DeleteWorkflowReq msg_delete_workflow_req = new oidb_0x4d4.DeleteWorkflowReq();
  public oidb_0x4d4.GetWorkflowByIDReq msg_get_workflow_by_id_req = new oidb_0x4d4.GetWorkflowByIDReq();
  public oidb_0x4d4.GetWorkflowListReq msg_get_workflow_list_req = new oidb_0x4d4.GetWorkflowListReq();
  public oidb_0x4d4.HastenWorkflowReq msg_hasten_workflow_req = new oidb_0x4d4.HastenWorkflowReq();
  public oidb_0x4d4.RecallWorkflowReq msg_recall_workflow_req = new oidb_0x4d4.RecallWorkflowReq();
  public oidb_0x4d4.SetAllWorkflowProcessedReq msg_set_all_workflow_processed_req = new oidb_0x4d4.SetAllWorkflowProcessedReq();
  public oidb_0x4d4.SetWorkflowsIgnoreStateReq msg_set_workflows_ignore_state_req = new oidb_0x4d4.SetWorkflowsIgnoreStateReq();
  public oidb_0x4d4.SetWorkflowsReadedReq msg_set_workflows_readed_req = new oidb_0x4d4.SetWorkflowsReadedReq();
  public oidb_0x4d4.ShareWorkflowReq msg_share_workflow_req = new oidb_0x4d4.ShareWorkflowReq();
  public oidb_0x4d4.UpdateWorkflowsReq msg_update_workflows_req = new oidb_0x4d4.UpdateWorkflowsReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.ReqBody
 * JD-Core Version:    0.7.0.1
 */