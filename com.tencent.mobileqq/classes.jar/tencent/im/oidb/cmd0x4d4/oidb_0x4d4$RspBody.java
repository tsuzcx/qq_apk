package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.trunk.Qworkflow.Qworkflow.AppID;

public final class oidb_0x4d4$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98 }, new String[] { "msg_appid", "msg_get_workflow_list_rsp", "msg_update_workflow_rsp", "msg_add_workflow_rsp", "msg_delete_workflow_rsp", "msg_recall_workflow_rsp", "msg_set_workflows_readed_rsp", "msg_set_all_workflow_processed_rsp", "msg_get_workflow_by_id_rsp", "msg_set_workflows_ignore_state_rsp", "msg_share_workflow_rsp", "msg_hasten_workflow_rsp" }, new Object[] { null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public oidb_0x4d4.AddWorkflowRsp msg_add_workflow_rsp = new oidb_0x4d4.AddWorkflowRsp();
  public Qworkflow.AppID msg_appid = new Qworkflow.AppID();
  public oidb_0x4d4.DeleteWorkflowRsp msg_delete_workflow_rsp = new oidb_0x4d4.DeleteWorkflowRsp();
  public oidb_0x4d4.GetWorkflowByIDRsp msg_get_workflow_by_id_rsp = new oidb_0x4d4.GetWorkflowByIDRsp();
  public oidb_0x4d4.GetWorkflowListRsp msg_get_workflow_list_rsp = new oidb_0x4d4.GetWorkflowListRsp();
  public oidb_0x4d4.HastenWorkflowRsp msg_hasten_workflow_rsp = new oidb_0x4d4.HastenWorkflowRsp();
  public oidb_0x4d4.RecallWorkflowRsp msg_recall_workflow_rsp = new oidb_0x4d4.RecallWorkflowRsp();
  public oidb_0x4d4.SetAllWorkflowProcessedRsp msg_set_all_workflow_processed_rsp = new oidb_0x4d4.SetAllWorkflowProcessedRsp();
  public oidb_0x4d4.SetWorkflowsIgnoreStateRsp msg_set_workflows_ignore_state_rsp = new oidb_0x4d4.SetWorkflowsIgnoreStateRsp();
  public oidb_0x4d4.SetWorkflowsReadedRsp msg_set_workflows_readed_rsp = new oidb_0x4d4.SetWorkflowsReadedRsp();
  public oidb_0x4d4.ShareWorkflowRsp msg_share_workflow_rsp = new oidb_0x4d4.ShareWorkflowRsp();
  public oidb_0x4d4.UpdateWorkflowsRsp msg_update_workflow_rsp = new oidb_0x4d4.UpdateWorkflowsRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x4d4.oidb_0x4d4.RspBody
 * JD-Core Version:    0.7.0.1
 */