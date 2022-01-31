package tencent.im.oidb.cmd0x877;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0x877$RspBody
  extends MessageMicro<RspBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "interact_info", "follow_info" }, new Object[] { null, null }, RspBody.class);
  public oidb_0x877.FollowInfo follow_info = new oidb_0x877.FollowInfo();
  public oidb_0x877.InteractInfo interact_info = new oidb_0x877.InteractInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     tencent.im.oidb.cmd0x877.oidb_0x877.RspBody
 * JD-Core Version:    0.7.0.1
 */