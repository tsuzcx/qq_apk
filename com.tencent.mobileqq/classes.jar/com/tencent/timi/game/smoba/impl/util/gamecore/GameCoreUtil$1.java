package com.tencent.timi.game.smoba.impl.util.gamecore;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class GameCoreUtil$1
  implements DialogInterface.OnClickListener
{
  GameCoreUtil$1(GameInstallCheckCallback paramGameInstallCheckCallback) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = this.a;
    if (paramDialogInterface != null) {
      paramDialogInterface.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.smoba.impl.util.gamecore.GameCoreUtil.1
 * JD-Core Version:    0.7.0.1
 */