package com.tencent.qqmini.sdk.manager;

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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.DialogAction
 * JD-Core Version:    0.7.0.1
 */