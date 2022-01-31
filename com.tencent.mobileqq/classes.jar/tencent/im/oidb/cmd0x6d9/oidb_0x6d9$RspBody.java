package tencent.im.oidb.cmd0x6d9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x6d9$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 42 }, new String[] { "trans_file_rsp", "feeds_info_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0x6d9.FeedsRspBody feeds_info_rsp = new oidb_0x6d9.FeedsRspBody();
  public oidb_0x6d9.TransFileRspBody trans_file_rsp = new oidb_0x6d9.TransFileRspBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x6d9.oidb_0x6d9.RspBody
 * JD-Core Version:    0.7.0.1
 */