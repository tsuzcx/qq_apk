package tencent.im.oidb.cmd0x791;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x791$ReqBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_set_reddot", "msg_get_reddot", "msg_set_reddot_appids" }, new Object[] { null, null, null }, ReqBody.class);
  public oidb_0x791.GetRedDotOpt msg_get_reddot = new oidb_0x791.GetRedDotOpt();
  public oidb_0x791.SetRedDotOpt msg_set_reddot = new oidb_0x791.SetRedDotOpt();
  public oidb_0x791.SetRedDotAppids msg_set_reddot_appids = new oidb_0x791.SetRedDotAppids();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0x791.oidb_0x791.ReqBody
 * JD-Core Version:    0.7.0.1
 */