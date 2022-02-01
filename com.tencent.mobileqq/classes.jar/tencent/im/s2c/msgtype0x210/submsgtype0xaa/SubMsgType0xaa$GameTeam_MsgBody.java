package tencent.im.s2c.msgtype0x210.submsgtype0xaa;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SubMsgType0xaa$GameTeam_MsgBody
  extends MessageMicro<GameTeam_MsgBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "uint32_GameTeamCmd", "msg_turnOverMessage", "msg_startGameMessage", "msg_updateTeamMessage" }, new Object[] { Integer.valueOf(0), null, null, null }, GameTeam_MsgBody.class);
  public SubMsgType0xaa.GameTeam_StartGameMessage msg_startGameMessage = new SubMsgType0xaa.GameTeam_StartGameMessage();
  public SubMsgType0xaa.GameTeam_TurnOverMessage msg_turnOverMessage = new SubMsgType0xaa.GameTeam_TurnOverMessage();
  public SubMsgType0xaa.GameTeam_UpdateTeamMessage msg_updateTeamMessage = new SubMsgType0xaa.GameTeam_UpdateTeamMessage();
  public final PBUInt32Field uint32_GameTeamCmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.s2c.msgtype0x210.submsgtype0xaa.SubMsgType0xaa.GameTeam_MsgBody
 * JD-Core Version:    0.7.0.1
 */