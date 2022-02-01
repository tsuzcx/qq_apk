package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_cmd0x8f7$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_ret_msg = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field int32_ret_code = PBField.initInt32(0);
  public oidb_cmd0x8f7.ApplyDelRspBody msg_del_rsp_body = new oidb_cmd0x8f7.ApplyDelRspBody();
  public oidb_cmd0x8f7.ApplyDownAbsRsp msg_downabs_rsp_body = new oidb_cmd0x8f7.ApplyDownAbsRsp();
  public oidb_cmd0x8f7.ApplyDownloadRspBody msg_download_rsp_body = new oidb_cmd0x8f7.ApplyDownloadRspBody();
  public oidb_cmd0x8f7.SourceID msg_source_id = new oidb_cmd0x8f7.SourceID();
  public oidb_cmd0x8f7.ApplyUploadRspBody msg_upload_rsp_body = new oidb_cmd0x8f7.ApplyUploadRspBody();
  public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
  public final PBUInt64Field uint64_appid = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 48, 90, 98, 106, 114 }, new String[] { "int32_ret_code", "bytes_ret_msg", "uint32_subcmd", "msg_source_id", "bytes_workflow_id", "uint64_appid", "msg_upload_rsp_body", "msg_download_rsp_body", "msg_downabs_rsp_body", "msg_del_rsp_body" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), null, localByteStringMicro2, Long.valueOf(0L), null, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x8f7.oidb_cmd0x8f7.RspBody
 * JD-Core Version:    0.7.0.1
 */