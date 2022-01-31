package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x98d$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "y_list_rsp", "z_list_rsp", "get_rsp" }, new Object[] { null, null, null }, RspBody.class);
  public oidb_0x98d.GetRsp get_rsp = new oidb_0x98d.GetRsp();
  public oidb_0x98d.YListRsp y_list_rsp = new oidb_0x98d.YListRsp();
  public oidb_0x98d.ZListRsp z_list_rsp = new oidb_0x98d.ZListRsp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98d.oidb_0x98d.RspBody
 * JD-Core Version:    0.7.0.1
 */