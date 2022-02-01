package com.tencent.tavcut.render.player;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tavcut/render/player/IPlayer$PlayerStatus;", "", "(Ljava/lang/String;I)V", "IDLE", "READY", "PLAYING", "STOPPED", "PAUSED", "FINISHED", "ERROR", "REPLAY", "lib_tavcut_release"}, k=1, mv={1, 1, 16})
public enum IPlayer$PlayerStatus
{
  static
  {
    PlayerStatus localPlayerStatus1 = new PlayerStatus("IDLE", 0);
    IDLE = localPlayerStatus1;
    PlayerStatus localPlayerStatus2 = new PlayerStatus("READY", 1);
    READY = localPlayerStatus2;
    PlayerStatus localPlayerStatus3 = new PlayerStatus("PLAYING", 2);
    PLAYING = localPlayerStatus3;
    PlayerStatus localPlayerStatus4 = new PlayerStatus("STOPPED", 3);
    STOPPED = localPlayerStatus4;
    PlayerStatus localPlayerStatus5 = new PlayerStatus("PAUSED", 4);
    PAUSED = localPlayerStatus5;
    PlayerStatus localPlayerStatus6 = new PlayerStatus("FINISHED", 5);
    FINISHED = localPlayerStatus6;
    PlayerStatus localPlayerStatus7 = new PlayerStatus("ERROR", 6);
    ERROR = localPlayerStatus7;
    PlayerStatus localPlayerStatus8 = new PlayerStatus("REPLAY", 7);
    REPLAY = localPlayerStatus8;
    $VALUES = new PlayerStatus[] { localPlayerStatus1, localPlayerStatus2, localPlayerStatus3, localPlayerStatus4, localPlayerStatus5, localPlayerStatus6, localPlayerStatus7, localPlayerStatus8 };
  }
  
  private IPlayer$PlayerStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavcut.render.player.IPlayer.PlayerStatus
 * JD-Core Version:    0.7.0.1
 */