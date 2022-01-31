package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xaa$MsgBody
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "cmd", "msg_gameTeamMsg" }, new Object[] { Integer.valueOf(0), null }, MsgBody.class);
  public final PBUInt32Field cmd = PBField.initUInt32(0);
  public SubMsgType0xaa.GameTeam_MsgBody msg_gameTeamMsg = new SubMsgType0xaa.GameTeam_MsgBody();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.MsgBody
 * JD-Core Version:    0.7.0.1
 */