package tencent.im.oidb.cmd0x98d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x98d$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "y_list_req", "z_list_req", "get_req" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_0x98d.GetReq get_req = new oidb_0x98d.GetReq();
  public oidb_0x98d.YListReq y_list_req = new oidb_0x98d.YListReq();
  public oidb_0x98d.ZListReq z_list_req = new oidb_0x98d.ZListReq();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tencent.im.oidb.cmd0x98d.oidb_0x98d.ReqBody
 * JD-Core Version:    0.7.0.1
 */