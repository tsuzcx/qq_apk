package tencent.im.cs.cmd0x346;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class cmd0x346$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public cmd0x346.ApplyCleanTrafficRsp msg_apply_clean_traffic_rsp = new cmd0x346.ApplyCleanTrafficRsp();
  public cmd0x346.ApplyCopyFromRsp msg_apply_copy_from_rsp = new cmd0x346.ApplyCopyFromRsp();
  public cmd0x346.ApplyCopyToRsp msg_apply_copy_to_rsp = new cmd0x346.ApplyCopyToRsp();
  public cmd0x346.ApplyDownloadAbsRsp msg_apply_download_abs_rsp = new cmd0x346.ApplyDownloadAbsRsp();
  public cmd0x346.ApplyDownloadRsp msg_apply_download_rsp = new cmd0x346.ApplyDownloadRsp();
  public cmd0x346.ApplyForwardFileRsp msg_apply_forward_file_rsp = new cmd0x346.ApplyForwardFileRsp();
  public cmd0x346.ApplyGetTrafficRsp msg_apply_get_traffic_rsp = new cmd0x346.ApplyGetTrafficRsp();
  public cmd0x346.ApplyListDownloadRsp msg_apply_list_download_rsp = new cmd0x346.ApplyListDownloadRsp();
  public cmd0x346.ApplyUploadHitRsp msg_apply_upload_hit_rsp = new cmd0x346.ApplyUploadHitRsp();
  public cmd0x346.ApplyUploadHitRspV2 msg_apply_upload_hit_rsp_v2 = new cmd0x346.ApplyUploadHitRspV2();
  public cmd0x346.ApplyUploadHitRspV3 msg_apply_upload_hit_rsp_v3 = new cmd0x346.ApplyUploadHitRspV3();
  public cmd0x346.ApplyUploadRsp msg_apply_upload_rsp = new cmd0x346.ApplyUploadRsp();
  public cmd0x346.ApplyUploadRspV2 msg_apply_upload_rsp_v2 = new cmd0x346.ApplyUploadRspV2();
  public cmd0x346.ApplyUploadRspV3 msg_apply_upload_rsp_v3 = new cmd0x346.ApplyUploadRspV3();
  public cmd0x346.DeleteFileRsp msg_delete_file_rsp = new cmd0x346.DeleteFileRsp();
  public cmd0x346.DownloadSuccRsp msg_download_succ_rsp = new cmd0x346.DownloadSuccRsp();
  public cmd0x346.ExtensionRsp msg_extension_rsp = new cmd0x346.ExtensionRsp();
  public cmd0x346.FileQueryRsp msg_file_query_rsp = new cmd0x346.FileQueryRsp();
  public cmd0x346.RecallFileRsp msg_recall_file_rsp = new cmd0x346.RecallFileRsp();
  public cmd0x346.RecvListQueryRsp msg_recv_list_query_rsp = new cmd0x346.RecvListQueryRsp();
  public cmd0x346.RenewFileRsp msg_renew_file_rsp = new cmd0x346.RenewFileRsp();
  public cmd0x346.SendListQueryRsp msg_send_list_query_rsp = new cmd0x346.SendListQueryRsp();
  public cmd0x346.UploadSuccRsp msg_upload_succ_rsp = new cmd0x346.UploadSuccRsp();
  public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
  public final PBUInt32Field uint32_flag_use_media_platform = PBField.initUInt32(0);
  public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 400, 720002, 720010, 720018, 799994 }, new String[] { "uint32_cmd", "uint32_seq", "msg_recv_list_query_rsp", "msg_send_list_query_rsp", "msg_renew_file_rsp", "msg_recall_file_rsp", "msg_apply_upload_rsp", "msg_apply_upload_hit_rsp", "msg_apply_forward_file_rsp", "msg_upload_succ_rsp", "msg_delete_file_rsp", "msg_download_succ_rsp", "msg_apply_download_abs_rsp", "msg_apply_download_rsp", "msg_apply_list_download_rsp", "msg_file_query_rsp", "msg_apply_copy_from_rsp", "msg_apply_upload_rsp_v2", "msg_apply_upload_rsp_v3", "msg_apply_upload_hit_rsp_v2", "msg_apply_upload_hit_rsp_v3", "uint32_flag_use_media_platform", "msg_apply_copy_to_rsp", "msg_apply_clean_traffic_rsp", "msg_apply_get_traffic_rsp", "msg_extension_rsp" }, new Object[] { localInteger, localInteger, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, localInteger, null, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.cs.cmd0x346.cmd0x346.RspBody
 * JD-Core Version:    0.7.0.1
 */