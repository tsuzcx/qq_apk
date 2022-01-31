package tencent.im;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class apollo_game_status$STCMGameMessage
  extends MessageMicro<STCMGameMessage>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50, 58, 66 }, new String[] { "uint32_msg_cmd", "msg_comm", "msg_0x01", "msg_0x02", "msg_0x03", "msg_0x04", "msg_0x05", "msg_0x06" }, new Object[] { Integer.valueOf(0), null, null, null, null, null, null, null }, STCMGameMessage.class);
  public apollo_game_status.STCMGameMessage.STGameJoinRoom msg_0x01 = new apollo_game_status.STCMGameMessage.STGameJoinRoom();
  public apollo_game_status.STCMGameMessage.STGameQuitRoom msg_0x02 = new apollo_game_status.STCMGameMessage.STGameQuitRoom();
  public apollo_game_status.STCMGameMessage.STGameStart msg_0x03 = new apollo_game_status.STCMGameMessage.STGameStart();
  public apollo_game_status.STCMGameMessage.STGameOver msg_0x04 = new apollo_game_status.STCMGameMessage.STGameOver();
  public apollo_game_status.STCMGameMessage.STGameInvalid msg_0x05 = new apollo_game_status.STCMGameMessage.STGameInvalid();
  public apollo_game_status.STCMGameMessage.STGameCancel msg_0x06 = new apollo_game_status.STCMGameMessage.STGameCancel();
  public apollo_game_status.STCMGameMessage.STMsgComm msg_comm = new apollo_game_status.STCMGameMessage.STMsgComm();
  public final PBUInt32Field uint32_msg_cmd = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tencent.im.apollo_game_status.STCMGameMessage
 * JD-Core Version:    0.7.0.1
 */