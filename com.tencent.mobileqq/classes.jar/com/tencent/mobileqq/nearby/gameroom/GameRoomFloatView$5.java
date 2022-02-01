package com.tencent.mobileqq.nearby.gameroom;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

class GameRoomFloatView$5
  extends BroadcastReceiver
{
  GameRoomFloatView$5(GameRoomFloatView paramGameRoomFloatView) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("SmallScreenState", 0);
    if (i == 3) {
      this.a.a.setVisibility(4);
    }
    while ((i != 2) && (i != 0)) {
      return;
    }
    this.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomFloatView.5
 * JD-Core Version:    0.7.0.1
 */