package tencent.im.cs.cmd0x383;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0x383$ReqBody
  extends MessageMicro<ReqBody>
{
  public static final int APP_ID_ANDROID_CLIENT = 3;
  public static final int APP_ID_ANPING_SVR = 100;
  public static final int APP_ID_DISCUSS_SVR = 13;
  public static final int APP_ID_FEEDS_TRANS_SVR = 17;
  public static final int APP_ID_GJ_UNKNOWN_SVR = 101;
  public static final int APP_ID_GROUPACTIVE_SVR = 16;
  public static final int APP_ID_GROUPCARD_SVR = 15;
  public static final int APP_ID_GROUPSPACE_SVR = 11;
  public static final int APP_ID_IOS_CLIENT = 2;
  public static final int APP_ID_IPAD_CLIENT = 5;
  public static final int APP_ID_NEW_GROUP_EVENT = 40;
  public static final int APP_ID_OFFlINE_SVR = 12;
  public static final int APP_ID_PC_CLIENT = 1;
  public static final int APP_ID_PC_CLIENT_WEB = 4;
  public static final int APP_ID_WEIYUN_SVR = 14;
  public static final int APP_ID_WINPHONE_CLIENT = 6;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 890, 898, 906, 914, 922, 930, 938, 954 }, new String[] { "uint64_groupcode", "uint32_app_id", "msg_upload_req_body", "msg_resend_req_body", "msg_download_req_body", "msg_del_file_req_body", "msg_rename_req_body", "msg_trans_file_req_body", "msg_link_file_req_body", "msg_feed_msg_v2_req_body", "msg_get_space_req_body", "msg_check_audit_flag_req_body", "msg_copy_from_req_body", "msg_copy_to_req_body", "msg_get_file_list_req_body", "msg_create_folder_req_body", "msg_get_file_count_req_body", "msg_get_file_info_req_body", "msg_get_file_list_v2_req_body", "msg_file_search_req_body" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null }, ReqBody.class);
  public cmd0x383.ApplyCheckAuditFlagReqBody msg_check_audit_flag_req_body = new cmd0x383.ApplyCheckAuditFlagReqBody();
  public cmd0x383.ApplyCopyFromReqBody msg_copy_from_req_body = new cmd0x383.ApplyCopyFromReqBody();
  public cmd0x383.ApplyCopyToReqBody msg_copy_to_req_body = new cmd0x383.ApplyCopyToReqBody();
  public cmd0x383.ApplyCreateFolderReqBody msg_create_folder_req_body = new cmd0x383.ApplyCreateFolderReqBody();
  public cmd0x383.ApplyDelFileReqBody msg_del_file_req_body = new cmd0x383.ApplyDelFileReqBody();
  public cmd0x383.ApplyDownloadReqBody msg_download_req_body = new cmd0x383.ApplyDownloadReqBody();
  public cmd0x383.ApplyFeedMsgV2ReqBody msg_feed_msg_v2_req_body = new cmd0x383.ApplyFeedMsgV2ReqBody();
  public cmd0x383.ApplyFileSearchReqBody msg_file_search_req_body = new cmd0x383.ApplyFileSearchReqBody();
  public cmd0x383.ApplyGetFileCountReqBody msg_get_file_count_req_body = new cmd0x383.ApplyGetFileCountReqBody();
  public cmd0x383.ApplyGetFileInfoReqBody msg_get_file_info_req_body = new cmd0x383.ApplyGetFileInfoReqBody();
  public cmd0x383.ApplyGetFileListReqBody msg_get_file_list_req_body = new cmd0x383.ApplyGetFileListReqBody();
  public cmd0x383.ApplyGetFileListV2ReqBody msg_get_file_list_v2_req_body = new cmd0x383.ApplyGetFileListV2ReqBody();
  public cmd0x383.ApplyGetSpaceReqBody msg_get_space_req_body = new cmd0x383.ApplyGetSpaceReqBody();
  public cmd0x383.ApplyLinkFileReqBody msg_link_file_req_body = new cmd0x383.ApplyLinkFileReqBody();
  public cmd0x383.ApplyRenameReqBody msg_rename_req_body = new cmd0x383.ApplyRenameReqBody();
  public cmd0x383.ApplyResendReqBody msg_resend_req_body = new cmd0x383.ApplyResendReqBody();
  public cmd0x383.ApplyTransFileReqBody msg_trans_file_req_body = new cmd0x383.ApplyTransFileReqBody();
  public cmd0x383.ApplyUploadReqBody msg_upload_req_body = new cmd0x383.ApplyUploadReqBody();
  public final PBUInt32Field uint32_app_id = PBField.initUInt32(0);
  public final PBUInt64Field uint64_groupcode = PBField.initUInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x383.cmd0x383.ReqBody
 * JD-Core Version:    0.7.0.1
 */