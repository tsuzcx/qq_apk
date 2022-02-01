package com.tencent.timi.game.tim.api.group;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/tim/api/group/ReceiveMsgOpt;", "", "(Ljava/lang/String;I)V", "RECEIVE_MSG", "NOT_RECEIVE_MSG", "RECEIVE_NOT_NOTIFY_MSG", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public enum ReceiveMsgOpt
{
  static
  {
    ReceiveMsgOpt localReceiveMsgOpt1 = new ReceiveMsgOpt("RECEIVE_MSG", 0);
    RECEIVE_MSG = localReceiveMsgOpt1;
    ReceiveMsgOpt localReceiveMsgOpt2 = new ReceiveMsgOpt("NOT_RECEIVE_MSG", 1);
    NOT_RECEIVE_MSG = localReceiveMsgOpt2;
    ReceiveMsgOpt localReceiveMsgOpt3 = new ReceiveMsgOpt("RECEIVE_NOT_NOTIFY_MSG", 2);
    RECEIVE_NOT_NOTIFY_MSG = localReceiveMsgOpt3;
    $VALUES = new ReceiveMsgOpt[] { localReceiveMsgOpt1, localReceiveMsgOpt2, localReceiveMsgOpt3 };
  }
  
  private ReceiveMsgOpt() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.tim.api.group.ReceiveMsgOpt
 * JD-Core Version:    0.7.0.1
 */