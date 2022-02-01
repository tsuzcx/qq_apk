package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d9$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 42 }, new String[] { "trans_file_req", "copy_from_req", "copy_to_req", "feeds_info_req" }, new Object[] { null, null, null, null }, ReqBody.class);
  public oidb_0x6d9.CopyFromReqBody copy_from_req = new oidb_0x6d9.CopyFromReqBody();
  public oidb_0x6d9.CopyToReqBody copy_to_req = new oidb_0x6d9.CopyToReqBody();
  public oidb_0x6d9.FeedsReqBody feeds_info_req = new oidb_0x6d9.FeedsReqBody();
  public oidb_0x6d9.TransFileReqBody trans_file_req = new oidb_0x6d9.TransFileReqBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.ReqBody
 * JD-Core Version:    0.7.0.1
 */