package com.tencent.qqmini.sdk.manager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class GameGrowthGuardianManager$DialogStateChecker$1
  extends Handler
{
  GameGrowthGuardianManager$DialogStateChecker$1(GameGrowthGuardianManager.DialogStateChecker paramDialogStateChecker, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    if (paramMessage.what == 10001) {
      GameGrowthGuardianManager.DialogStateChecker.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.DialogStateChecker.1
 * JD-Core Version:    0.7.0.1
 */