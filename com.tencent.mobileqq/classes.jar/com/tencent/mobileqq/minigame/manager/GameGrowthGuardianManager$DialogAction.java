package com.tencent.mobileqq.minigame.manager;

import android.content.DialogInterface.OnClickListener;

class GameGrowthGuardianManager$DialogAction
{
  private final DialogInterface.OnClickListener onClickListener;
  private final int stringResId;
  
  GameGrowthGuardianManager$DialogAction(int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    this.stringResId = paramInt;
    this.onClickListener = paramOnClickListener;
  }
  
  public DialogInterface.OnClickListener getOnClickListener()
  {
    return this.onClickListener;
  }
  
  int getStringResId()
  {
    return this.stringResId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.DialogAction
 * JD-Core Version:    0.7.0.1
 */