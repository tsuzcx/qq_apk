package com.tencent.qqmini.minigame.report;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/minigame/report/GameStopType;", "", "reportValue", "", "(Ljava/lang/String;II)V", "getReportValue", "()I", "CAPSULE_BUTTON", "BACK_PRESS", "HOME_PRESS", "RECENT_PRESS", "SCREEN_OFF", "lib_minigame_internalRelease"}, k=1, mv={1, 1, 16})
public enum GameStopType
{
  private final int reportValue;
  
  static
  {
    GameStopType localGameStopType1 = new GameStopType("CAPSULE_BUTTON", 0, 1);
    CAPSULE_BUTTON = localGameStopType1;
    GameStopType localGameStopType2 = new GameStopType("BACK_PRESS", 1, 2);
    BACK_PRESS = localGameStopType2;
    GameStopType localGameStopType3 = new GameStopType("HOME_PRESS", 2, 3);
    HOME_PRESS = localGameStopType3;
    GameStopType localGameStopType4 = new GameStopType("RECENT_PRESS", 3, 4);
    RECENT_PRESS = localGameStopType4;
    GameStopType localGameStopType5 = new GameStopType("SCREEN_OFF", 4, 5);
    SCREEN_OFF = localGameStopType5;
    $VALUES = new GameStopType[] { localGameStopType1, localGameStopType2, localGameStopType3, localGameStopType4, localGameStopType5 };
  }
  
  private GameStopType(int paramInt)
  {
    this.reportValue = paramInt;
  }
  
  public final int getReportValue()
  {
    return this.reportValue;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.minigame.report.GameStopType
 * JD-Core Version:    0.7.0.1
 */