package tencent.im.oidb.cmd0x6d8;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "file_info_req", "file_list_info_req", "group_file_cnt_req", "group_space_req", "file_preview_req" }, new Object[] { null, null, null, null, null }, ReqBody.class);
  public oidb_0x6d8.GetFileInfoReqBody file_info_req = new oidb_0x6d8.GetFileInfoReqBody();
  public oidb_0x6d8.GetFileListReqBody file_list_info_req = new oidb_0x6d8.GetFileListReqBody();
  public oidb_0x6d8.GetFilePreviewReqBody file_preview_req = new oidb_0x6d8.GetFilePreviewReqBody();
  public oidb_0x6d8.GetFileCountReqBody group_file_cnt_req = new oidb_0x6d8.GetFileCountReqBody();
  public oidb_0x6d8.GetSpaceReqBody group_space_req = new oidb_0x6d8.GetSpaceReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d8.oidb_0x6d8.ReqBody
 * JD-Core Version:    0.7.0.1
 */