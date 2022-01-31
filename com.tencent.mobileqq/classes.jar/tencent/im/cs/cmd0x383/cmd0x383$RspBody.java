package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class cmd0x383$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 890, 898, 906, 914, 922, 930, 938, 954 }, new String[] { "int32_ret_code", "str_ret_msg", "str_client_wording", "msg_upload_rsp_body", "msg_resend_rsp_body", "msg_download_rsp_body", "msg_del_file_rsp_body", "msg_rename_rsp_body", "msg_trans_file_rsp_body", "msg_link_file_rsp_body", "msg_feed_msg_v2_rsp_body", "msg_get_space_rsp_body", "msg_check_audit_flag_rsp_body", "msg_copy_from_rsp_body", "msg_copy_to_rsp_body", "msg_get_file_list_rsp_body", "msg_create_folder_rsp_body", "msg_get_file_count_rsp_body", "msg_get_file_info_rsp_body", "msg_get_file_list_v2_rsp_body", "msg_file_search_rsp_body" }, new Object[] { Integer.valueOf(0), "", "", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, RspBody.class);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public cmd0x383.ApplyCheckAuditFlagRspBody msg_check_audit_flag_rsp_body = new cmd0x383.ApplyCheckAuditFlagRspBody();
  public cmd0x383.ApplyCopyFromRspBody msg_copy_from_rsp_body = new cmd0x383.ApplyCopyFromRspBody();
  public cmd0x383.ApplyCopyToRspBody msg_copy_to_rsp_body = new cmd0x383.ApplyCopyToRspBody();
  public cmd0x383.ApplyCreateFolderRspBody msg_create_folder_rsp_body = new cmd0x383.ApplyCreateFolderRspBody();
  public cmd0x383.ApplyDelFileRspBody msg_del_file_rsp_body = new cmd0x383.ApplyDelFileRspBody();
  public cmd0x383.ApplyDownloadRspBody msg_download_rsp_body = new cmd0x383.ApplyDownloadRspBody();
  public cmd0x383.ApplyFeedMsgV2RspBody msg_feed_msg_v2_rsp_body = new cmd0x383.ApplyFeedMsgV2RspBody();
  public cmd0x383.ApplyFileSearchRspBody msg_file_search_rsp_body = new cmd0x383.ApplyFileSearchRspBody();
  public cmd0x383.ApplyGetFileCountRspBody msg_get_file_count_rsp_body = new cmd0x383.ApplyGetFileCountRspBody();
  public cmd0x383.ApplyGetFileInfoRspBody msg_get_file_info_rsp_body = new cmd0x383.ApplyGetFileInfoRspBody();
  public cmd0x383.ApplyGetFileListRspBody msg_get_file_list_rsp_body = new cmd0x383.ApplyGetFileListRspBody();
  public cmd0x383.ApplyGetFileListV2RspBody msg_get_file_list_v2_rsp_body = new cmd0x383.ApplyGetFileListV2RspBody();
  public cmd0x383.ApplyGetSpaceRspBody msg_get_space_rsp_body = new cmd0x383.ApplyGetSpaceRspBody();
  public cmd0x383.ApplyLinkFileRspBody msg_link_file_rsp_body = new cmd0x383.ApplyLinkFileRspBody();
  public cmd0x383.ApplyRenameRspBody msg_rename_rsp_body = new cmd0x383.ApplyRenameRspBody();
  public cmd0x383.ApplyResendRspBody msg_resend_rsp_body = new cmd0x383.ApplyResendRspBody();
  public cmd0x383.ApplyTransFileRspBody msg_trans_file_rsp_body = new cmd0x383.ApplyTransFileRspBody();
  public cmd0x383.ApplyUploadRspBody msg_upload_rsp_body = new cmd0x383.ApplyUploadRspBody();
  public final PBStringField str_client_wording = PBField.initString("");
  public final PBStringField str_ret_msg = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.RspBody
 * JD-Core Version:    0.7.0.1
 */