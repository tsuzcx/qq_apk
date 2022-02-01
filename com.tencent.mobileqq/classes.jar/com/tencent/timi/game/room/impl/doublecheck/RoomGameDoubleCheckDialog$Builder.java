package com.tencent.timi.game.room.impl.doublecheck;

import android.content.Context;
import java.util.List;
import trpc.yes.common.YoloRoomOuterClass.YoloRoomDoubleCheckPlayer;

public class RoomGameDoubleCheckDialog$Builder
{
  private Context a;
  
  public RoomGameDoubleCheckDialog$Builder(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public RoomGameDoubleCheckDialog a(long paramLong1, List<YoloRoomOuterClass.YoloRoomDoubleCheckPlayer> paramList, long paramLong2)
  {
    RoomGameDoubleCheckDialog localRoomGameDoubleCheckDialog = new RoomGameDoubleCheckDialog(this.a);
    localRoomGameDoubleCheckDialog.a(paramLong1);
    localRoomGameDoubleCheckDialog.a(paramList, paramLong2);
    localRoomGameDoubleCheckDialog.setCancelable(false);
    return localRoomGameDoubleCheckDialog;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.doublecheck.RoomGameDoubleCheckDialog.Builder
 * JD-Core Version:    0.7.0.1
 */