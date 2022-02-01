package com.tencent.timi.game.room.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class YoloRoomManager$40
  implements DialogInterface.OnDismissListener
{
  YoloRoomManager$40(YoloRoomManager paramYoloRoomManager) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (YoloRoomManager.h(this.a) == paramDialogInterface) {
      YoloRoomManager.a(this.a, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.room.impl.YoloRoomManager.40
 * JD-Core Version:    0.7.0.1
 */