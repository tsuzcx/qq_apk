package tencent.im.oidb.cmd0xdcb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_cmd0xdcb$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_icon_info", "msg_extra_info" }, new Object[] { null, null }, RspBody.class);
  public oidb_cmd0xdcb.ExtraInfo msg_extra_info = new oidb_cmd0xdcb.ExtraInfo();
  public oidb_cmd0xdcb.IconInfo msg_icon_info = new oidb_cmd0xdcb.IconInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.oidb.cmd0xdcb.oidb_cmd0xdcb.RspBody
 * JD-Core Version:    0.7.0.1
 */