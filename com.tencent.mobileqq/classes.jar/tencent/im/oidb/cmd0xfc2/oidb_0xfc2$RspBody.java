package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xfc2$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0xfc2.ApplyDownloadRsp msg_apply_download_rsp = new oidb_0xfc2.ApplyDownloadRsp();
  public oidb_0xfc2.ApplyPreviewRsp msg_apply_preview_rsp = new oidb_0xfc2.ApplyPreviewRsp();
  public oidb_0xfc2.SecurityStrikeRsp msg_apply_security_strike_rsp = new oidb_0xfc2.SecurityStrikeRsp();
  public oidb_0xfc2.ApplyUploadRsp msg_apply_upload_rsp = new oidb_0xfc2.ApplyUploadRsp();
  public final PBEnumField msg_bus_type = PBField.initEnum(0);
  public final PBEnumField msg_cmd = PBField.initEnum(0);
  public oidb_0xfc2.UploadCompletedRsp msg_upload_completed_rsp = new oidb_0xfc2.UploadCompletedRsp();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 40, 882, 1682, 2482, 3282, 4082 }, new String[] { "msg_cmd", "msg_bus_type", "msg_apply_upload_rsp", "msg_upload_completed_rsp", "msg_apply_download_rsp", "msg_apply_preview_rsp", "msg_apply_security_strike_rsp" }, new Object[] { localInteger, localInteger, null, null, null, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.RspBody
 * JD-Core Version:    0.7.0.1
 */