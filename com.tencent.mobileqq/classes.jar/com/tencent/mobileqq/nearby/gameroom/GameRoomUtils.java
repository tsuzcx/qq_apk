package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRoute;

public class GameRoomUtils
{
  public static void a(Context paramContext, int paramInt)
  {
    ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).enterNewGame(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomUtils
 * JD-Core Version:    0.7.0.1
 */