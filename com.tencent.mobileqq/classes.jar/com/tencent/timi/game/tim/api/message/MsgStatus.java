package com.tencent.timi.game.tim.api.message;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/message/MsgStatus;", "", "number", "", "(Ljava/lang/String;II)V", "SENDING", "SUCCESS", "FAILED", "DELETE", "REVOKE", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public enum MsgStatus
{
  static
  {
    MsgStatus localMsgStatus1 = new MsgStatus("SENDING", 0, 1);
    SENDING = localMsgStatus1;
    MsgStatus localMsgStatus2 = new MsgStatus("SUCCESS", 1, 2);
    SUCCESS = localMsgStatus2;
    MsgStatus localMsgStatus3 = new MsgStatus("FAILED", 2, 3);
    FAILED = localMsgStatus3;
    MsgStatus localMsgStatus4 = new MsgStatus("DELETE", 3, 274);
    DELETE = localMsgStatus4;
    MsgStatus localMsgStatus5 = new MsgStatus("REVOKE", 4, 275);
    REVOKE = localMsgStatus5;
    $VALUES = new MsgStatus[] { localMsgStatus1, localMsgStatus2, localMsgStatus3, localMsgStatus4, localMsgStatus5 };
  }
  
  private MsgStatus(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.message.MsgStatus
 * JD-Core Version:    0.7.0.1
 */