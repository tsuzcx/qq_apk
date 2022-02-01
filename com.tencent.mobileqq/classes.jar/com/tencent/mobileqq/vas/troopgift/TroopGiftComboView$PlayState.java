package com.tencent.mobileqq.vas.troopgift;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/vas/troopgift/TroopGiftComboView$PlayState;", "", "(Ljava/lang/String;I)V", "PLAY_NONE", "PLAYING", "PLAYED", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public enum TroopGiftComboView$PlayState
{
  static
  {
    PlayState localPlayState1 = new PlayState("PLAY_NONE", 0);
    PLAY_NONE = localPlayState1;
    PlayState localPlayState2 = new PlayState("PLAYING", 1);
    PLAYING = localPlayState2;
    PlayState localPlayState3 = new PlayState("PLAYED", 2);
    PLAYED = localPlayState3;
    $VALUES = new PlayState[] { localPlayState1, localPlayState2, localPlayState3 };
  }
  
  private TroopGiftComboView$PlayState() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopgift.TroopGiftComboView.PlayState
 * JD-Core Version:    0.7.0.1
 */