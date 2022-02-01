package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 808, 816, 1600, 720002, 720010, 720018, 799994 }, new String[] { "uint32_cmd", "uint32_seq", "msg_recv_list_query_req", "msg_send_list_query_req", "msg_renew_file_req", "msg_recall_file_req", "msg_apply_upload_req", "msg_apply_upload_hit_req", "msg_apply_forward_file_req", "msg_upload_succ_req", "msg_delete_file_req", "msg_download_succ_req", "msg_apply_download_abs_req", "msg_apply_download_req", "msg_apply_list_download_req", "msg_file_query_req", "msg_apply_copy_from_req", "msg_apply_upload_req_v2", "msg_apply_upload_req_v3", "msg_apply_upload_hit_req_v2", "msg_apply_upload_hit_req_v3", "uint32_business_id", "uint32_client_type", "uint32_flag_support_mediaplatform", "msg_apply_copy_to_req", "msg_apply_clean_traffic_req", "msg_apply_get_traffic_req", "msg_extension_req" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, null, null, null }, ReqBody.class);
  public cmd0x346.ApplyCleanTrafficReq msg_apply_clean_traffic_req = new cmd0x346.ApplyCleanTrafficReq();
  public cmd0x346.ApplyCopyFromReq msg_apply_copy_from_req = new cmd0x346.ApplyCopyFromReq();
  public cmd0x346.ApplyCopyToReq msg_apply_copy_to_req = new cmd0x346.ApplyCopyToReq();
  public cmd0x346.ApplyDownloadAbsReq msg_apply_download_abs_req = new cmd0x346.ApplyDownloadAbsReq();
  public cmd0x346.ApplyDownloadReq msg_apply_download_req = new cmd0x346.ApplyDownloadReq();
  public cmd0x346.ApplyForwardFileReq msg_apply_forward_file_req = new cmd0x346.ApplyForwardFileReq();
  public cmd0x346.ApplyGetTrafficReq msg_apply_get_traffic_req = new cmd0x346.ApplyGetTrafficReq();
  public cmd0x346.ApplyListDownloadReq msg_apply_list_download_req = new cmd0x346.ApplyListDownloadReq();
  public cmd0x346.ApplyUploadHitReq msg_apply_upload_hit_req = new cmd0x346.ApplyUploadHitReq();
  public cmd0x346.ApplyUploadHitReqV2 msg_apply_upload_hit_req_v2 = new cmd0x346.ApplyUploadHitReqV2();
  public cmd0x346.ApplyUploadHitReqV3 msg_apply_upload_hit_req_v3 = new cmd0x346.ApplyUploadHitReqV3();
  public cmd0x346.ApplyUploadReq msg_apply_upload_req = new cmd0x346.ApplyUploadReq();
  public cmd0x346.ApplyUploadReqV2 msg_apply_upload_req_v2 = new cmd0x346.ApplyUploadReqV2();
  public cmd0x346.ApplyUploadReqV3 msg_apply_upload_req_v3 = new cmd0x346.ApplyUploadReqV3();
  public cmd0x346.DeleteFileReq msg_delete_file_req = new cmd0x346.DeleteFileReq();
  public cmd0x346.DownloadSuccReq msg_download_succ_req = new cmd0x346.DownloadSuccReq();
  public cmd0x346.ExtensionReq msg_extension_req = new cmd0x346.ExtensionReq();
  public cmd0x346.FileQueryReq msg_file_query_req = new cmd0x346.FileQueryReq();
  public cmd0x346.RecallFileReq msg_recall_file_req = new cmd0x346.RecallFileReq();
  public cmd0x346.RecvListQueryReq msg_recv_list_query_req = new cmd0x346.RecvListQueryReq();
  public cmd0x346.RenewFileReq msg_renew_file_req = new cmd0x346.RenewFileReq();
  public cmd0x346.SendListQueryReq msg_send_list_query_req = new cmd0x346.SendListQueryReq();
  public cmd0x346.UploadSuccReq msg_upload_succ_req = new cmd0x346.UploadSuccReq();
  public final PBUInt32Field uint32_business_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_support_mediaplatform = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.ReqBody
 * JD-Core Version:    0.7.0.1
 */