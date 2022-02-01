package tencent.im.oidb.cmd0xe1b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xe1b$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 90, 98 }, new String[] { "msg_get_flag_info_rsp", "msg_set_flag_info_rsp" }, new Object[] { null, null }, RspBody.class);
  public oidb_0xe1b.GetFlagInfoRsp msg_get_flag_info_rsp = new oidb_0xe1b.GetFlagInfoRsp();
  public oidb_0xe1b.SetFlagInfoRsp msg_set_flag_info_rsp = new oidb_0xe1b.SetFlagInfoRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0xe1b.oidb_0xe1b.RspBody
 * JD-Core Version:    0.7.0.1
 */