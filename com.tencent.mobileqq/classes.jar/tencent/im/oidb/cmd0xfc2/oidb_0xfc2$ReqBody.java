package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

public final class oidb_0xfc2$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_0xfc2.ApplyDownloadReq msg_apply_download_req = new oidb_0xfc2.ApplyDownloadReq();
  public oidb_0xfc2.ApplyPreviewReq msg_apply_preview_req = new oidb_0xfc2.ApplyPreviewReq();
  public oidb_0xfc2.SecurityStrikeReq msg_apply_security_strike_req = new oidb_0xfc2.SecurityStrikeReq();
  public oidb_0xfc2.ApplyUploadReq msg_apply_upload_req = new oidb_0xfc2.ApplyUploadReq();
  public final PBEnumField msg_bus_type = PBField.initEnum(0);
  public oidb_0xfc2.ChannelInfo msg_channel_info = new oidb_0xfc2.ChannelInfo();
  public final PBEnumField msg_cmd = PBField.initEnum(0);
  public final PBEnumField msg_terminal_type = PBField.initEnum(0);
  public oidb_0xfc2.UploadCompletedReq msg_upload_completed_req = new oidb_0xfc2.UploadCompletedReq();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 24, 34, 40, 802, 1602, 2402, 3202, 4002 }, new String[] { "msg_cmd", "msg_bus_type", "msg_channel_info", "msg_terminal_type", "msg_apply_upload_req", "msg_upload_completed_req", "msg_apply_download_req", "msg_apply_preview_req", "msg_apply_security_strike_req" }, new Object[] { localInteger, localInteger, null, localInteger, null, null, null, null, null }, ReqBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     tencent.im.oidb.cmd0xfc2.oidb_0xfc2.ReqBody
 * JD-Core Version:    0.7.0.1
 */