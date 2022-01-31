package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d9$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42 }, new String[] { "trans_file_rsp", "copy_from_rsp", "copy_to_rsp", "feeds_info_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
  public oidb_0x6d9.CopyFromRspBody copy_from_rsp = new oidb_0x6d9.CopyFromRspBody();
  public oidb_0x6d9.CopyToRspBody copy_to_rsp = new oidb_0x6d9.CopyToRspBody();
  public oidb_0x6d9.FeedsRspBody feeds_info_rsp = new oidb_0x6d9.FeedsRspBody();
  public oidb_0x6d9.TransFileRspBody trans_file_rsp = new oidb_0x6d9.TransFileRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody
 * JD-Core Version:    0.7.0.1
 */