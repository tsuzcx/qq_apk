package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class oidb_0xa28$RspBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_profile_info", "msg_game_info" }, new Object[] { null, null }, RspBody.class);
  public oidb_0xa28.HonourInfo msg_game_info = new oidb_0xa28.HonourInfo();
  public oidb_0xa28.Profile msg_profile_info = new oidb_0xa28.Profile();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa28.oidb_0xa28.RspBody
 * JD-Core Version:    0.7.0.1
 */