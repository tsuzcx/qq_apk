package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8f7$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public oidb_cmd0x8f7.ApplyDelReqBody msg_del_req_body = new oidb_cmd0x8f7.ApplyDelReqBody();
  public oidb_cmd0x8f7.ApplyDownAbsReq msg_downabs_req_body = new oidb_cmd0x8f7.ApplyDownAbsReq();
  public oidb_cmd0x8f7.ApplyDownloadReqBody msg_download_req_body = new oidb_cmd0x8f7.ApplyDownloadReqBody();
  public oidb_cmd0x8f7.SourceID msg_source_id = new oidb_cmd0x8f7.SourceID();
  public oidb_cmd0x8f7.ApplyUploadReqBody msg_upload_req_body = new oidb_cmd0x8f7.ApplyUploadReqBody();
  public final PBUInt32Field uint32_client_net = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
  public final PBUInt32Field uint32_client_ver = PBField.initUInt32(0);
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 56, 90, 98, 106, 114 }, new String[] { "uint32_subcmd", "msg_source_id", "uint32_client_type", "uint32_client_net", "uint32_client_ver", "bytes_workflow_id", "uint64_appid", "msg_upload_req_body", "msg_download_req_body", "msg_downabs_req_body", "msg_del_req_body" }, new Object[] { localInteger, null, localInteger, localInteger, localInteger, localByteStringMicro, Long.valueOf(0L), null, null, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7.ReqBody
 * JD-Core Version:    0.7.0.1
 */